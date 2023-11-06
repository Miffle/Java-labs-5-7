package org.btw.menus;

import org.btw.Main;
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
                exit = featuresChangeSwitch(functionsChoice, cameraId, exit);
            }
        } else {
            System.out.println("Нет камеры с таким id");
        }
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
     * @param exit            переменная для выхода из цикла (остаётся false только тогда, когда попадает в default)
     * @return exit
     */
    private static boolean featuresChangeSwitch(int functionsChoice, int cameraId, boolean exit) {
        switch (functionsChoice) {
            case 1 -> {
                AllCamerasStorage.get(cameraId - 1).changeISO(CameraFeaturesInput.getIsoForCameras());
                exit = true;
            }
            case 2 -> {
                AllCamerasStorage.get(cameraId - 1).changeAperture(CameraFeaturesInput.getApertureForCameras());
                exit = true;
            }
            case 3 -> {
                AllCamerasStorage.get(cameraId - 1).toggleChangeShootingMode();
                exit = true;
            }
            case 4 -> {
                System.out.println("Ну ладно, выходим");
                logger.info("Выход из меню изменения свойств камеры");
                exit = true;
            }
            default -> {
                logger.warn("Неправильно введено число при выборе действия в изменении свойств камеры");
                System.out.println("Не знаю такого свойства");
            }
        }
        return exit;

    }

    private static void featuresChoiceMenu() {
        System.out.println("""
                Что будем менять?
                1. ISO,
                2. Диафрагму,
                3. Режим съёмки,
                4. Выход.""");
    }
}
