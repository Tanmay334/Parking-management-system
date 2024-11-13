package com.parking.dao;

import com.parking.model.UserRetrieve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRetrieveDAO {
    private Connection connection;

    public UserRetrieveDAO(Connection connection) {
        this.connection = connection;
    }

    public List<UserRetrieve> getAllUsers() {
        List<UserRetrieve> users = new ArrayList<>();
        String query = "SELECT id, username, password FROM usertable";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                users.add(new UserRetrieve(id, username, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
