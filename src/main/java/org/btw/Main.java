package org.btw;

import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.mediafiles.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;
import org.btw.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        AllCamerasStorage.add(new WebCamera(2.8, MediaFileType.getPHOTO(), 1000));
        AllCamerasStorage.add(new SlrCamera(5, MediaFileType.getVIDEO(), 100));
        AllCamerasStorage.add(new PhoneCamera(15, MediaFileType.getPHOTO(), 10));
        AllCamerasStorage.add(new SlrCamera(100, MediaFileType.getVIDEO(), 1));
        MainMenu.menu();

    }
}