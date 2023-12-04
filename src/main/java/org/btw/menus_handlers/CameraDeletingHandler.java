package org.btw.menus_handlers;

import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CameraDeletingHandler {
    private static final Logger logger = LoggerFactory.getLogger(CameraDeletingHandler.class);

    /**
     * Функция, отвечающая за удаление камеры из базы.
     */
    public static void cameraDelete() {
        Camera camera = InputValidation.getCamera();
        AllCamerasStorage.remove(AllCamerasStorage.getAllCamerasArray().indexOf(camera));
        System.out.println("Удалил!");
        logger.info("Была удалена камера с ID " + camera.getId());
    }
}
