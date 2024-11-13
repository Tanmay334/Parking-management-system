package com.parking.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dbconnection.dbconnection;

// Replace 'your.package' with your actual package name
@WebServlet("/ParkingServlet")
public class ParkingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String parkingID = request.getParameter("parkingID");
        String location = request.getParameter("location");
        int availableSpots = Integer.parseInt(request.getParameter("availableSpots"));

        // Establish connection
        try (Connection conn = new dbconnection().getConnection()) {
            // SQL query to insert a new parking space
            String sql = "INSERT INTO parking (parkingID, location, availableSpots) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, parkingID);
                stmt.setString(2, location);
                stmt.setInt(3, availableSpots);

                // Execute update and check if it was successful
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("success.jsp"); // Redirect to success page
                } else {
                    response.sendRedirect("error.jsp"); // Redirect to error page if insertion fails
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page if SQL exception occurs
        }
    }
}
