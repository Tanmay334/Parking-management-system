package com.parking.servlet;

import com.parking.dao.ParkingVehicleDAO;
import com.parking.model.Booking;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReserveParkingServlet") // This maps the servlet to the specified URL pattern
public class ReserveParkingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parkingID = request.getParameter("parkingID");
        String vehicleName = request.getParameter("vehicleName");
        String vehicleNumber = request.getParameter("vehicleNumber");

        // Create a new Booking object with the provided data
        Booking booking = new Booking(parkingID, vehicleName, vehicleNumber);

        try {
            // Instantiate ParkingVehicleDAO to handle the booking
            ParkingVehicleDAO parkingVehicleDAO = new ParkingVehicleDAO();
            boolean isBooked = parkingVehicleDAO.bookParking(booking);

            // Redirect based on whether the booking was successful
            if (isBooked) {
                response.sendRedirect("bookingsuccess.jsp");
            } else {
                response.sendRedirect("bookingError.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("bookingsuccess.jsp"); // Redirect to error page if an exception occurs
        }
    }
}
