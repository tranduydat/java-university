/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * DigitalNews<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-07-01    1.0        DatDuyTran       Release 1.0<br>
 */
package dao.impl;

import dao.AbstractDAO;
import dao.PostDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Post;

/**
 *
 * @author DatDuyTran
 */
public class PostDAOImpl extends AbstractDAO implements PostDAO {

    /**
     * Get the latest posts
     *
     * @return a <code>Post</code> object
     * @throws Exception
     */
    @Override
    public Post getLastest() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = super.getConnection();
            String query = "SELECT TOP (1) [post_id]"
                    + "      ,[title]"
                    + "      ,[excerpt]"
                    + "      ,[content]"
                    + "      ,[posts].[author_id]"
                    + "	  ,[name] AS [author_name]"
                    + "      ,[thumbnail]"
                    + "      ,[date_published]"
                    + "      ,[date_modified]"
                    + "  FROM [dbo].[posts]"
                    + "  INNER JOIN authors ON posts.author_id = authors.author_id"
                    + "  ORDER BY [date_modified] DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("excerpt"),
                        rs.getString("content"),
                        new Author(rs.getInt("author_id"),
                                rs.getString("author_name")),
                        rs.getString("thumbnail"),
                        rs.getDate("date_published"),
                        rs.getDate("date_modified"));
            }

            return null;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            super.closeConnection(con);
            super.closePreparedStatement(ps);
            super.closeResultSet(rs);
        }
    }

    /**
     * Get all latest posts by the given number
     *
     * @param numberOfPosts a number of posts you want to get, as
     * <code>int</code>
     * @return a <code>List</code> of <code>Post</code>, if it does not exists,
     * return null
     * @throws Exception
     */
    @Override
    public List<Post> getListOfLatests(int numberOfPosts) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = super.getConnection();
            String query = "SELECT TOP (?) [post_id]"
                    + "      ,[title]"
                    + "      ,[excerpt]"
                    + "      ,[content]"
                    + "      ,[posts].[author_id]"
                    + "	  ,[name] AS [author_name]"
                    + "      ,[thumbnail]"
                    + "      ,[date_published]"
                    + "      ,[date_modified]"
                    + "  FROM [dbo].[posts]"
                    + "  INNER JOIN authors ON posts.author_id = authors.author_id"
                    + "  ORDER BY [date_modified] DESC";
            ps = con.prepareStatement(query);
            ps.setInt(1, numberOfPosts);
            rs = ps.executeQuery();
            List<Post> listOfPosts = new ArrayList<>();
            while (rs.next()) {
                listOfPosts.add(new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("excerpt"),
                        rs.getString("content"),
                        new Author(rs.getInt("author_id"),
                                rs.getString("author_name")),
                        rs.getString("thumbnail"),
                        rs.getDate("date_published"),
                        rs.getDate("date_modified")));
            }

            return listOfPosts;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            super.closeConnection(con);
            super.closePreparedStatement(ps);
            super.closeResultSet(rs);
        }
    }

    /**
     * Get a post by its id
     *
     * @param id a post id, as <code>int</code> number
     * @return a <code>Post</code> object
     * @throws Exception
     */
    @Override
    public Post getById(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = super.getConnection();
            String query = "SELECT [post_id]"
                    + "      ,[title]"
                    + "      ,[excerpt]"
                    + "      ,[content]"
                    + "      ,[posts].[author_id]"
                    + "	  ,[name] AS [author_name]"
                    + "      ,[thumbnail]"
                    + "      ,[date_published]"
                    + "      ,[date_modified]"
                    + "  FROM [dbo].[posts]"
                    + "  INNER JOIN authors ON posts.author_id = authors.author_id"
                    + "  WHERE [post_id] = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("excerpt"),
                        rs.getString("content"),
                        new Author(rs.getInt("author_id"),
                                rs.getString("author_name")),
                        rs.getString("thumbnail"),
                        rs.getDate("date_published"),
                        rs.getDate("date_modified"));
            }

            // If post id (as param) does not exists
            // then return null
            return null;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            super.closeConnection(con);
            super.closePreparedStatement(ps);
            super.closeResultSet(rs);
        }
    }

    /**
     * Search all posts in the database by keywords, from its
     * <pre>title</pre> and
     * <pre>content</pre>
     *
     * @param keyword a <code>String</code>
     * @return a <code>List</code> of <code>Post</code>
     * @throws Exception
     */
    @Override
    public List<Post> search(String keyword) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = super.getConnection();
            String query = "SELECT [post_id]"
                    + "      ,[title]"
                    + "      ,[excerpt]"
                    + "      ,[content]"
                    + "      ,[posts].[author_id]"
                    + "	  ,[name] AS [author_name]"
                    + "      ,[thumbnail]"
                    + "      ,[date_published]"
                    + "      ,[date_modified]"
                    + "  FROM [dbo].[posts]"
                    + "  INNER JOIN authors ON posts.author_id = authors.author_id"
                    + "  WHERE [title] LIKE ? OR [content] LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            rs = ps.executeQuery();

            List<Post> listOfPosts = new ArrayList<>();

            while (rs.next()) {
                listOfPosts.add(new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("excerpt"),
                        rs.getString("content"),
                        new Author(rs.getInt("author_id"),
                                rs.getString("author_name")),
                        rs.getString("thumbnail"),
                        rs.getDate("date_published"),
                        rs.getDate("date_modified")));
            }

            return listOfPosts;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            super.closeConnection(con);
            super.closePreparedStatement(ps);
            super.closeResultSet(rs);
        }
    }
}
