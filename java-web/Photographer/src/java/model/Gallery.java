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
 * This class represents the 'galleries' table in the database
 *
 * @author DatDuyTran
 */
public class Gallery {

    /**
     * Gallery id
     */
    private int id;
    /**
     * Gallery title
     */
    private String title;
    /**
     * Gallery thumbnail
     */
    private String thumbnail;
    /**
     * Gallery description
     */
    private String description;
    /**
     * Gallery author_id
     */
    private int authorId;

    public Gallery() {
    }

    public Gallery(int id, String title, String thumbnail, String description, int authorId) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

}
