package org.btw.menus;

import org.btw.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraFeaturesMenu {
    private static final Logger logger = LoggerFactory.getLogger(CameraFeaturesMenu.class);
    /**
     * Функция, отвечающая за изменение свойств камеры
     */
    public static void featuresChoice() {
        featuresChoiceMenu();
        int functionsChoice = InputValidation.inputInt();
        int cameraId = CameraFeaturesInput.getCameraId("Введи id камеры, свойства которой хочешь поменять");
        if (InputValidation.cameraIdCheck(cameraId)) {
            boolean exit = false;
            while (!exit) {
                exit = featuresChangeSwitch(functionsChoice, cameraId);
            }
        } else {
            System.out.println("Нет камеры с таким id");
        }
    }

    private static void featuresChoiceMenu() {
        System.out.println("""
                Что будем менять?
                1. ISO,
                2. Диафрагму,
                3. Режим съёмки,
                4. Выход.""");
    }

    /**
     * switch для {@link CameraFeaturesMenu#featuresChoice()} функции
     *
     * @param functionsChoice выбор пользователя
     *                        <ul>
     *                        <li>Изменить ISO</li>
     *                        <li>Изменить диафрагму</li>
     *                        <li>Изменить режим съемки</li>
     *                        </ul>
     * @param cameraId        ID камеры, к которой применяются изменения
     * @return exit
     */
    private static boolean featuresChangeSwitch(int functionsChoice, int cameraId) {
        switch (functionsChoice) {
            case 1 -> {
                AllCamerasStorage.get(cameraId - 1).changeISO(CameraFeaturesInput.getIsoForCameras());
                return true;
            }
            case 2 -> {
                AllCamerasStorage.get(cameraId - 1).changeAperture(CameraFeaturesInput.getApertureForCameras());
                return true;
            }
            case 3 -> {
                AllCamerasStorage.get(cameraId - 1).toggleChangeShootingMode();
                return true;
            }
            case 4 -> {
                System.out.println("Ну ладно, выходим");
                logger.info("Выход из меню изменения свойств камеры");
                return true;
            }
            default -> {
                logger.warn("Неправильно введено число при выборе действия в изменении свойств камеры");
                System.out.println("Не знаю такого свойства");
            }
        }
        return false;

    }
}
