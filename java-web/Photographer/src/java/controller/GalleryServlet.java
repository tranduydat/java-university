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

import dao.GalleryDAO;
import dao.ImageDAO;
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
import model.Gallery;
import model.ImageList;

/**
 * Process:<br>
 * 1. Get gallery by its id<br>
 * 2. Get list of images corresponding to that gallery<br>
 * 3. Calculate a number of image lines
 *
 * Exception:<br>
 * - If an exception occurs, it will return to the error page
 *
 * @author DatDuyTran
 */
public class GalleryServlet extends HttpServlet {

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
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ImageDAO imageDAO = new ImageDAOImpl();

            // Get the gallery id from the request parameter
            int galleryID = Integer.parseInt(request.getParameter("id"));

            // Get the gallery by its id
            Gallery gallery = galleryDAO.getById(galleryID);

            // Get the images list corresponding to that gallery
            ImageList imageList = imageDAO.getByGalleryId(galleryID);

            // Get top 3 latest galleries
            List<Gallery> listOfGalleries = galleryDAO.getAll(3);

            int numberOfImages = imageList.getImages().size();

            // Get the number of image lines. A line has 4 images
            int numberOfImageLines = (numberOfImages / 4) + (numberOfImages % 4);

            request.setAttribute("galleryID", galleryID);
            request.setAttribute("gallery", gallery);
            request.setAttribute("imageList", imageList);
            request.setAttribute("listOfGalleries", listOfGalleries);
            request.setAttribute("numberOfImageLines", numberOfImageLines);

            request.getRequestDispatcher("gallery.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);

            // Forward request to error page if any exception occurs
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
