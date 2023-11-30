package org.btw.controllers;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.cameras.AllCamerasStorage;
import org.btw.elemetns.Table;
import org.btw.views.CameraCreationWindow;
import org.btw.views.ChangeCameraWindow;
import org.btw.views.UseCameraWindow;

import static org.btw.elemetns.Buttons.*;

public class MainWindowController {
    private static void addButtonHandler() {
        add.setOnAction(e -> new CameraCreationWindow(new Stage()));
    }

    // TODO: 29.11.2023 Сделать кнопку удаления камеры
    private static void deleteButtonHandler() {
        delete.setOnAction(e -> {
            AllCamerasStorage.remove(Table.table.getSelectionModel().getFocusedIndex());
            Table.updateList();
        });
    }

    // TODO: 29.11.2023 Сделать кнопку использования камеры
     private static void useButtonHandler() {
        use.setOnAction(e -> new UseCameraWindow(new Stage()));
    }


    // TODO Сделать кнопку изменения камеры
    private static void editButtonHandler() {
        edit.setOnAction(e -> new ChangeCameraWindow(new Stage(), Table.table.getSelectionModel().getFocusedIndex()));
    }

    public static VBox allMainWindowButtons() {
        addButtonHandler();
        useButtonHandler();
        deleteButtonHandler();
        editButtonHandler();
        VBox vBox = new VBox(add, delete, edit, use);
        vBox.setAlignment(Pos.TOP_RIGHT);
        return vBox;
    }


}
