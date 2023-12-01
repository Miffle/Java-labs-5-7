package org.btw.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.elemetns.CreationWindow.VBoxes;

import java.util.Objects;

public class CameraCreationWindow {
    private final VBoxes vBoxes = new VBoxes();
    private final VBox secondVBox = new VBox(new VBox(), new VBox());
    private final VBox thirdVBox = new VBox(vBoxes.getButtons().create);

    public CameraCreationWindow(Stage stage) {
        makeGroup();
        VBox mainVBox = getMainVBox();
        Scene scene = new Scene(mainVBox);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Создание камеры");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
    }

    private VBox getMainVBox() {
        VBox firstVBox = new VBox(vBoxes.typeV, vBoxes.isoV, vBoxes.apertureV, vBoxes.shootingModeV);
        return new VBox(firstVBox, secondVBox, thirdVBox);
    }

    private void makeGroup() {
        thirdVBox.setAlignment(Pos.CENTER);
        groupSelectedListener(vBoxes.getGroups().cameraTypeGroup);
        vBoxes.getGroups().cameraTypeGroup.selectToggle(vBoxes.getButtons().PhoneCamera);
    }


    private void groupSelectedListener(ToggleGroup group) {
        group.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton selectedButton = (RadioButton) t1;
            if (Objects.equals(selectedButton.getText(), "SLR камера")) {
                updateSecondVBox(vBoxes.zoomV, vBoxes.storageV);
            } else if (Objects.equals(selectedButton.getText(), "Веб камера")) {
                updateSecondVBox(vBoxes.outputConnectorV);
            } else {
                updateSecondVBox(vBoxes.zoomV, vBoxes.moduleV);
            }
        });
    }

    private void updateSecondVBox(VBox v1, VBox v2) {
        secondVBox.getChildren().set(0, v1);
        try {
            secondVBox.getChildren().set(1, v2);
        }catch(IndexOutOfBoundsException e) {
            secondVBox.getChildren().add(v2);
        }
    }
    private void updateSecondVBox(VBox v1) {
        secondVBox.getChildren().set(0, v1);
        secondVBox.getChildren().remove(1);
    }

}
