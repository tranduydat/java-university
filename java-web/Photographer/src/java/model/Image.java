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
 * This class represents the 'images' table in the database
 *
 * @author DatDuyTran
 */
public class Image {

    /**
     * Image galleryId
     */
    private int galleryId;
    /**
     * Image imageURL
     */
    private String imageURL;
    /**
     * Image caption
     */
    private String caption;

    public Image() {
    }

    public Image(int galleryId, String imageURL, String caption) {
        this.galleryId = galleryId;
        this.imageURL = imageURL;
        this.caption = caption;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
