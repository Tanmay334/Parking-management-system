package com.parking.servlet;

import com.parking.dao.ContactDAO;
import com.parking.model.ContactModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle the POST request from the contact form
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        // Create a ContactModel object and set the data
        ContactModel contact = new ContactModel(name, email, phone, message);

        // Create a ContactDAO object to save data in the database
        ContactDAO contactDAO = new ContactDAO();

        // Save the contact data and set a success or failure message
        boolean isSaved = contactDAO.saveContact(contact);

        // Redirect to a thank you page if the data is saved successfully
        if (isSaved) {
            response.sendRedirect("thankYou.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
