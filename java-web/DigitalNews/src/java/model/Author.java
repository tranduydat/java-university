/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * DigitalNews<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-07-01    1.0        DatDuyTran       Release 1.0<br>
 */
package model;

/**
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
     * Author name
     */
    private String name;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
