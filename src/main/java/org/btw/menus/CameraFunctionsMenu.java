package org.btw.menus;

import org.btw.cameras.Camera;
import org.btw.mediafiles.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;

public class CameraFunctionsMenu {
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
                    case 1 -> camera.createNewMediaFile(MediaFileType.getPHOTO());
                    case 2 -> camera.createNewMediaFile(MediaFileType.getVIDEO());
                    case 3 -> camera.toggleChangeShootingMode();
                    case 4 -> camera.showAllMedia();
                    case 5 -> exit = true;
                    default -> throw new IllegalStateException("Не знаю такую команду: " + choice);
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
