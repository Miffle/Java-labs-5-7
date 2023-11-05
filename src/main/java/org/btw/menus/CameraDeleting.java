package org.btw.menus;

import org.btw.mediafiles.AllCamerasStorage;

public class CameraDeleting {
    /**
     * Функция, отвечающая за удаление камеры из базы.
     */
    public static void cameraDelete() {
        int cameraId = CameraFeaturesInput.getCameraId("Введи id камеры, которую хочешь удалить");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.remove(cameraId - 1);
            System.out.println("Удалил!");
        } else System.out.println("Нет камеры с таким id.");
    }

}
