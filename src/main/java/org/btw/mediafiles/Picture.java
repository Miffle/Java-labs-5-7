package org.btw.mediafiles;

public class Picture extends Media {
    public Picture(int cameraId, int iso, double aperture, int mediaId) {
        super(cameraId, iso, aperture, mediaId);
    }

    public void showPicture() {
        System.out.println("Camera = " + cameraId);
        System.out.println("Picture id = " + this.id);
        System.out.println("Picture iso = " + this.iso);
        System.out.println("Picture aperture = " + this.aperture + "\n");
    }
}
