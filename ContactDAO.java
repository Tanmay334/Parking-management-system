package com.parking.dao;

import com.parking.model.ContactModel;

import com.parking.dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {
    public boolean saveContact(ContactModel contact) {
        boolean isSaved = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Get database connection
            conn = dbconnection.getConnection();

            // SQL query to insert contact data into the database
            String query = "INSERT INTO contactus (name, email, phone, message) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getMessage());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isSaved = true;  // Data successfully saved
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSaved;
    }
}
