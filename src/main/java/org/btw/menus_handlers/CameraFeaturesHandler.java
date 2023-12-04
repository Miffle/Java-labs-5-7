package org.btw.menus_handlers;

import org.btw.models.cameras.AllCamerasStorage;
import org.btw.menus.ChangeFeaturesMenu;
import org.btw.menus.Menu;

public class CameraFeaturesHandler {

    /**
     * Функция, отвечающая за изменение свойств камеры
     */
    public static void featuresChoice() {
        Menu menu = new ChangeFeaturesMenu();
        boolean exit = false;
        while (!exit) {
            exit = menu.optionChoice();
        }
    }

    public static void FChangeISO() {
        int cameraId = InputValidation.getCameraId("Введи id камеры, свойства которой хочешь поменять");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.get(cameraId - 1).changeISO(CameraFeaturesInput.getIsoForCameras());
        }
    }

    public static void FChangeAperture() {
        int cameraId = InputValidation.getCameraId("Введи id камеры, свойства которой хочешь поменять");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.get(cameraId - 1).changeAperture(CameraFeaturesInput.getApertureForCameras());
        }
    }

    public static void FChangeShootingMode() {
        int cameraId = InputValidation.getCameraId("Введи id камеры, свойства которой хочешь поменять");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.get(cameraId - 1).toggleChangeShootingMode();
        }
    }

}
