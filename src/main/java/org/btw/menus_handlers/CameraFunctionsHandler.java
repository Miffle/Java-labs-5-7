package org.btw.menus_handlers;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.mediafiles.MediaFileType;
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
    public static void newPhoto(){
        final Camera camera = getCamera();
        camera.createNewMediaFile(MediaFileType.PHOTO);
    }
    public static void newVideo(){
        final Camera camera = getCamera();
        camera.createNewMediaFile(MediaFileType.VIDEO);
    }
    public static void changeShootingMood(){
        final Camera camera = getCamera();
        camera.toggleChangeShootingMode();
    }
    public static void showAllMedia(){
        final Camera camera = getCamera();
        camera.showAllMedia();
    }

    private static Camera getCamera() {
        int cameraId = InputValidation.getCameraId("Введите ID камеры, которой попробуем воспользоваться");
        return AllCamerasStorage.get(cameraId - 1);
    }

}
