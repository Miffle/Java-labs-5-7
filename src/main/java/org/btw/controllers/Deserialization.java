package org.btw.controllers;

import org.apache.log4j.Logger;
import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.Camera;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserialization implements Runnable {
    private static final Logger fileLogger = Logger.getLogger("file");

    public void deserialization() {
        FileInputStream fileInputStream;
        List<Camera> cameras;
        try {
            fileInputStream = new FileInputStream("save.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cameras = (List<Camera>) objectInputStream.readObject();
            AllCamerasStorage.clearAll();
            AllCamerasStorage.allCameras.addAll(cameras);
            fileLogger.info("Камеры были считаны с сохранения.");
        } catch (IOException | ClassNotFoundException e) {
            fileLogger.error("Не удалось прочитать камеры с сохранения, возьмём с базы");
        }
    }

    @Override
    public void run() {
        deserialization();
    }
}
