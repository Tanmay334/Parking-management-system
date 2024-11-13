package com.parking.service;

public class DiscountService {

    public double applyDiscount(double parkingAmount, String couponCode, boolean isFirstTimeUser) {
        double discount = 0;
        
        // Check if coupon is valid
        if (couponCode != null && couponCode.equals("WELCOME10")) {
            discount = parkingAmount * 0.10; // 10% off
        }
        
        // Additional discount for first-time users
        if (isFirstTimeUser) {
            discount += parkingAmount * 0.05; // Additional 5% off for first-time users
        }
        
        return parkingAmount - discount;
    }
}
