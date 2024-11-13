package com.parking.servlet;

import com.parking.dao.AdminDAO;
import com.parking.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin(username, password);

        // Validate the admin credentials
        if (adminDAO.validateAdmin(admin)) {
            // Redirect to the admin dashboard or any other protected page
            response.sendRedirect("adminDashboard.jsp");
        } else {
            // If invalid login, redirect back to login page with an error message
            response.sendRedirect("adminLogin.jsp?error=true");
        }
    }
}
