package org.btw.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.controllers.MainWindowController;
import org.btw.elemetns.Table;

import static org.btw.elemetns.Table.table;

public class MainWindow {

    public MainWindow(Stage stage) {
        HBox box = new HBox(tableViewCreate());
        box.getChildren().add(MainWindowController.allMainWindowButtons());
        Group group = new Group(box);
        Scene scene = new Scene(group);
        createStage(stage, scene);
    }

    private static void createStage(Stage stage, Scene scene) {
        stage.setTitle("Помогите");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
    }

    private static VBox tableViewCreate() {
        table.setPrefWidth(350);
        table.setPrefHeight(200);
        Table.createColumns();
        return new VBox(table);
    }



}
