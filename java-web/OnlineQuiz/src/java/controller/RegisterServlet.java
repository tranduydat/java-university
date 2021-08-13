/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-07-16    1.0        DatDuyTran       Release 1.0<br>
 */
package controller;

import dao.impl.UserDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import dao.UserDAO;

/**
 *
 * @author datdu
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    /**
     * This method adds the user to the MEMBER table in the database. The input
     * data will be normalized (trim space) before access to the database.
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request provides important information about a client request to a
     * server. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * @param response respond to an HTTP request to the browser. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get neccesarry data from request parameters
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String roleName = request.getParameter("role-name");
        String email = request.getParameter("email").trim();

        int roleID;
        if (roleName.equals("teacher")) {
            roleID = 1;
        } else {
            roleID = 2;
        }

        // create new member object
        User user = new User(
                username,
                password,
                roleID,
                email
        );

        UserDAO userDAO = new UserDAOImpl();

        try {
            // Get all the users from database
            List<User> listOfUsers = userDAO.getAll();

            // Check does this user exist or not
            if (userDAO.doesExist(user, listOfUsers)) {
                // If this user does exist, then throw error 
                // and forward to error page
                throw new Exception();
            } else {
                try {
                    userDAO.add(user);

                    // Forward to notify page
                    request.setAttribute("page", "SUCCESS");
                    request.setAttribute("ms", "User " + user.getUsername() + " register successfully!");
                    request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
                } catch (Exception ex) {
                    // Otherwise it will be returned to error page
                    // if any error has occur
                    request.setAttribute("page", "ERROR");
                    request.setAttribute("ms", ex.toString());
                    request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            // Otherwise it will be returned to error page
            // if any error has occur
            request.setAttribute("page", "ERROR");
            request.setAttribute("ms", "Member is existed on system!");
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        }
    }

}
