package com.parking.dao;

import com.parking.model.Admin;

import com.parking.dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    // Method to validate admin login (check if the admin exists with the correct username and password)
    public boolean validateAdmin(Admin admin) {
        // Query to check if the provided username exists in the database
        String sql = "SELECT * FROM admin WHERE username = ?";

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, admin.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a record is found, validate the password
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                // Use hashing in a real-world scenario. For now, we are directly comparing passwords.
                if (storedPassword.equals(admin.getPassword())) {
                    return true; // Valid credentials
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Invalid username/password combination
    }
}
