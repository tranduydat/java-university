/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-16    1.0        DatDuyTran       Release 1.0<br>
 */
package model;

/**
 *
 * @author datdu
 */
public class User {

    private int userID;
    private String username;
    private String password;
    private int roleID;
    private String email;

    public User() {
    }

    public User(String username, String password, int roleID, String email) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
    }

    public User(int userID, String username, String password, int roleID, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", roleID=" + roleID + ", email=" + email + '}';
    }

}
