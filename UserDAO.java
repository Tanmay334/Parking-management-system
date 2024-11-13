package com.parking.dao;


import com.parking.dbconnection.dbconnection;
import com.parking.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to register a new user
    public boolean registerUser(User user) {
        if (isUserExists(user.getUsername())) {
            return false; // User already exists
        }

        String insertSQL = "INSERT INTO usertable(username, password) VALUES (?, ?)";
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword()); // Consider hashing the password.
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Registration successful if rows are affected
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Registration failed
    }

    // Method to check if user already exists
    private boolean isUserExists(String username) {
        String sql = "SELECT * FROM usertable WHERE username = ?";
        try (Connection connection = dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Return true if user exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


