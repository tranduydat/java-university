/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-16    1.0        DatDuyTran       Release 1.0<br>
 */
package dao.impl;

import dao.AbstractDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import dao.UserDAO;

/**
 *
 * @author datdu
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public List<User> getAll() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "SELECT [user_id]"
                    + "      ,[username]"
                    + "      ,[password]"
                    + "      ,[role_id]"
                    + "      ,[email]"
                    + "  FROM [dbo].[users]";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            List<User> listOfUsers = new ArrayList<>();

            while (rs.next()) {
                listOfUsers.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("email")
                ));
            }
            return listOfUsers;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public void add(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "INSERT INTO [dbo].[users]"
                    + "           ([username]"
                    + "           ,[password]"
                    + "           ,[role_id]"
                    + "           ,[email])"
                    + "     VALUES"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";

            ps = conn.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRoleID());
            ps.setString(4, user.getEmail());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public boolean doesExist(User userA, List<User> listOfUsers) {
        for (User userB : listOfUsers) {
            if (userB.getUsername().equals(userA.getUsername())) {
                return true;
            }
            if (userB.getEmail().equals(userB.getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User get(String userName, String password) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = getConnection();

            String query = "SELECT [user_id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[role_id]\n"
                    + "      ,[email]\n"
                    + "  FROM [dbo].[users]"
                    + "  WHERE [username] = ? "
                    + "     AND [password] = ?";

            ps = connection.prepareStatement(query);

            ps.setString(1, userName);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("email")
                );
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
    }
}
