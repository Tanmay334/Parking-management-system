package com.parking.model;

public class Booking {
    private String parkingID;
    private String vehicleName;
    private String vehicleNumber;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor (optional)
    public Booking(String parkingID, String vehicleName, String vehicleNumber) {
        this.parkingID = parkingID;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    // Getters and Setters
    public String getParkingID() {
        return parkingID;
    }

    public void setParkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
