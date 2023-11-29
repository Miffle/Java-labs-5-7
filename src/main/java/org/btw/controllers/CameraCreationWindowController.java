package org.btw.controllers;

import javafx.scene.control.RadioButton;
import org.btw.cameras.AllCamerasStorage;
import org.btw.menus_handlers.CameraCreationHandler;

import static org.btw.elemetns.Buttons.confirm;
import static org.btw.elemetns.Groups.cameraTypeGroup;
import static org.btw.elemetns.Table.table;

public class CameraCreationWindowController {
    public static void ConfirmButtonHandler(){
        confirm.setOnAction(e ->{
            RadioButton cameraType = (RadioButton) cameraTypeGroup.getSelectedToggle();
            String selectedCameraType = cameraType.getText();
            switch (selectedCameraType){
                case "SLR камера" -> CameraCreationHandler.addNewSlrCamera();
                case "Веб камера" -> CameraCreationHandler.addNewWebCamera();
            }
            table.refresh();
            System.out.println(AllCamerasStorage.getAllCamerasArray());
        });
    }
//    private static
}
