package org.btw.menus_handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.btw.models.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class JSONSaveHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger("file");
    public void createJSONFile() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        try (FileWriter file = new FileWriter("result.json")) {
            gson.toJson(AllCamerasStorage.getAllCamerasArray(), file);
            logger.info("Сохранено в result.json");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void run() {
        createJSONFile();
    }
}
