package org.btw.elemetns.CreationWindow;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.btw.elemetns.Table;
import org.btw.menus_handlers.CameraCreationHandler;


public class VBoxes {
    public final VBox typeV = new VBox();
    public final VBox zoomV = new VBox();
    public final VBox apertureV = new VBox();
    public final VBox isoV = new VBox();
    public final VBox storageV = new VBox();
    public final VBox shootingModeV = new VBox();
    public final VBox outputConnectorV = new VBox();
    public final VBox moduleV = new VBox();
    private final Buttons buttons = new Buttons();
    private final TextFields fields = new TextFields();
    private final Groups groups = new Groups(buttons);
    public VBoxes(){
        Labels labels = new Labels();
        fillVBoxes(labels, buttons, fields);
        ConfirmButtonHandler();
    }

    private void fillVBoxes(Labels labels, Buttons buttons, TextFields fields) {
        vBoxCreation(typeV, labels.TypeLabel, buttons.SLRCamera, buttons.WebCamera, buttons.PhoneCamera);
        vBoxCreation(zoomV, labels.ZoomLabel, fields.inputZoom);
        vBoxCreation(apertureV, labels.ApertureLabel, fields.inputAperture);
        vBoxCreation(isoV, labels.ISOLabel, fields.inputISO);
        vBoxCreation(storageV, labels.StorageLabel, fields.inputStorage);
        vBoxCreation(shootingModeV, labels.ShootingModeLabel, buttons.inputShootingModePhoto, buttons.inputShootingModeVideo);
        vBoxCreation(outputConnectorV, labels.OutputConnectorLabel, buttons.connectorTypeC, buttons.connectorTypeA);
        vBoxCreation(moduleV, labels.ModuleLabel, buttons.frontModule, buttons.mainModule);
    }

    private void vBoxCreation(VBox v, Label l, TextField t){
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(l,t);
    }
    private void vBoxCreation(VBox v, Label l, RadioButton r1, RadioButton r2){
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(l,r1,r2);
    }
    private void vBoxCreation(VBox v, Label l, RadioButton r1, RadioButton r2, RadioButton r3){
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(l,r1,r2,r3);
    }
    public void ConfirmButtonHandler(){
        buttons.create.setOnAction(e ->{
            RadioButton cameraType = (RadioButton) groups.cameraTypeGroup.getSelectedToggle();
            String selectedCameraType = cameraType.getText();
            switch (selectedCameraType){
                case "SLR камера" -> CameraCreationHandler.addNewSlrCamera(getFields(), getGroups());
                case "Веб камера" -> CameraCreationHandler.addNewWebCamera(getFields(), getGroups());
                case "Камера телефона" -> CameraCreationHandler.addNewPhoneCamera(getFields(), getGroups());
            }
            Table.updateCamerasList();
            Table.cameraTableView.refresh();
        });
    }

    public Buttons getButtons() {
        return buttons;
    }

    public TextFields getFields() {
        return fields;
    }

    public Groups getGroups() {
        return groups;
    }
}
