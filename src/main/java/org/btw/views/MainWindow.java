package org.btw.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.controllers.MainWindowController;
import org.btw.elemetns.Table;

import java.io.*;
import java.util.List;

import static org.btw.elemetns.Table.cameraTableView;

public class MainWindow {
    private static final Logger fileLogger = Logger.getLogger("file");

    public MainWindow(Stage stage) {
        loadOnStart();
        HBox box = new HBox(tableViewCreate());
        box.getChildren().add(MainWindowController.allMainWindowButtons());
        Group group = new Group(box);
        Scene scene = new Scene(group);
        createStage(stage, scene);
        onClose(stage);
    }

    private static void createStage(Stage stage, Scene scene) {
        stage.setTitle("Помогите");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
    }

    private static VBox tableViewCreate() {
        cameraTableView.setPrefWidth(350);
        cameraTableView.setPrefHeight(200);
        Table.createCameraColumns();
        return new VBox(cameraTableView);
    }

    private static void onClose(Stage stage) {
        stage.setOnCloseRequest(e -> {
            try {
                makeSave();
                fileLogger.info("Состояние программы было сохранено в файл");
            } catch (IOException ex) {
                fileLogger.error("Не удалось сделать сохранение " + ex.getMessage());
            }
        });
    }

    private static void makeSave() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(AllCamerasStorage.getAllCamerasArray());
        objectOutputStream.close();
    }

    private static void loadOnStart() {
        FileInputStream fileInputStream;
        List<Camera> cameras;
        try {
            fileInputStream = new FileInputStream("save.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cameras = (List<Camera>) objectInputStream.readObject();
            AllCamerasStorage.clearAll();
            AllCamerasStorage.allCameras = cameras;
            fileLogger.info("Камеры были считаны с сохранения.");
        } catch (IOException | ClassNotFoundException e) {
            fileLogger.error("Не удалось прочитать камеры с сохранения, возьмём с базы");
        }
    }
}
