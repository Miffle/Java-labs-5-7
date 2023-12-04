package org.btw.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.models.cameras.Camera;
import org.btw.controllers.UseCameraWindowController;
import org.btw.elemetns.Buttons;
import org.btw.elemetns.Table;

public class UseCameraWindow {
    private final Camera camera;
    public UseCameraWindow(Stage stage, Integer cameraId){
        camera = ChangeCameraWindow.getCamera(cameraId);
        Scene scene = new Scene(creatingScene());
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        UseCameraWindowController.makeButtonsEnable(camera);
    }
    private HBox creatingScene(){
        HBox hBox = new HBox();
        hBox.getChildren().add(createMediaTable());
        hBox.getChildren().add(addButtonsToUseCamera());
        return hBox;
    }
    private VBox createMediaTable(){
        Table.createMediaColumns(camera);
        Table.mediaTableview.setPrefWidth(400);
        Table.mediaTableview.setPrefHeight(200);
        return new VBox(Table.mediaTableview);
    }
    private VBox addButtonsToUseCamera(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(Buttons.makePhoto, Buttons.makeVideo, Buttons.changeShootingMode);
        vBox.setAlignment(Pos.TOP_RIGHT);
        return vBox;
    }

}
