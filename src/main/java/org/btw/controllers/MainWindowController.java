package org.btw.controllers;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.views.CameraCreationWindow;
import org.btw.views.UseCameraWindow;

import static org.btw.elemetns.Buttons.*;

public class MainWindowController {
    private static void addButtonHandler() {
        add.setOnAction(e -> {
            new CameraCreationWindow(new Stage());
        });
    }

    // TODO: 29.11.2023 Сделать кнопку удаления камеры
    private static void deleteButtonHandler() {
        add.setOnAction(e -> {
            new CameraCreationWindow(new Stage());
        });
    }

    // TODO: 29.11.2023 Сделать кнопку использования камеры
     private static void useButtonHandler() {
        use.setOnAction(e -> {
            new UseCameraWindow(new Stage());
        });
    }


    // TODO Сделать кнопку изменения камеры
    private static void editButtonHandler() {
        add.setOnAction(e -> {
            new CameraCreationWindow(new Stage());
        });
    }

    public static VBox allMainWindowButtons() {
        addButtonHandler();
        useButtonHandler();
        VBox vBox = new VBox(add, delete, edit, use);
        vBox.setAlignment(Pos.TOP_RIGHT);
        return vBox;
    }


}
