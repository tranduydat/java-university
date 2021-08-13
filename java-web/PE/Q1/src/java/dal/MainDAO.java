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
import model.Post;

/**
 *
 * @author dattran
 */
public class MainDAO extends DBContext {

    public ArrayList<Post> getAll() {
        String query = "SELECT * FROM post";
        ArrayList<Post> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Post(rs.getInt("id"), rs.getString("content"), rs.getDate("date"), rs.getBoolean("isEnabled"), rs.getString("created_by")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
