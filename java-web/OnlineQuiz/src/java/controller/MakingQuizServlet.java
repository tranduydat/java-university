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

import dao.impl.QuestionDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.Question;
import dao.QuestionDAO;

/**
 *
 * @author datdu
 */
public class MakingQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("makequiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Returns the valid session object associated with the request
        HttpSession session = request.getSession();

        // Get member logged in
        User user = (User) session.getAttribute("accountlogged");

        // Get question content
        String content = request.getParameter("content");

        // Get all possible answers
        String option1 = request.getParameter("option1").trim();
        String option2 = request.getParameter("option2").trim();
        String option3 = request.getParameter("option3").trim();
        String option4 = request.getParameter("option4").trim();

        // Get the answer for the correct answer, 1 is correct and 0 is incorrect
        String op1 = request.getParameter("op1");
        String op2 = request.getParameter("op2");
        String op3 = request.getParameter("op3");
        String op4 = request.getParameter("op4");

        // If an option is true, then map it to 1
        // else map it to 0
        if (op1 == null) {
            op1 = "0";
        }
        if (op2 == null) {
            op2 = "0";
        }
        if (op3 == null) {
            op3 = "0";
        }
        if (op4 == null) {
            op4 = "0";
        }

        String answer = op1 + op2 + op3 + op4;

        // Create new question object
        Question question = new Question(
                content,
                option1,
                option2,
                option3,
                option4,
                answer,
                user.getUserID()
        );

        QuestionDAO questionDAO = new QuestionDAOImpl();

        try {
            // Add question to questions table in the database
            questionDAO.add(question);

            // Notify the user to add a successful question
            // then forward to notify page
            request.setAttribute("page", "SUCCESS");
            request.setAttribute("ms", "insert quiz successfully!");
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        } catch (Exception ex) {
            // Otherwise it will be returned to error page
            // if any error has occur
            request.setAttribute("page", "ERROR");
            request.setAttribute("ms", ex.toString());
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        }
    }
}
