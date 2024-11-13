package com.parking.servlet;

import com.parking.service.DiscountService;
import com.parking.dao.ParkingDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;

@WebServlet("/applyCoupon")
public class CouponController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String couponCode = request.getParameter("couponCode");
        boolean isFirstTimeUser = (boolean) request.getSession().getAttribute("isFirstTimeUser");
        double parkingAmount = Double.parseDouble(request.getParameter("parkingAmount"));
        
        // Apply discounts based on coupon code and user type (first-time user)
        DiscountService discountService = new DiscountService();
        double finalAmount = discountService.applyDiscount(parkingAmount, couponCode, isFirstTimeUser);
        
        // Save the final amount after discount
        request.setAttribute("finalAmount", finalAmount);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}
