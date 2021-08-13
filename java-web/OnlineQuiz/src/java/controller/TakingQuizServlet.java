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
import model.Question;
import dao.QuestionDAO;

/**
 *
 * @author datdu
 */
public class TakingQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("takequiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QuestionDAO questionDAO = new QuestionDAOImpl();

        // Get number of question to check if the user entered 
        // the number of input questions ok or not
        int numberOfQuestions;

        try {
            String strNumberOfQuestion = request.getParameter("numberOfQuestions");
            numberOfQuestions = Integer.parseInt(strNumberOfQuestion);
        } catch (NumberFormatException e) {
            numberOfQuestions = 0;
        }

        // Get all possible answer from request parameters
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

        // Get pageAfter parameter from request
        // If it is != null, then an user still doing quiz
        String page;
        try {
            page = request.getParameter("pageAfter");
        } catch (Exception e) {
            page = null;
        }

        // Get the total number of questions in database
        if (page == null) {
            try {
                int totalQuestions = questionDAO.count();

                // check if the user entered the number of input questions ok or not
                if (numberOfQuestions <= totalQuestions && numberOfQuestions > 0) {
                    System.out.println("DONE: Before doQuiz()");
                    doQuiz(request, response, numberOfQuestions, page, false, answer);
                } else {
                    request.setAttribute("message", "Input number must in range from 0 to " + totalQuestions);
                    request.getRequestDispatcher("takequiz.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("message", ex.toString());
                request.setAttribute("page", "ERROR");
                request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
            }
        } else {
            //if != null is doing quiz. This method will be called 
            //when the total number of questions called is enough
            doQuiz(request, response, numberOfQuestions, page, true, answer);
        }

    }

    protected void doQuiz(HttpServletRequest request, HttpServletResponse response, int numberOfQuestions, String page, boolean doing, String answer)
            throws ServletException, IOException {

        QuestionDAO questionDAO = new QuestionDAOImpl();

        // set page to call question (1 question for 1 page)
        if (page == null || page.equals("")) {
            page = "1";
        }

        // Get for result page
        // when numbercorrect = null it mean when user start do first quiz
        // numbercorrect = 0 it mean when user doing quiz (2nd and up)
        int numberCorrect = 0;
        try {
            if (request.getParameter("numberCorrect") == null) {
            } else {
                numberCorrect = Integer.parseInt(request.getParameter("numberCorrect"));
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("ms", "Failed to parse numberCorrect"
                    + " from request parameter in TakingQuizServlet");
            request.setAttribute("page", "ERROR");
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        }

        if (doing) {
            try {
                // get before quiz and answer just submit
                // because the question is called first 
                // and its answer is called later, we have to call the question again
                Question questionBefore = questionDAO.getForEachPage(Integer.parseInt(page) - 1);

                numberCorrect += caculateQuizPoint(questionBefore, answer);
            } catch (Exception ex) {
                request.setAttribute("ms", ex.toString());
                request.setAttribute("page", "ERROR");
                request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
            }
        }

        // Page is pageAfter of this quiz doing
        // when numberQuestiong + 1 = pageAfter it mean user is taking LAST QUIZ
        int intPage = 0;
        try {
            intPage = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            request.setAttribute("ms", "Failed to parse page to intPage in TakingQuizServlet");
            request.setAttribute("page", "ERROR");
            request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
        }

        if (intPage == (numberOfQuestions + 1)) {
            System.out.println("INSIDE doQuiz(): Integer.parseInt(page) == (numberOfQuestions + 1)");

            // Get the score of the current session
            double score = (double) Math.round(getScore(numberCorrect, numberOfQuestions) * 100) / 100;

            // Show the result page of the current session
            getResult(request, response, score);
        } else {
            try {
                // Get quiz for eachpage, 1 question per page
                Question questionEachPage = questionDAO.getForEachPage(intPage);

                System.out.println("After questionEachPage");

                // Save number question
                request.setAttribute("numberOfQuestions", numberOfQuestions);

                // Save numberCorrect
                request.setAttribute("numberCorrect", numberCorrect);

                // Set page after for the next quiz and for the check when done current session
                request.setAttribute("pageAfter", (Integer.parseInt(page) + 1));
                request.setAttribute("question", questionEachPage);
                request.getRequestDispatcher("doquiz.jsp").forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("ms", ex.toString());
                request.setAttribute("page", "ERROR");
                request.getRequestDispatcher("notificationpage.jsp").forward(request, response);
            }
            request.getRequestDispatcher("doquiz.jsp").forward(request, response);
        }
    }

    protected void getResult(HttpServletRequest request, HttpServletResponse response, double score)
            throws ServletException, IOException {
        request.setAttribute("score", score);
        request.getRequestDispatcher("resultquiz.jsp").forward(request, response);
    }

    public boolean checkCorrectQuiz(Question question, String answer) {
        return question.getAnswer().equals(answer);
    }

    public int caculateQuizPoint(Question question, String answer) {
        char arrayOfTruthAnswer[] = question.getAnswer().toCharArray();
        char arrayOfUserAnswer[] = answer.toCharArray();

        int point = 0;

        for (int i = 0; i <= 3; i++) {
            if ((int) arrayOfTruthAnswer[i] == (int) arrayOfUserAnswer[i]) {
                point++;
            }
        }
        return point;
    }

    public double getScore(int correct, int total) {
        return (double) correct / (total * 4);
    }
}
