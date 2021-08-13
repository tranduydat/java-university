/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-25    1.0        DatDuyTran       Release 1.0<br>
 */
package dao;

import java.sql.SQLException;
import model.Image;
import model.ImageList;

/**
 *
 * @author datdu
 */
public interface ImageDAO {

    /**
     * Get all images from a gallery (by its ID)
     *
     * @param id a gallery id
     * @return a <code>ImageList</code> object, if a given gallery's id does not
     * exist, then return <code>null</code>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ImageList getByGalleryId(int id) throws SQLException, ClassNotFoundException;

    /**
     * Get a random featured image
     *
     * @return an <code>Image</code> object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Image getFeatured() throws SQLException, ClassNotFoundException;
}
