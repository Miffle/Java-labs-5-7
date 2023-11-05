package org.btw.mediafiles;

public class Picture extends Media {
    public Picture(int cameraId, int iso, double aperture, int mediaId) {
        super(cameraId, iso, aperture, mediaId);
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Фото " + id + "\n" +
                "Диафрагма = " + aperture +
                ", iso = " + iso +
                ", Камера = " + cameraId +
                '\n';
    }
}
