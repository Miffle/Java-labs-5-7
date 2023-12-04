package org.btw.views;

import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.Camera;
import org.btw.database.ChangeRowInDB;
import org.btw.elemetns.CreationWindow.TextFields;
import org.btw.elemetns.CreationWindow.VBoxes;
import org.btw.elemetns.EditWindowButtons.ConfirmButton;
import org.btw.elemetns.Table;


public class ChangeCameraWindow {
    private final Camera camera;
    private final VBoxes vBoxes = new VBoxes();
    private final TextFields fields = vBoxes.getFields();
    private final ConfirmButton confirmButton = new ConfirmButton();

    public ChangeCameraWindow(Stage stage, int cameraId) {
        camera = getCamera(cameraId);
        Scene scene = new Scene(makeVBox());
        stage.setScene(scene);
        stage.sizeToScene();
        EditConfirmButtonHandler();
        stage.show();
    }

    public VBox makeVBox() {
        VBox vBox = new VBox();
        vBox.getChildren().add(vBoxes.isoV);
        vBox.getChildren().add(vBoxes.apertureV);
        vBox.getChildren().add(vBoxes.shootingModeV);
        addOtherBoxes(vBox);
        return vBox;
    }

    public static Camera getCamera(int cameraId) {
        return AllCamerasStorage.get(cameraId);
    }

    private void addOtherBoxes(VBox vBox) {
        switch (camera.getClassName()) {
            case "SlrCamera" -> {
                vBox.getChildren().add(vBoxes.zoomV);
                vBox.getChildren().add(vBoxes.storageV);
            }
            case "WebCamera" -> vBox.getChildren().add(vBoxes.outputConnectorV);
            case "PhoneCamera" -> {
                vBox.getChildren().add(vBoxes.zoomV);
                vBox.getChildren().add(vBoxes.moduleV);
            }
        }
        setInputsValues();
        vBox.getChildren().add(confirmButton.confirmEdit);
    }

    private void setInputsValues() {
        fields.setInputISO(String.valueOf(camera.getIso()));
        fields.setInputAperture(String.valueOf(camera.getAperture()));
        if (vBoxes.getButtons().inputShootingModePhoto.getText().equals(camera.getShootingMode())) {
            vBoxes.getGroups().ShootingModeGroup.selectToggle(vBoxes.getButtons().inputShootingModePhoto);
        } else {
            vBoxes.getGroups().ShootingModeGroup.selectToggle(vBoxes.getButtons().inputShootingModeVideo);
        }
        switch (camera.getClassName()) {
            case "SlrCamera" -> {
                fields.inputStorage.setText(String.valueOf(camera.getStorage()));
                fields.inputZoom.setText(String.valueOf(camera.getZoom()));
            }
            case "WebCamera" -> {
                if (vBoxes.getButtons().connectorTypeC.getText().equals(camera.getOutputConnector())) {
                    vBoxes.getGroups().OutputConnectorGroup.selectToggle(vBoxes.getButtons().connectorTypeC);
                } else {
                    vBoxes.getGroups().OutputConnectorGroup.selectToggle(vBoxes.getButtons().connectorTypeA);
                }
            }
            case "PhoneCamera" -> {
                fields.inputZoom.setText(String.valueOf(camera.getZoom()));
                if (vBoxes.getButtons().frontModule.getText().equals(camera.getSelectedCameraModule())) {
                    vBoxes.getGroups().InputModuleGroup.selectToggle(vBoxes.getButtons().frontModule);
                } else {
                    vBoxes.getGroups().InputModuleGroup.selectToggle(vBoxes.getButtons().mainModule);
                }
            }
        }
    }
    public void EditConfirmButtonHandler(){
        confirmButton.confirmEdit.setOnAction(e ->{
            camera.changeISO(Integer.parseInt(fields.inputISO.getText()));
            camera.changeAperture(Double.parseDouble(fields.inputAperture.getText()));
            camera.changeShootingMode(((RadioButton) vBoxes.getGroups().ShootingModeGroup.getSelectedToggle()).getText());
            switch (camera.getClassName()){
                case "SlrCamera" -> {
                    camera.setStorage(Double.parseDouble(fields.inputStorage.getText()));
                    camera.setZoom(Double.parseDouble(fields.inputZoom.getText()));
                }
                case "WebCamera" -> camera.setOutputConnector(((RadioButton) vBoxes.getGroups().OutputConnectorGroup.getSelectedToggle()).getText());
                case "PhoneCamera" -> {
                    camera.setZoom(Double.parseDouble(fields.inputZoom.getText()));
                    camera.setSelectedCameraModule(((RadioButton) vBoxes.getGroups().InputModuleGroup.getSelectedToggle()).getText());
                }
            }
            new ChangeRowInDB(camera);
            Table.cameraTableView.refresh();

        });
    }


}
