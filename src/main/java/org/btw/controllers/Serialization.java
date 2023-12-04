package org.btw.controllers;

import org.apache.log4j.Logger;
import org.btw.models.cameras.AllCamerasStorage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization implements Runnable {
    private static final Logger fileLogger = Logger.getLogger("file");

    private static void makeSave() {
        try (FileOutputStream outputStream = new FileOutputStream("save.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            objectOutputStream.writeObject(AllCamerasStorage.getAllCamerasArray());
            fileLogger.info("Состояние программы было сохранено в файл");

        } catch (IOException ex) {
            fileLogger.error("Не удалось сделать сохранение " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        makeSave();
    }
}
