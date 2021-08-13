/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-25    1.0        DatDuyTran       Release 1.0<br>
 */
package dao.impl;

import dao.AbstractDAO;
import dao.GalleryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Gallery;

/**
 *
 * @author datdu
 */
public class GalleryDAOImpl extends AbstractDAO implements GalleryDAO {

    /**
     * Get all the galleries in database by given number
     *
     * @param numberOfGalleries the number of galleries you want to get
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    @Override
    public List<Gallery> getAll(int numberOfGalleries) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT TOP (?) [id], [title], [thumbnail],"
                    + " [description], [author_id]"
                    + " FROM [galleries]";

            statement = conn.prepareStatement(query);
            statement.setInt(1, numberOfGalleries);
            rs = statement.executeQuery();

            List<Gallery> listOfGalleries = new ArrayList<>();

            while (rs.next()) {
                listOfGalleries.add(new Gallery(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("thumbnail"),
                        rs.getString("description"),
                        rs.getInt("author_id")
                ));
            }

            return listOfGalleries;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(GalleryDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                throw ex;
            }
        }
    }

    /**
     * Get all the galleries from database
     *
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    @Override
    public List<Gallery> getAll() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT [id], [title], [thumbnail],"
                    + " [description], [author_id]"
                    + " FROM [galleries]";

            statement = conn.prepareStatement(query);
            rs = statement.executeQuery();

            List<Gallery> listOfGalleries = new ArrayList<>();

            while (rs.next()) {
                listOfGalleries.add(new Gallery(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("thumbnail"),
                        rs.getString("description"),
                        rs.getInt("author_id")
                ));
            }

            return listOfGalleries;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(GalleryDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                throw ex;
            }
        }
    }

    /**
     * Get a gallery by given ID
     *
     * @param id a gallery's id you want to get
     * @return a <code>Gallery</code> object, if it does not exists then return
     * <code>null</code>
     * @throws Exception
     */
    @Override
    public Gallery getById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT [id], [title], [thumbnail],"
                    + " [description], [author_id]"
                    + " FROM [galleries]"
                    + " WHERE [id] = ?";

            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                return new Gallery(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("thumbnail"),
                        rs.getString("description"),
                        rs.getInt("author_id")
                );
            }

            return null;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(GalleryDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                throw ex;
            }
        }
    }
}
