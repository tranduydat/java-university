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

/**
 *
 * @author datdu
 */
public interface StatsDAO {

    /**
     * Get the number of views from stats table
     *
     * @return an <code>int</code> number, if it does not exist, then return -1
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getNumberOfViews() throws SQLException, ClassNotFoundException;

    /**
     * Update view (add 1) into database
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addView() throws SQLException, ClassNotFoundException;
}
