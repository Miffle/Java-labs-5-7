package org.btw.menus_handlers;

import org.btw.models.cameras.Camera;
import org.btw.models.mediafiles.MediaFileType;
import org.btw.menus.ChoiceFunctionsMenu;
import org.btw.menus.Menu;

public class CameraFunctionsHandler {

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
        Menu menu = new ChoiceFunctionsMenu();
        boolean exit = false;
        while (!exit) {
            exit = menu.optionChoice();
        }
    }

    public static void newPhoto() {
        final Camera camera = InputValidation.getCamera();
        camera.createNewMediaFile(MediaFileType.PHOTO);
    }

    public static void newVideo() {
        final Camera camera = InputValidation.getCamera();
        camera.createNewMediaFile(MediaFileType.VIDEO);
    }

    public static void changeShootingMood() {
        final Camera camera = InputValidation.getCamera();
        camera.toggleChangeShootingMode();
    }

    public static void showAllMedia() {
        final Camera camera = InputValidation.getCamera();
        camera.showAllMedia();
    }
}
