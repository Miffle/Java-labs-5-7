package org.btw.cameras;

import org.btw.mediafiles.MediaFileType;
import org.btw.mediafiles.Media;
import org.btw.mediafiles.Picture;
import org.btw.mediafiles.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Camera {
    protected static int lastId;
    protected int mediaId;
    protected int id;
    protected String shootingMode;
    protected List<Media> allMedia = new ArrayList<>();
    protected int iso;
    protected String type;
    protected double aperture; // Диафрагма

    public Camera(double aperture, String shootingMode, int iso, String type) {
        changeShootingMode(shootingMode);
        this.aperture = aperture;
        this.iso = iso;
        this.id = makeIdForNewCamera();
        this.type = type;
    }

    /**
     * Генерирует ID для новой камеры
     *
     * @return id
     */
    private int makeIdForNewCamera() {
        return ++lastId;
    }

    /**
     * Меняет значение shootingMode на введенное пользователем
     *
     * @param newShootingMode photo/video
     */
    public void changeShootingMode(String newShootingMode) {
        this.shootingMode = newShootingMode;
    }

    /**
     * Меняет значение shootingMode основываясь на предыдущем значении.
     */
    public void toggleChangeShootingMode() {
        if (Objects.equals(this.shootingMode, MediaFileType.getPHOTO())) {
            this.shootingMode = MediaFileType.getVIDEO();
        } else this.shootingMode = MediaFileType.getPHOTO();
        System.out.println("Режим съёмки был изменен.");
    }

    /**
     * Создаёт новый медиафайл, в зависимости от переданного типа.
     *
     * @param mediaFileType тип создаваемого медиафайла - photo или video
     */
    public void createNewMediaFile(String mediaFileType) {
        if (Objects.equals(mediaFileType, this.shootingMode)) {
            this.mediaId = this.makeIdForNewMediaFile();
            addNewMediaFileToList(mediaFileType);
        } else returnException();
    }

    /**
     * Выбирает тип медиафайла и добавляет в массив
     *
     * @param mediaFileType тип создаваемого медиафайла - photo или video
     */
    private void addNewMediaFileToList(String mediaFileType) {
        if (Objects.equals(mediaFileType, MediaFileType.getPHOTO())) {
            allMedia.add(new Picture(id, iso, aperture, mediaId));
        } else {
            allMedia.add(new Video(id, iso, aperture, mediaId));
        }
        System.out.println("Готово!");
    }

    private static void returnException() {
        System.out.println("Нужно поменять режим съемки");
    }

    public void changeAperture(double aperture) {
        this.aperture = aperture;
    }

    public void changeISO(int iso) {
        this.iso = iso;
    }

    public void showAllMedia() {
        for (Media media :
                allMedia) {
            media.show();
        }
    }

    @Override
    public String toString() {
        return type + " " + id +
                "\n\tРежим съемки = '" + shootingMode + '\'' +
                "\n\tiso = " + iso +
                "\n\tДиафрагма = " + aperture;
    }

    public void getCamera() {
        System.out.println(this);
    }

    public int getId() {
        return id;
    }

    protected abstract int makeIdForNewMediaFile();
}
