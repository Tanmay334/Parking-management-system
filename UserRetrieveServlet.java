package com.parking.servlet;

import com.parking.dao.UserRetrieveDAO;
import com.parking.dbconnection.dbconnection;
import com.parking.model.UserRetrieve;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/UserRetrieveServlet")
public class UserRetrieveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection connection = dbconnection.getConnection();
            UserRetrieveDAO userDAO = new UserRetrieveDAO(connection);

            List<UserRetrieve> users = userDAO.getAllUsers();
            request.setAttribute("users", users);

            request.getRequestDispatcher("numberofuser.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
