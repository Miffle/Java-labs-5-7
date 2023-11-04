package org.btw.cameras;

import org.btw.mediafiles.Picture;
import org.btw.mediafiles.Video;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Camera {
    static int lastId;
    int mediaId;
    int id;
    String shootingMode;
    ArrayList<Picture> allPhotos = new ArrayList<>();
    ArrayList<Video> allVideos = new ArrayList<>();
    int iso;
    double aperture; // Диафрагма

    public Camera(double aperture, String shootingMode, int iso) {
        changeShootingMode(shootingMode);
        this.aperture = aperture;
        this.iso = iso;
        this.id = makeIdForNewCamera();
    }

    private int makeIdForNewCamera() {
        return ++lastId;
    }

    public void changeShootingMode(String newShootingMode) {
        this.shootingMode = newShootingMode;
    }

    public void toggleChangeShootingMode() {
        if (Objects.equals(this.shootingMode, "photo")) {
            this.shootingMode = "video";
        } else this.shootingMode = "photo";
        System.out.println("Режим съёмки был изменен.");
    }

    public void takePicture() {
        if (Objects.equals(this.shootingMode, "photo")) {
            this.mediaId = this.makeIdForNewMediaFile();
            allPhotos.add(new Picture(id, iso, aperture, mediaId));
            System.out.println("Фото сделано");
        } else {
            returnException();
        }
    }

    public void takeVideo() {
        if (Objects.equals(this.shootingMode, "video")) {
            this.mediaId = this.makeIdForNewMediaFile();
            allVideos.add(new Video(id, iso, aperture, mediaId));
            System.out.println("Видео снято");
        } else {
            returnException();
        }
    }

    private static void returnException() {
        System.out.println("You need to change shooting mode");
    }

    public void changeAperture(double aperture) {
        this.aperture = aperture;
    }

    public void changeISO(int iso) {
        this.iso = iso;
    }

    public void showAllPhotos() {
        for (Picture pic :
                allPhotos) {
            pic.showPicture();
        }
    }

    public void showAllVideos() {
        for (Video vid :
                allVideos) {
            vid.showVideo();
        }
    }

    public void showAllMedia() {
        showAllPhotos();
        showAllVideos();
    }

    public void getCamera() {
        System.out.println(this.id);
    }

    protected abstract int makeIdForNewMediaFile();
}
