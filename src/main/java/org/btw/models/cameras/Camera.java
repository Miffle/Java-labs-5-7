package org.btw.models.cameras;

import org.apache.log4j.Logger;
import org.btw.database.GetIdForCamerasArray;
import org.btw.models.mediafiles.Media;
import org.btw.models.mediafiles.MediaFileType;
import org.btw.models.mediafiles.Picture;
import org.btw.models.mediafiles.Video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Camera implements Serializable {
    private static final long serialVersionUID = 1;
    private static final Logger logger = Logger.getLogger("Camera");
    private static final Logger inputLogger = Logger.getLogger("input");
    protected String className = this.getClass().getSimpleName();
    protected int mediaId;
    protected int id;
    protected String shootingMode;
    public List<Media> allMedia = new ArrayList<>();
    protected int iso;
    protected double aperture; // Диафрагма

    public Camera(double aperture, String shootingMode, int iso) {
        changeShootingMode(shootingMode);
        this.aperture = aperture;
        this.iso = iso;
        this.id = makeIdForNewCamera();
        logger.info("Создана новая " + getClass().getSimpleName() + " камера");
    }

    /**
     * Генерирует ID для новой камеры
     *
     * @return id
     */
    private int makeIdForNewCamera() {
        return new GetIdForCamerasArray().getNewId();
    }
    public void setId(int Id){
        this.id = Id;
    }
    /**
     * Меняет значение shootingMode на введенное пользователем
     *
     * @param newShootingMode photo/video
     */
    public void changeShootingMode(String newShootingMode) {
        this.shootingMode = newShootingMode;
        inputLogger.info("начальным режимом съемки выбран " + newShootingMode);
    }

    /**
     * Меняет значение shootingMode основываясь на предыдущем значении.
     */
    public void toggleChangeShootingMode() {
        if (Objects.equals(this.shootingMode, MediaFileType.PHOTO)) {
            this.shootingMode = MediaFileType.VIDEO;
        } else this.shootingMode = MediaFileType.PHOTO;
        System.out.println("Режим съёмки был изменен.");
        logger.info("Режим съемки у " + getClass().getSimpleName() + " " + this.id + " был изменен на " + this.shootingMode);
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
        Media media = Objects.equals(mediaFileType, MediaFileType.PHOTO) ? new Picture(id, iso, aperture, mediaId) : new Video(id, iso, aperture, mediaId);
        allMedia.add(media);
        logger.info("У " + getClass().getSimpleName() + " " + this.id + " был добавлен медиафайл типа: " + mediaFileType);
        System.out.println("Готово!");
    }

    private static void returnException() {
        System.out.println("Нужно поменять режим съемки");
        logger.error("Ошибка создания медиафайла из-за несовпадения типа и режима съемки");
    }

    public void changeAperture(double aperture) {
        this.aperture = aperture;
        logger.info("У " + getClass().getSimpleName() + " " + this.id + " была изменена диафрагма на " + this.aperture);
    }

    public void changeISO(int iso) {
        this.iso = iso;
        logger.info("У " + getClass().getSimpleName() + " " + this.id + " было изменено ISO на " + this.iso);
    }

    public void showAllMedia() {
        for (Media media :
                allMedia) {
            media.show();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id +
                "\n\tРежим съемки = '" + shootingMode + '\'' +
                "\n\tiso = " + iso +
                "\n\tДиафрагма = " + aperture;
    }


    public int getId() {
        return id;
    }

    protected abstract int makeIdForNewMediaFile();

    public String getShootingMode() {
        return shootingMode;
    }

    public String getClassName() {
        return className;
    }
    public abstract double getStorage();

    public abstract void setZoom(double zoom);

    public abstract void setStorage(double storage);
    public abstract void setOutputConnector(String connector);
    public abstract void setSelectedCameraModule(String Module);
    public abstract double getZoom();
    public abstract String getOutputConnector();
    public abstract String getSelectedCameraModule();
    public int getIso() {
        return iso;
    }

    public double getAperture() {
        return aperture;
    }
}