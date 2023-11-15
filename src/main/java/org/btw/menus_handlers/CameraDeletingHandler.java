package org.btw.menus_handlers;

import org.btw.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraDeletingHandler {
    private static final Logger logger = LoggerFactory.getLogger(CameraDeletingHandler.class);

    /**
     * Функция, отвечающая за удаление камеры из базы.
     */
    public static void cameraDelete() {
        int cameraId = InputValidation.getCameraId("Введи id камеры, которую хочешь удалить");
        if (InputValidation.cameraIdCheck(cameraId)) {
            AllCamerasStorage.remove(cameraId - 1);
            System.out.println("Удалил!");
            logger.info("Была удалена камера с ID " + cameraId);
        } else System.out.println("Нет камеры с таким id.");
    }

}
