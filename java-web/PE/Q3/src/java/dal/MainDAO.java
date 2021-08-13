/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.Post;

/**
 *
 * @author dattran
 */
public class MainDAO extends DBContext {

    public ArrayList<Post> getAll() {
        ArrayList<Post> list = new ArrayList<>();
        try {
            String query = "SELECT p.id, p.content FROM Post p";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                int pid = rs.getInt("id");
                p.setId(pid);
                p.setListOfComments(this.getCommentById(pid));
                p.setContent(rs.getString("content"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public ArrayList<Comment> getCommentById(int pid) {
        ArrayList<Comment> list = new ArrayList<>();
        String query = "SELECT * FROM Comment WHERE pid = " + pid;

        try {
            PreparedStatement st;
            st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt("id"), rs.getString("content")));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void addComment(String content, int pid) {
        String query = "INSERT INTO [dbo].[Comment] ([content] ,[pid]) VALUES (? , ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, content);
            st.setInt(2, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
