package org.btw.elemetns;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;

public class Table {
    public static TableView<Camera> table = new TableView<>(FXCollections.observableList(AllCamerasStorage.getAllCamerasArray()));
    public static TableColumn<Camera, Integer> idColumn = new TableColumn<>("id");
    public static TableColumn<Camera, String> CameraTypeColumn = new TableColumn<>("Тип");
    public static TableColumn<Camera, String> shootingMode = new TableColumn<>("Режим");
    public static TableColumn<Camera, Integer> iso = new TableColumn<>("ISO");
    public static TableColumn<Camera, Double> aperture = new TableColumn<>("Диафрагма");

    public static void createColumns() {
        setFactory();
        addColumns();
    }
    public static void updateList(){
        table.setItems(FXCollections.observableArrayList(AllCamerasStorage.getAllCamerasArray()));
    }
    private static void addColumns() {
        table.getColumns().add(idColumn);
        table.getColumns().add(CameraTypeColumn);
        table.getColumns().add(shootingMode);
        table.getColumns().add(iso);
        table.getColumns().add(aperture);
    }

    private static void setFactory() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        CameraTypeColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        shootingMode.setCellValueFactory(new PropertyValueFactory<>("shootingMode"));
        iso.setCellValueFactory(new PropertyValueFactory<>("iso"));
        aperture.setCellValueFactory(new PropertyValueFactory<>("aperture"));
    }
}
