package org.btw.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.btw.controllers.CameraCreationWindowController;

import java.util.Objects;

import static org.btw.elemetns.Buttons.*;
import static org.btw.elemetns.Groups.*;
import static org.btw.elemetns.TextBoxes.*;

public class CameraCreationWindow {
    private static final String REGEX_VALID_INTEGER_TO_ISO = "^([1-9][0-9]{0,2}|1000)$";
    private static final String REGEX_VALID_INTEGER_TO_APERTURE_AND_ZOOM = "^([1-9]|10)$";
    private static final String REGEX_VALID_INTEGER_TO_STORAGE = "^([1-9][0-9]{0,2}|1000)$";

    public CameraCreationWindow(Stage stage) {
        Scene scene = new Scene(makeGroup());
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Создание камеры");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        CameraCreationWindowController.ConfirmButtonHandler();
        stage.show();
    }

    private VBox makeGroup() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        makeToggleGroup(cameraTypeGroup);
        groupSelectedListener(vBox, cameraTypeGroup);
        addCheckBoxToHBox(vBox);
        addInputsToVBox(vBox);
        cameraTypeGroup.selectToggle(PhoneCamera);
        return vBox;
    }

    private static void addInputsToVBox(VBox vBox) {
        ISOInput(vBox);
        ApertureInput(vBox);
        ShootingModeInput(vBox);
    }


    private static void addCheckBoxToHBox(VBox vBox) {
        vBox.getChildren().add(TypeLabel);
        vBox.getChildren().add(SLRCamera);
        vBox.getChildren().add(WebCamera);
        vBox.getChildren().add(PhoneCamera);
    }

    private static void makeToggleGroup(ToggleGroup checkGroup) {
        SLRCamera.setToggleGroup(checkGroup);
        WebCamera.setToggleGroup(checkGroup);
        PhoneCamera.setToggleGroup(checkGroup);
    }

    private static void setInputMaxWidth(TextField textField) {
        textField.setMaxWidth(100);
    }


    private static void addTextBlockToVBox(VBox vBox, VBox v) {
        v.setAlignment(Pos.CENTER);
        vBox.getChildren().add(v);
    }

    private void zoomInput(VBox vBox) {
        makeOnlyInt(inputZoom);
        setInputMaxWidth(inputZoom);
        inputZoom.setTextFormatter(new TextFormatter<>(CameraCreationWindow::filterForApertureAndZoom));
        addTextBlockToVBox(vBox, zoomVbox);
    }

    private void storageInput(VBox vBox) {
        makeOnlyInt(inputStorage);
        setInputMaxWidth(inputStorage);
        inputStorage.setTextFormatter(new TextFormatter<>(CameraCreationWindow::filterForStorage));
        addTextBlockToVBox(vBox, storageVbox);
    }

    private static void ISOInput(VBox vBox) {
        makeOnlyInt(inputISO);
        inputISO.setTextFormatter(new TextFormatter<>(CameraCreationWindow::filterForISO));
        setInputMaxWidth(inputISO);
        addTextBlockToVBox(vBox, isoVbox);
    }

    private static void ApertureInput(VBox vBox) {
        makeOnlyInt(inputAperture);
        inputAperture.setTextFormatter(new TextFormatter<>(CameraCreationWindow::filterForApertureAndZoom));
        setInputMaxWidth(inputAperture);
        addTextBlockToVBox(vBox, apertureVbox);
    }

    private void outputConnectorInput(VBox vBox) {
        makeToggleGroupForProperties(OutputConnectorGroup, vBox, connectorTypeA, connectorTypeC, OutputConnectorLabel);
    }

    private static void ShootingModeInput(VBox vBox) {
        makeToggleGroupForProperties(ShootingModeGroup, vBox, inputShootingModePhoto, inputShootingModeVideo, ShootingModeLabel);
    }

    private static void ModuleInput(VBox vBox) {
        makeToggleGroupForProperties(InputModuleGroup, vBox, frontModule, mainModule, ModuleLabel);
    }

    private static void makeToggleGroupForProperties(ToggleGroup group, VBox vBox, RadioButton btn1, RadioButton btn2, Label label) {
        btn1.setToggleGroup(group);
        btn2.setToggleGroup(group);
        vBox.getChildren().add(label);
        vBox.getChildren().add(btn1);
        vBox.getChildren().add(btn2);
        group.selectToggle(btn1);
    }

    private void groupSelectedListener(VBox vBox, ToggleGroup group) {
        group.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if (vBox.getChildren().size() > 11) {
                vBox.getChildren().subList(11, vBox.getChildren().size()).clear();
            }
            RadioButton selectedButton = (RadioButton) t1;
            if (Objects.equals(selectedButton.getText(), "SLR камера")) {
                zoomInput(vBox);
                storageInput(vBox);
            } else if (Objects.equals(selectedButton.getText(), "Веб камера")) {
                outputConnectorInput(vBox);
            } else {
                zoomInput(vBox);
                ModuleInput(vBox);
            }
            vBox.getChildren().add(create);
        });
    }

    private static void makeOnlyInt(TextField inputAperture) {
        inputAperture.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                inputAperture.setText(t1.replaceAll("\\D", ""));
            }
            if (t1.isEmpty()) {
                inputAperture.setText(String.valueOf(1));
            }
        });
    }

    private static TextFormatter.Change filterForISO(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER_TO_ISO)) {
            change.setText("");
        }
        return change;
    }

    private static TextFormatter.Change filterForApertureAndZoom(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER_TO_APERTURE_AND_ZOOM)) {
            change.setText("");
        }
        return change;
    }

    private static TextFormatter.Change filterForStorage(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER_TO_STORAGE)) {
            change.setText("");
        }
        return change;
    }

}
