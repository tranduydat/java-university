/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * DigitalNews<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-07-01    1.0        DatDuyTran       Release 1.0<br>
 */
package controller;

import dao.PostDAO;
import dao.impl.PostDAOImpl;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;

/**
 * Process:<br>
 * 1. Get latest post to display its excerpt below 'Digital News' title<br>
 * 2. Get list of latest posts (except the one above)<br>
 * 3. Get all posts which have a given keyword
 *
 * @author DatDuyTran
 */
public class SearchServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String searchKeyword = request.getParameter("keyword");

            // Check does keyword empty or not
            if (searchKeyword == null || searchKeyword.isEmpty()) {
                // Get the referer path
                String refURL = request.getHeader("referer");
                String refPath = refURL.substring(refURL.lastIndexOf("/") + 1);
                
                // Return to the previous path
                response.sendRedirect(refPath);
            } else {
                PostDAO postDAO = new PostDAOImpl();

                // Get the search result
                List<Post> result = postDAO.search(searchKeyword);

                // Get the list of 5 latest posts 
                // to display beside in the sidebar
                List< Post> listOfLatestPosts = postDAO.getListOfLatests(5);
                // Get the latest post to display in digital news section
                Post latestPost = listOfLatestPosts.get(0);

                request.setAttribute("result", result);
                request.setAttribute("listOfLatestPosts", listOfLatestPosts);
                request.setAttribute("latestPost", latestPost);

                request.getRequestDispatcher("search.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);

            // Forward request to error page if any exception occurs
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
