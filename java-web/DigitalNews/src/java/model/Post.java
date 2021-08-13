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

import java.sql.Date;

/**
 * This class represents the 'posts' table in the database
 *
 * @author DatDuyTran
 */
public class Post {

    /**
     * Post id
     */
    private int id;
    /**
     * Post title
     */
    private String title;
    /**
     * Post excerpt
     */
    private String excerpt;
    /**
     * Post content
     */
    private String content;
    /**
     * Post Author
     */
    private Author author;
    /**
     * Post thumbnail
     */
    private String thumbnail;
    /**
     * Post publishedDate
     */
    private Date publishedDate;
    /**
     * Post modifiedDate
     */
    private Date modifiedDate;

    public Post() {
    }

    public Post(int id, String title, String excerpt, String content, Author author, String thumbnail, Date publishedDate, Date modifiedDate) {
        this.id = id;
        this.title = title;
        this.excerpt = excerpt;
        this.content = content;
        this.author = author;
        this.thumbnail = thumbnail;
        this.publishedDate = publishedDate;
        this.modifiedDate = modifiedDate;
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

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
