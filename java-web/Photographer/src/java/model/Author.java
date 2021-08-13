/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-25    1.0        DatDuyTran       Release 1.0<br>
 */
package model;

/**
 *
 * This class represents the 'authors' table in the database
 *
 * @author DatDuyTran
 */
public class Author {

    /**
     * Author id
     */
    private int id;
    /**
     * Author address
     */
    private String address;
    /**
     * Author city
     */
    private String city;
    /**
     * Author country
     */
    private String country;
    /**
     * Author phone
     */
    private String phone;
    /**
     * Author email
     */
    private String email;
    /**
     * Author about me
     */
    private String aboutMe;

    public Author() {
    }

    public Author(int id, String address, String city, String country, String phone, String email, String abountMe) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.aboutMe = abountMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

}
