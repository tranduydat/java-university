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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import dao.QuestionDAO;

/**
 *
 * @author datdu
 */
public class ManagingQuiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDAO questionDAO = new QuestionDAOImpl();

        try {
            // list is working as a database
            //List<Question> quizs = questionDao.listAllQuestionByAccountID(account.getAccountID());
            List<Question> listOfQuestions = questionDAO.getAll();

            for (Question question : listOfQuestions) {
                System.out.println(question.getContent());
            }

            // Get the number of questions in database
            int numberOfQuestions = questionDAO.count();

            request.setAttribute("numberOfQuestions", numberOfQuestions);
            request.setAttribute("listOfQuestions", listOfQuestions);

            // Forward to managequiz page
            request.getRequestDispatcher("managequiz.jsp").forward(request, response);
        } catch (Exception ex) {
            // Otherwise it will be returned to error page
            // if any error has occur
            request.setAttribute("page", "ERROR");
            request.setAttribute("ms", ex.toString());
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        }
    }
}
