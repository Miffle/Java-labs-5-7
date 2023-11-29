package org.btw.menus_handlers;

import javafx.scene.control.RadioButton;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.elemetns.Groups;
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
    }

    public static void addNewPhoneCamera() {
        AllCamerasStorage.add(
                new PhoneCamera(
                        Integer.parseInt(TextBoxes.inputAperture.getText()),
                        ((RadioButton) Groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(TextBoxes.inputISO.getText()),
                        Integer.parseInt(TextBoxes.inputZoom.getText()),
                        ((RadioButton) Groups.InputModuleGroup.getSelectedToggle()).getText()
                )
        );
    }

    public static void addNewSlrCamera() {
        AllCamerasStorage.add(
                new SlrCamera(
                        Integer.parseInt(TextBoxes.inputAperture.getText()),
                        ((RadioButton) Groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(TextBoxes.inputISO.getText()),
                        Integer.parseInt(TextBoxes.inputZoom.getText()),
                        Integer.parseInt(TextBoxes.inputStorage.getText())
                )
        );
    }
}
