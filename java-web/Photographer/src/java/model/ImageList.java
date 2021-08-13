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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class represents a list of images for a gallery by its id
 *
 * @author DatDuyTran
 */
public class ImageList {

    /**
     * ImageList galleryId
     */
    private int galleryId;
    /**
     * ImageList images<br/>
     * List of images by gallery_id
     */
    private List<Image> images;

    public ImageList() {
        this.images = new ArrayList<>();
    }

    public ImageList(int galleryId, List<Image> images) {
        this.galleryId = galleryId;
        this.images = images;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
