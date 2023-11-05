package org.btw.mediafiles;

public class Video extends Media {
    public Video(int cameraId, int iso, double aperture, int mediaId) {
        super(cameraId, iso, aperture, mediaId);
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Видео " + id + "\n" +
                "Диафрагма = " + aperture +
                ", iso = " + iso +
                ", Камера = " + cameraId + "\n";
    }

}
