package org.btw.mediafiles;

import java.io.Serializable;

public abstract class Media implements Serializable {
    protected double aperture; // Диафрагма
    protected int iso;
    protected int cameraId;
    protected int id;
    protected String mediaFileType;

    public double getAperture() {
        return aperture;
    }

    public int getIso() {
        return iso;
    }

    public int getCameraId() {
        return cameraId;
    }

    public int getId() {
        return id;
    }

    public String getMediaFileType() {
        return mediaFileType;
    }

    public Media(int cameraId, int iso, double aperture, int mediaId) {
        this.cameraId = cameraId;
        this.aperture = aperture;
        this.iso = iso;
        this.id = mediaId;
        this.mediaFileType = getClass().getSimpleName();
    }
    public abstract void show();
}
