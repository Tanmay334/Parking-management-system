package com.parking.model;

public class Parking {
    private int id;
    private String parkingID;
    private String location;
    private int availableSpots;

    // Constructor
    public Parking(int id, String parkingID, String location, int availableSpots) {
        this.id = id;
        this.parkingID = parkingID;
        this.location = location;
        this.availableSpots = availableSpots;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for parkingID
    public String getParkingID() {
        return parkingID;
    }

    public void setParkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for availableSpots
    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    // Optional: Override toString() for better representation
    @Override
    public String toString() {
        return "Parking [id=" + id + ", parkingID=" + parkingID + ", location=" + location + ", availableSpots="
                + availableSpots + "]";
    }
}
