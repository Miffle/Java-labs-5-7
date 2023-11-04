package org.btw.mediafiles;

public abstract class Media {
    double aperture; // Диафрагма
    int iso;
    int cameraId;
    int id;


    public Media(int cameraId, int iso, double aperture, int mediaId) {
        this.cameraId = cameraId;
        this.aperture = aperture;
        this.iso = iso;
        this.id = mediaId;
    }
}
