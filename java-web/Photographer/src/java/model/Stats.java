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
 * This class represents the 'stats' table in the database
 *
 * @author DatDuyTran
 */
public class Stats {

    /**
     * Stats id
     */
    private int id;
    /**
     * Stats type
     */
    private String type;
    /**
     * Stats value
     */
    private int value;

    public Stats() {
    }

    public Stats(int id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
