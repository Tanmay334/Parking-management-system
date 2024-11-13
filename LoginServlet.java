package com.parking.servlet;

import com.parking.dao.UserDAO;
import com.parking.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        if (userDAO.registerUser(user)) {
        	   
            request.getRequestDispatcher("userparkingbookingslot.jsp").forward(request, response);
        } else {
            response.getWriter().write("User already exists!");
        }
    }
}



