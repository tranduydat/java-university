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
import dao.AuthorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;

/**
 *
 * @author datdu
 */
public class AuthorDAOImpl extends AbstractDAO implements AuthorDAO {
    
    /**
     * Get author by ID
     * @param id the author id
     * @return <code>Author</code> object, or <code>null</code> if that ID
     *         does not exist
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public Author getById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String query = "SELECT [id], [address], [city],"
                + " [country], [phone], [email], [about_me]"
                + " FROM [authors]"
                + " WHERE [id] = ?";

        try {
            conn = super.getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                return new Author(
                        rs.getInt("id"), rs.getString("address"),
                        rs.getString("city"), rs.getString("country"),
                        rs.getString("phone"), rs.getString("email"),
                        rs.getString("about_me")
                );
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

        return null;
    }

}
