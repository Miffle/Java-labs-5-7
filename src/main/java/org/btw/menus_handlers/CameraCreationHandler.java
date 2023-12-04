package org.btw.menus_handlers;

import javafx.scene.control.RadioButton;
import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.PhoneCamera;
import org.btw.models.cameras.SlrCamera;
import org.btw.models.cameras.WebCamera;
import org.btw.database.InputInDB;
import org.btw.elemetns.CreationWindow.Groups;
import org.btw.elemetns.CreationWindow.TextFields;
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


    public static void addNewWebCamera(TextFields fields, Groups groups) {
        AllCamerasStorage.add(
                new WebCamera(
                        Integer.parseInt(fields.inputAperture.getText()),
                        ((RadioButton) groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(fields.inputISO.getText()),
                        ((RadioButton) groups.OutputConnectorGroup.getSelectedToggle()).getText()
                )
        );
        new Thread(new InputInDB(AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1))).start();
    }

    public static void addNewPhoneCamera(TextFields fields, Groups groups) {
        AllCamerasStorage.add(
                new PhoneCamera(
                        Integer.parseInt(fields.inputAperture.getText()),
                        ((RadioButton) groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(fields.inputISO.getText()),
                        Integer.parseInt(fields.inputZoom.getText()),
                        ((RadioButton) groups.InputModuleGroup.getSelectedToggle()).getText()
                )
        );
        new Thread(new InputInDB(AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1))).start();


    }

    public static void addNewSlrCamera(TextFields fields, Groups groups) {
        AllCamerasStorage.add(
                new SlrCamera(
                        Integer.parseInt(fields.inputAperture.getText()),
                        ((RadioButton) groups.ShootingModeGroup.getSelectedToggle()).getText(),
                        Integer.parseInt(fields.inputISO.getText()),
                        Integer.parseInt(fields.inputZoom.getText()),
                        Integer.parseInt(fields.inputStorage.getText())
                )
        );
        new Thread(new InputInDB(AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1))).start();

    }
}
