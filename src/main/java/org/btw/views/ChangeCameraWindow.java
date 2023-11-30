package org.btw.views;

import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.elemetns.Buttons;
import org.btw.elemetns.Groups;
import org.btw.elemetns.Table;
import org.btw.elemetns.TextBoxes;

import static org.btw.elemetns.Buttons.confirmEdit;

public class ChangeCameraWindow {
    static Camera camera;

    public ChangeCameraWindow(Stage stage, int cameraId) {
        getCamera(cameraId);
        Scene scene = new Scene(makeVBox());
        stage.setScene(scene);
        stage.sizeToScene();
        EditConfirmButtonHandler();
        stage.show();
    }

    public static VBox makeVBox() {
        VBox vBox = new VBox();
        vBox.getChildren().add(TextBoxes.isoVbox);
        vBox.getChildren().add(TextBoxes.apertureVbox);
        vBox.getChildren().add(Buttons.inputShootingModeVBox());
        addOtherBoxes(vBox);
        return vBox;
    }

    public static void getCamera(int cameraId) {
        camera = AllCamerasStorage.get(cameraId);
    }

    private static void addOtherBoxes(VBox vBox) {
        switch (camera.getClassName()) {
            case "SlrCamera" -> {
                vBox.getChildren().add(TextBoxes.zoomVbox);
                vBox.getChildren().add(TextBoxes.storageVbox);
            }
            case "WebCamera" -> vBox.getChildren().add(Buttons.connectorTypeVBox());
            case "PhoneCamera" -> {
                vBox.getChildren().add(TextBoxes.zoomVbox);
                vBox.getChildren().add(Buttons.moduleVBox());
            }
        }
        setInputsValues();
        vBox.getChildren().add(Buttons.confirmEdit);
    }

    private static void setInputsValues() {
        TextBoxes.inputISO.setText(String.valueOf(camera.getIso()));
        TextBoxes.inputAperture.setText(String.valueOf(camera.getAperture()));
        if (Buttons.inputShootingModePhoto.getText().equals(camera.getShootingMode())) {
            Groups.ShootingModeGroup.selectToggle(Buttons.inputShootingModePhoto);
        } else {
            Groups.ShootingModeGroup.selectToggle(Buttons.inputShootingModeVideo);
        }
        switch (camera.getClassName()) {
            case "SlrCamera" -> {
                TextBoxes.inputStorage.setText(String.valueOf(camera.getStorage()));
                TextBoxes.inputZoom.setText(String.valueOf(camera.getZoom()));
            }
            case "WebCamera" -> {
                if (Buttons.connectorTypeC.getText().equals(camera.getOutputConnector())) {
                    Groups.OutputConnectorGroup.selectToggle(Buttons.connectorTypeC);
                } else {
                    Groups.OutputConnectorGroup.selectToggle(Buttons.connectorTypeA);
                }
            }
            case "PhoneCamera" -> {
                TextBoxes.inputZoom.setText(String.valueOf(camera.getZoom()));
                if (Buttons.frontModule.getText().equals(camera.getSelectedCameraModule())) {
                    Groups.InputModuleGroup.selectToggle(Buttons.frontModule);
                } else {
                    Groups.InputModuleGroup.selectToggle(Buttons.mainModule);
                }
            }
        }
    }
    public static void EditConfirmButtonHandler(){
        confirmEdit.setOnAction(e ->{
            camera.changeISO(Integer.parseInt(TextBoxes.inputISO.getText()));
            camera.changeAperture(Double.parseDouble(TextBoxes.inputAperture.getText()));
            camera.changeShootingMode(((RadioButton) Groups.ShootingModeGroup.getSelectedToggle()).getText());
            switch (camera.getClassName()){
                case "SlrCamera" -> {
                    camera.setStorage(Double.parseDouble(TextBoxes.inputStorage.getText()));
                    camera.setZoom(Double.parseDouble(TextBoxes.inputZoom.getText()));
                }
                case "WebCamera" -> camera.setOutputConnector(((RadioButton) Groups.OutputConnectorGroup.getSelectedToggle()).getText());
                case "PhoneCamera" -> {
                    camera.setZoom(Double.parseDouble(TextBoxes.inputZoom.getText()));
                    camera.setSelectedCameraModule(((RadioButton) Groups.InputModuleGroup.getSelectedToggle()).getText());
                }
            }
            Table.updateList();
            Table.table.refresh();
        });
    }


}
