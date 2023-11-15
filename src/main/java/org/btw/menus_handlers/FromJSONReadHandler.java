package org.btw.menus_handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class FromJSONReadHandler {
    private static final Logger logger = LoggerFactory.getLogger(CameraDeletingHandler.class);
    public static void readFromJSON() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Camera.class, new CameraAdapter());
        Gson gson = gsonBuilder.create();
        try {
            Camera[] cameras = gson.fromJson(new FileReader("result.json"), Camera[].class);
            AllCamerasStorage.clearAll();
            for (Camera camera : cameras) {
                AllCamerasStorage.add(camera);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
