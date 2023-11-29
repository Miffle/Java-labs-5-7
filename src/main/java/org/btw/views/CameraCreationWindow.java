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

// TODO: 29.11.2023 Добавить валидацию ввода значений
public class CameraCreationWindow {
    private static final String REGEX_VALID_INTEGER = "^([1-9][0-9]{0,2}|1000)$";

    public CameraCreationWindow(Stage stage) {
        Scene scene = new Scene(makeGroup());
        stage.setScene(scene);
        stage.setWidth(250);
        stage.setHeight(350);
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
        addInputsToHBox(vBox);
        cameraTypeGroup.selectToggle(SLRCamera);
        return vBox;
    }

    private static void addInputsToHBox(VBox vBox) {
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

    private static void addTextBlockToVBox(VBox vBox, Label label, TextField field) {
        vBox.getChildren().add(label);
        vBox.getChildren().add(field);
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
            }else{
                ModuleInput(vBox);
            }
            vBox.getChildren().add(confirm);
        });
    }

    private void zoomInput(VBox vBox) {
        setInputMaxWidth(inputZoom);
        addTextBlockToVBox(vBox, ZoomLabel, inputZoom);
    }

    private void storageInput(VBox vBox) {
        setInputMaxWidth(inputStorage);
        addTextBlockToVBox(vBox, StorageLabel, inputStorage);
    }

    private static void ISOInput(VBox vBox) {
        inputISO.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                inputISO.setText(t1.replaceAll("\\D", ""));
            }
        });
        inputISO.setTextFormatter(new TextFormatter<>(CameraCreationWindow::filter));
        setInputMaxWidth(inputISO);
        addTextBlockToVBox(vBox, ISOLabel, inputISO);
    }

    private static void ApertureInput(VBox vBox) {
        setInputMaxWidth(inputAperture);
        addTextBlockToVBox(vBox, ApertureLabel, inputAperture);
    }

    private void outputConnectorInput(VBox vBox) {
        makeToggleGroupForProperties(OutputConnectorGroup, vBox, connectorTypeA, connectorTypeC, OutputConnectorLabel);
    }

    private static void ShootingModeInput(VBox vBox) {
        makeToggleGroupForProperties(ShootingModeGroup,vBox,inputShootingModePhoto, inputShootingModeVideo, ShootingModeLabel);
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

    private static TextFormatter.Change filter(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER)) {
            change.setText("");
        }
        return change;
    }
}
