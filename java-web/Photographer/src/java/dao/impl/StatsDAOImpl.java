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
import dao.StatsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author datdu
 */
public class StatsDAOImpl extends AbstractDAO implements StatsDAO {

    /**
     * Get the number of views from stats table
     *
     * @return an <code>int</code> number, if it does not exist, then return -1
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int getNumberOfViews() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            conn = super.getConnection();

            String query = "SELECT [value] AS [number_of_views]"
                    + " FROM stats"
                    + " WHERE [type] = 'number_of_views'";

            statement = conn.prepareStatement(query);
            rs = statement.executeQuery();

            while (rs.next()) {
                return rs.getInt("number_of_views");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }

        return -1;
    }

    /**
     * Update view (add 1) into database
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void addView() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = super.getConnection();

            String query = "UPDATE [stats] SET [value] = [value] + 1"
                    + " WHERE [type] = 'number_of_views'";

            statement = conn.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw ex;
        } finally {
            try {
                closePreparedStatement(statement);
                closeConnection(conn);
            } catch (Exception ex) {
                Logger.getLogger(AuthorDAOImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
    }
}
