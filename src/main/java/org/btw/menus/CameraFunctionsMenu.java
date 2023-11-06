package org.btw.menus;

import org.btw.Main;
import org.btw.cameras.Camera;
import org.btw.cameras.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraFunctionsMenu {
    private static final Logger logger = LoggerFactory.getLogger(CameraFunctionsMenu.class);

    /**
     * Функция, отвечающая за пятый кейс.
     * Даёт возможность:
     * <ul>
     *     <li>Делать фото</li>
     *     <li>Делать видео</li>
     *     <li>Менять режим съемки</li>
     *     <li>Вывести в консоль все медиафайлы</li>
     * </ul>
     */
    public static void playingWithFunctions() {
        int cameraId = CameraFeaturesInput.getCameraId("Введите ID камеры, которой попробуем воспользоваться");
        if (InputValidation.cameraIdCheck(cameraId)) {
            final Camera camera = AllCamerasStorage.get(cameraId - 1);
            boolean exit = false;
            while (!exit) {
                functionsChoiceMenu();
                int choice = InputValidation.inputInt();
                switch (choice) {
                    case 1 -> {
                        logger.info("Выбран пункт создания фото");
                        camera.createNewMediaFile(MediaFileType.PHOTO);
                    }
                    case 2 -> {
                        logger.info("Выбран пункт создания видео");
                        camera.createNewMediaFile(MediaFileType.VIDEO);
                    }
                    case 3 -> {
                        logger.info("Выбран пункт автоматической смены режима съемки");
                        camera.toggleChangeShootingMode();
                    }
                    case 4 -> {
                        logger.info("Выбран пункт вывода всех медиафайлов на экран");
                        camera.showAllMedia();
                    }
                    case 5 -> {
                        logger.info("Выход из меню взаимодействия с камерой");
                        exit = true;
                    }
                    default -> {
                        logger.warn("Неправильно введено число при выборе действия для взаимодействия с камерой");
                        System.out.println("Не знаю такую команду");
                    }
                }
            }
        }
    }

    private static void functionsChoiceMenu() {
        System.out.println("""
                Что будем делать?
                1. Сделаем фото.
                2. Снимем видео.
                3. Поменяем режим съемки.
                4. Посмотрим все медиафайлы, которые хранятся на камере.
                5. Выход.""");
    }

}
