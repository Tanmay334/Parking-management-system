package com.parking.dao;

import com.parking.dbconnection.dbconnection;
import com.parking.model.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingVehicleDAO {
    private Connection connection;

    public ParkingVehicleDAO() throws SQLException {
        connection = dbconnection.getConnection(); // Ensure DatabaseConnection provides a valid connection
    }

    // Method to insert a booking into the database
    public boolean bookParking(Booking booking) {
        String sql = "INSERT INTO bookings (parkingID, vehicleName, vehicleNumber) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, booking.getParkingID());
            stmt.setString(2, booking.getVehicleName());
            stmt.setString(3, booking.getVehicleNumber());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // returns true if booking was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // returns false if there was an error
        }
    }
}
