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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author datdu
 */
public abstract class AbstractDAO {

    /**
     * AbstractDAO dbName
     */
    private String dbName;
    /**
     * AbstractDAO serverName
     */
    private String serverName;
    /**
     * AbstractDAO portNumber
     */
    private String portNumber;
    /**
     * AbstractDAO image
     */
    private String image;
    /**
     * AbstractDAO username
     */
    private String username;
    /**
     * AbstractDAO password
     */
    private String password;

    /**
     * Constructor
     */
    public AbstractDAO() {
        this.serverName = "localhost";
        this.dbName = "onlinequiz_db";
        this.portNumber = "1433";
        this.username = "sa";
        this.password = "dat123123";
    }

    /**
     * Get connection of your database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param ps it is a object of <code>java.sql.PreparedStatement</code>
     * @throws Exception
     */
    public void closePreparedStatement(PreparedStatement ps) throws Exception {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param con it is a object of <code>java.sql.Connection</code>
     * @throws Exception
     */
    public void closeConnection(Connection con) throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param rs it is a object of <code>java.sql.ResultSet</code>
     * @throws Exception
     */
    public void closeResultSet(ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Get path of image store in file context
     *
     * @return path of image
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return image;
    }
}
