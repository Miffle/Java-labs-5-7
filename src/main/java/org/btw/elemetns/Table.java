package org.btw.elemetns;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.Camera;
import org.btw.models.mediafiles.Media;

public class Table {
    public static TableView<Camera> cameraTableView = new TableView<>(FXCollections.observableList(AllCamerasStorage.getAllCamerasArray()));
    public static TableView<Media> mediaTableview;
    public static TableColumn<Media, Integer> mediaIdColumn = new TableColumn<>("id");
    public static TableColumn<Media, Integer> cameraId = new TableColumn<>("Камера");
    public static TableColumn<Media, String> mediaFiletype = new TableColumn<>("Тип");
    public static TableColumn<Media, Double> mediaAperture = new TableColumn<>("Диафрагма");
    public static TableColumn<Media, Integer> mediaIso = new TableColumn<>("ISO");
    public static TableColumn<Camera, Integer> idColumn = new TableColumn<>("id");
    public static TableColumn<Camera, String> CameraTypeColumn = new TableColumn<>("Тип");
    public static TableColumn<Camera, String> shootingMode = new TableColumn<>("Режим");
    public static TableColumn<Camera, Integer> iso = new TableColumn<>("ISO");
    public static TableColumn<Camera, Double> aperture = new TableColumn<>("Диафрагма");

    public static void createCameraColumns() {
        setCamerasFactory();
        addCameraColumns();
    }
    public static void createMediaColumns(Camera camera){
        mediaTableview = new TableView<>(FXCollections.observableArrayList(camera.allMedia));
        addMediaColumns();
        setMediaFactory();
    }
    private static void addMediaColumns() {
        mediaTableview.getColumns().add(mediaIdColumn);
        mediaTableview.getColumns().add(cameraId);
        mediaTableview.getColumns().add(mediaFiletype);
        mediaTableview.getColumns().add(mediaAperture);
        mediaTableview.getColumns().add(mediaIso);
    }

    private static void setMediaFactory() {
        mediaIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        cameraId.setCellValueFactory(new PropertyValueFactory<>("cameraId"));
        mediaFiletype.setCellValueFactory(new PropertyValueFactory<>("mediaFileType"));
        mediaAperture.setCellValueFactory(new PropertyValueFactory<>("aperture"));
        mediaIso.setCellValueFactory(new PropertyValueFactory<>("iso"));
    }
    public static void updateCamerasList(){
        cameraTableView.setItems(FXCollections.observableArrayList(AllCamerasStorage.getAllCamerasArray()));
    }
    public static void updateMediaList(Camera camera){
        mediaTableview.setItems(FXCollections.observableArrayList(camera.allMedia));
    }

    private static void addCameraColumns() {
        cameraTableView.getColumns().add(idColumn);
        cameraTableView.getColumns().add(CameraTypeColumn);
        cameraTableView.getColumns().add(shootingMode);
        cameraTableView.getColumns().add(iso);
        cameraTableView.getColumns().add(aperture);
    }

    private static void setCamerasFactory() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        CameraTypeColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        shootingMode.setCellValueFactory(new PropertyValueFactory<>("shootingMode"));
        iso.setCellValueFactory(new PropertyValueFactory<>("iso"));
        aperture.setCellValueFactory(new PropertyValueFactory<>("aperture"));
    }

}
