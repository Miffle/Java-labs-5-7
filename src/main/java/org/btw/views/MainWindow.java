package org.btw.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.controllers.Deserialization;
import org.btw.controllers.MainWindowController;
import org.btw.controllers.Serialization;
import org.btw.elemetns.Table;

import static org.btw.elemetns.Table.cameraTableView;

public class MainWindow {
    public MainWindow(Stage stage) {
        new Thread(Deserialization::new).start();
        HBox box = new HBox(tableViewCreate());
        box.getChildren().add(MainWindowController.allMainWindowButtons());
        Group group = new Group(box);
        Scene scene = new Scene(group);
        createStage(stage, scene);
        new Thread(Serialization::new).start();
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
}
