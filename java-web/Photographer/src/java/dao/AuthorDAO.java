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
import model.Author;

/**
 *
 * @author datdu
 */
public interface AuthorDAO {

    /**
     * Get author by ID
     *
     * @param id the author id
     * @return <code>Author</code> object, or <code>null</code> if that ID does
     * not exist
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Author getById(int id) throws SQLException, ClassNotFoundException;
}
