package org.btw.menus_handlers;

import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import org.btw.cameras.*;
import org.btw.elemetns.Groups;
import org.btw.elemetns.Table;
import org.btw.elemetns.TextBoxes;
import org.btw.menus.CreationMenu;

public class CameraCreationHandler {
    /**
     * Функция, отвечающая за создание новой камеры в базе.
     */
    public static void cameraChoice() {
        CreationMenu menu = new CreationMenu();

        boolean exit = false;
        while (!exit) {
            exit = menu.optionChoice();
        }

    }


    public static void addNewWebCamera() {
        AllCamerasStorage.add(
                new WebCamera(
                        Integer.parseInt(TextBoxes.inputAperture.getText()),
                        ((RadioButton) Groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(TextBoxes.inputISO.getText()),
                        ((RadioButton) Groups.OutputConnectorGroup.getSelectedToggle()).getText()
                )
        );
        Table.table.refresh();
    }

    public static void addNewPhoneCamera() {
        AllCamerasStorage.add(
                new PhoneCamera(
                        CameraFeaturesInput.getApertureForCameras(),
                        CameraFeaturesInput.getShootingMod(),
                        CameraFeaturesInput.getIsoForCameras(),
                        CameraFeaturesInput.inputZoomValue(),
                        CameraFeaturesInput.inputModule()
                )
        );
    }

    public static void addNewSlrCamera() {
        AllCamerasStorage.add(
                new SlrCamera(
                        CameraFeaturesInput.getApertureForCameras(),
                        CameraFeaturesInput.getShootingMod(),
                        CameraFeaturesInput.getIsoForCameras(),
                        CameraFeaturesInput.inputZoomValue(),
                        CameraFeaturesInput.inputStorageValue()));
    }
}
