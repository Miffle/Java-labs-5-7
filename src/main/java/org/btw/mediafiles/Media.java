package org.btw.mediafiles;

public abstract class Media {
    protected double aperture; // Диафрагма
    protected int iso;
    protected int cameraId;
    protected int id;


    public Media(int cameraId, int iso, double aperture, int mediaId) {
        this.cameraId = cameraId;
        this.aperture = aperture;
        this.iso = iso;
        this.id = mediaId;
    }
    public abstract void show();
}
