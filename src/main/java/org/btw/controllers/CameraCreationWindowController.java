package org.btw.controllers;

import javafx.scene.control.RadioButton;
import org.btw.elemetns.Table;
import org.btw.menus_handlers.CameraCreationHandler;

import static org.btw.elemetns.Buttons.create;
import static org.btw.elemetns.Groups.cameraTypeGroup;

public class CameraCreationWindowController {
    public static void ConfirmButtonHandler(){
        create.setOnAction(e ->{
            RadioButton cameraType = (RadioButton) cameraTypeGroup.getSelectedToggle();
            String selectedCameraType = cameraType.getText();
            switch (selectedCameraType){
                case "SLR камера" -> CameraCreationHandler.addNewSlrCamera();
                case "Веб камера" -> CameraCreationHandler.addNewWebCamera();
                case "Камера телефона" -> CameraCreationHandler.addNewPhoneCamera();
            }
            Table.updateList();
            Table.table.refresh();
        });
    }

}
