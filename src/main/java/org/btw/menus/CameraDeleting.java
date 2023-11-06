package org.btw.menus;

import org.btw.Main;
import org.btw.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraDeleting {
    private static final Logger logger = LoggerFactory.getLogger(CameraDeleting.class);

    /**
     * Функция, отвечающая за удаление камеры из базы.
     */
    public static void cameraDelete() {
        int cameraId = CameraFeaturesInput.getCameraId("Введи id камеры, которую хочешь удалить");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.remove(cameraId - 1);
            System.out.println("Удалил!");
            logger.info("Была удалена камера с ID " + cameraId);
        } else System.out.println("Нет камеры с таким id.");
    }

}
