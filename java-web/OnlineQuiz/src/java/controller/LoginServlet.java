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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import dao.UserDAO;

/**
 *
 * @author datdu
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAOImpl();

        try {
            // check if the username and password entered by the user match the database
            User account = userDAO.get(userName, password);

            // If this user does not exist
            // then forward to error page
            if (account == null) {
                throw new Exception();
            } else {
                // If correct then save user logged to session
                HttpSession session = request.getSession();
                session.setAttribute("accountlogged", account);

                // Redirect to homepage
                response.sendRedirect("home");
            }
        } catch (Exception ex) {
            // show the message if client input incorrect value
            request.setAttribute("ms", "Account or password incorrect!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
