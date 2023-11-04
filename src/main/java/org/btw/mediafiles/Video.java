package org.btw.mediafiles;

public class Video extends Media{
    public Video(int cameraId, int iso, double aperture, int mediaId) {
        super(cameraId, iso, aperture, mediaId);
    }
    public void showVideo(){
        System.out.println("Camera = " + cameraId);
        System.out.println("Video id = " + this.id);
        System.out.println("Video iso = " + this.iso);
        System.out.println("Video aperture = " + this.aperture + "\n");
    }
}
