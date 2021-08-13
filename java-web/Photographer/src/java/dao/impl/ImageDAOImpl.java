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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;
import model.ImageList;
import dao.ImageDAO;

/**
 *
 * @author datdu
 */
public class ImageDAOImpl extends AbstractDAO implements ImageDAO {

    /**
     * Get all images from a gallery (by its ID)
     *
     * @param id a gallery id
     * @return a <code>ImageList</code> object, if a given gallery's id does not
     * exist, then return <code>null</code>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ImageList getByGalleryId(int id) throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT [gallery_id], "
                    + "[image_url], "
                    + "[caption] "
                    + "FROM [images] "
                    + "WHERE [gallery_id] = ?";

            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            List<Image> listOfImages = new ArrayList<>();

            while (rs.next()) {
                listOfImages.add(new Image(rs.getInt("gallery_id"),
                        rs.getString("image_url"), rs.getString("caption")));
            }

            if (!listOfImages.isEmpty()) {
                return new ImageList(id, listOfImages);
            } else {
                return null;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE,
                    null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE,
                        null, ex.getMessage());
            }
        }
    }

    /**
     * Get a random featured image
     *
     * @return an <code>Image</code> object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public Image getFeatured() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT TOP 1 [gallery_id], [image_url], [caption]"
                    + " FROM [images] WHERE [is_featured] = 1 ORDER BY NEWID()";

            statement = conn.prepareStatement(query);
            rs = statement.executeQuery();

            while (rs.next()) {
                return new Image(rs.getInt("gallery_id"),
                        rs.getString("image_url"), rs.getString("caption"));
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE,
                    null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE,
                        null, ex.getMessage());
            }
        }
    }
}
