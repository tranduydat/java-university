/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-25    1.0        DatDuyTran       Release 1.0<br>
 */
package controller;

import dao.AuthorDAO;
import dao.GalleryDAO;
import dao.ImageDAO;
import dao.impl.AuthorDAOImpl;
import dao.impl.GalleryDAOImpl;
import dao.impl.ImageDAOImpl;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Author;
import model.Gallery;
import model.Image;

/**
 * Process:<br>
 * 1. Get an author (as admin)<br>
 * 2. Get a random featured image to display on top of home.jsp<br>
 * 3. Get top 3 galleries<br>
 * 4. Set isHome to true<br>
 *
 * Exception:<br>
 * - If an exception occurs, it will return to the error page
 *
 * @author DatDuyTran
 */
public class HomeServlet extends HttpServlet {

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
            AuthorDAO authorDAO = new AuthorDAOImpl();
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ImageDAO imageDAO = new ImageDAOImpl();

            Image featuredImage = imageDAO.getFeatured();
            Author admin = authorDAO.getById(1);
            List<Gallery> listOfGalleries = galleryDAO.getAll(3);

            request.setAttribute("isHome", true);
            request.setAttribute("featuredImage", featuredImage);
            request.setAttribute("author", admin);
            request.setAttribute("listOfGalleries", listOfGalleries);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);

            // Forward request to error page if any exception occurs
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
