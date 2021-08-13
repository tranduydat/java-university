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

import java.util.List;
import model.Gallery;

/**
 *
 * @author datdu
 */
public interface GalleryDAO {

    /**
     * Get all the galleries in database by given number
     *
     * @param numberOfGalleries the number of galleries you want to get
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    public List<Gallery> getAll(int numberOfGalleries) throws Exception;

    /**
     * Get all the galleries from database
     *
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    public List<Gallery> getAll() throws Exception;

    /**
     * Get a gallery by given ID
     *
     * @param id a gallery's id you want to get
     * @return a <code>Gallery</code> object, if it does not exists then return
     * <code>null</code>
     * @throws Exception
     */
    public Gallery getById(int id) throws Exception;
}
