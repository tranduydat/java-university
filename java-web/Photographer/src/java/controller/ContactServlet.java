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
import dao.impl.AuthorDAOImpl;
import dao.impl.GalleryDAOImpl;
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

/**
 * Process:<br>
 * 1. Get author info (default is admin)<br>
 * 2. Build strings to form author address for Google Map API<br>
 *
 * @author DatDuyTran
 */
public class ContactServlet extends HttpServlet {

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

            // Get the default user (as admin, id = 1)
            Author author = authorDAO.getById(1);

            // Build the map address for Google Map API
            String mapAddress = author.getAddress() + ","
                    + author.getCity() + "," + author.getCountry();
            mapAddress = mapAddress.replace(' ', '+');

            // Get the list of 3 latest galleries
            List<Gallery> listOfGalleries = galleryDAO.getAll(3);

            // Set attributes before forward
            request.setAttribute("isContact", true);
            request.setAttribute("author", author);
            request.setAttribute("mapAddress", mapAddress);
            request.setAttribute("listOfGalleries", listOfGalleries);

            // Forward request to contact.jsp
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ContactServlet.class.getName()).log(Level.SEVERE, null, ex);

            // Forward request to error page if any exception occurs
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
