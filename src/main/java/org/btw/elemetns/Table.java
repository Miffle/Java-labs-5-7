package org.btw.elemetns;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;

public class Table {
    public static ObservableList<Camera> cameraObservableList = FXCollections.observableList(AllCamerasStorage.getAllCamerasArray());
    public static TableView<Camera> table = new TableView<>(cameraObservableList);
    public static TableColumn<Camera, Integer> idColumn = new TableColumn<>("id");
    public static TableColumn<Camera, String> shootingMode = new TableColumn<>("Режим");
    public static TableColumn<Camera, Integer> iso = new TableColumn<>("ISO");
    public static TableColumn<Camera, Double> aperture = new TableColumn<>("Диафрагма");

    public static void createColumns() {
        setFactory();
        addColumns();
    }
    public static void updateList(){
        cameraObservableList.removeAll();
        cameraObservableList = FXCollections.observableList(AllCamerasStorage.getAllCamerasArray());
    }
    private static void addColumns() {
        table.getColumns().add(idColumn);
        table.getColumns().add(shootingMode);
        table.getColumns().add(iso);
        table.getColumns().add(aperture);
    }

    private static void setFactory() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        shootingMode.setCellValueFactory(new PropertyValueFactory<>("shootingMode"));
        iso.setCellValueFactory(new PropertyValueFactory<>("iso"));
        aperture.setCellValueFactory(new PropertyValueFactory<>("aperture"));
    }
}
