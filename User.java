package com.parking.model;

public class User {
    private String username;
    private String password; // Consider hashing passwords in a real application

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
