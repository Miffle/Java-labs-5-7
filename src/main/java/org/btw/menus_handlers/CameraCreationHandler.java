package org.btw.menus_handlers;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
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
        AllCamerasStorage.add(new WebCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
    }

    public static void addNewPhoneCamera() {
        AllCamerasStorage.add(new PhoneCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
    }

    public static void addNewSlrCamera() {
        AllCamerasStorage.add(new SlrCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
    }
}
