package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parking.dbconnection.dbconnection;
import com.parking.model.Parking;


public class ParkingDAO {
	  public ParkingDAO() {
	        // No parameters, simple constructor
	    }

    public List<Parking> getAllBookings() {
        List<Parking> bookings = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Assuming DBConnection is a utility class for database connection
            conn = dbconnection.getConnection();

            // SQL query to fetch the parking bookings data
            String query = "SELECT id, parkingID, location, availableSpots FROM parking";  // Adjust the table name if needed
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Loop through result set and populate Parking objects
            while (rs.next()) {
                Parking parking = new Parking(
                    rs.getInt("id"),
                    rs.getString("parkingID"),
                    rs.getString("location"),
                    rs.getInt("availableSpots")
                );
                bookings.add(parking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bookings;
    }
}
