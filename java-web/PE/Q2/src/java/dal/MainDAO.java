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
import javax.ejb.PostActivate;
import model.Account;
import model.Post;

/**
 *
 * @author dattran
 */
public class MainDAO extends DBContext {

    public Account getAccount(String user, String pass) {
        String sql = "SELECT * FROM Account a WHERE a.accountid = ? AND a.password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("accountid"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Post> getByAcc(String acc) {
        String query = "SELECT * FROM Post p WHERE p.created_by = ?";
        ArrayList<Post> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, acc);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Post(rs.getInt("id"), rs.getString("content"), rs.getDate("date"), rs.getBoolean("isEnabled"), rs.getString("created_by")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
