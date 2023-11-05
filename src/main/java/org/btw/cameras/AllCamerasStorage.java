package org.btw.cameras;

import java.util.ArrayList;
import java.util.List;

public class AllCamerasStorage {
    static private final List<Camera> allCameras = new ArrayList<>();

    /**
     * Выводит список всех камер, которые есть в базе
     */
    public static void getAllCameras() {
        for (Camera cam :
                AllCamerasStorage.allCameras) {
            cam.getCamera();
        }
    }
    public static List<Camera> getAllCamerasArray(){
        return allCameras;
    }
    public static void add(Camera camera) {
        allCameras.add(camera);
    }

    public static void remove(int id) {
        allCameras.remove(id);
    }

    public static Camera get(int id) {
        return allCameras.get(id);
    }

}
