package org.btw.models.cameras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllCamerasStorage {
    public static List<Camera> allCameras = new ArrayList<>();

    /**
     * Выводит список всех камер, которые есть в базе
     */
    public static void getAllCameras() {
        for (Camera cam :
                AllCamerasStorage.allCameras) {
            System.out.println(cam);
        }
    }
    public static List<Camera> getAllCamerasArray(){
        return Collections.unmodifiableList(allCameras);
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
    public static void clearAll(){
        allCameras.clear();
    }
}
