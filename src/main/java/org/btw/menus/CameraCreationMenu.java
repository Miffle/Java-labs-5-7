package org.btw.menus;

import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.mediafiles.AllCamerasStorage;

public class CameraCreationMenu {
    /**
     * Функция, отвечающая за создание новой камеры в базе.
     */
    public static void cameraChoice() {
        cameraChoiceMenu();
        int cameraChoice = InputValidation.inputInt();
        boolean exit = false;
        while (!exit) {
            exit = cameraChoiceSwitch(cameraChoice, exit);
        }
    }

    /**
     * switch для {@link CameraCreationMenu#cameraChoice()} функции.
     *
     * @param cameraChoice выбор камеры (1 - slr, 2 - Phone, 3 - Web, 4 - выход)
     * @param exit         - переменная для остановки цикла (при true останавливается)
     * @return exit
     */

    private static boolean cameraChoiceSwitch(int cameraChoice, boolean exit) {
        switch (cameraChoice) {
            case 1 -> {
                AllCamerasStorage.add(new SlrCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
                exit = true;
            }
            case 2 -> {
                AllCamerasStorage.add(new PhoneCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
                exit = true;
            }
            case 3 -> {
                AllCamerasStorage.add(new WebCamera(CameraFeaturesInput.getApertureForCameras(), CameraFeaturesInput.getShootingMod(), CameraFeaturesInput.getIsoForCameras()));
                exit = true;
            }
            case 4 -> {
                System.out.println("Ладно, не буду создавать");
                exit = true;
            }
            default -> System.out.println("Я не знаю такую команду, давай заново.");
        }
        return exit;
    }

    private static void cameraChoiceMenu() {
        System.out.println("""
                Какую камеру хочешь создать?
                1. SLR Камера (зеркалка),
                2. Камера телефона,
                3. Веб камера,
                4. Выход из создания.""");
    }
}
