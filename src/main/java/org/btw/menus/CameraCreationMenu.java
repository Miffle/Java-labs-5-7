package org.btw.menus;

import org.btw.Main;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraCreationMenu {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Функция, отвечающая за создание новой камеры в базе.
     */
    public static void cameraChoice() {
        cameraChoiceMenu();
        boolean exit = false;
        while (!exit) {
            int cameraChoice = InputValidation.inputInt();
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
                logger.info("Выход из процесса создания камеры");
                System.out.println("Ладно, не буду создавать");
                exit = true;
            }
            default -> {
                 logger.warn("Неправильно введено число при выборе создаваемой камеры");
                System.out.println("Я не знаю такую команду, давай заново.");

            }
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
