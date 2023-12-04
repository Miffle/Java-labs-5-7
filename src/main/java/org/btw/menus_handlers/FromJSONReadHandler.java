package org.btw.menus_handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.database.ClearDB;
import org.btw.database.InputInDB;
import org.btw.mediafiles.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class FromJSONReadHandler {
    private static final Logger logger = LoggerFactory.getLogger("file");
    public static void readFromJSON() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Camera.class, new CameraAdapter());
        gsonBuilder.registerTypeAdapter(Media.class, new MediaAdapter());
        Gson gson = gsonBuilder.create();
        try {
            Camera[] cameras = gson.fromJson(new FileReader("result.json"), Camera[].class);
            new ClearDB();
            AllCamerasStorage.clearAll();
            for (Camera camera : cameras) {
                AllCamerasStorage.add(camera);
                new InputInDB(camera);
            }
            logger.info("Камеры считаны с JSON");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
