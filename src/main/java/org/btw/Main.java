package org.btw;

import org.apache.log4j.PropertyConfigurator;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.cameras.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;
import org.btw.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/media/ftliwdt/Secret/Учёба/third_course/java/fifth_lab/src/main/java/org/btw/log4j.properties");
        AllCamerasStorage.add(new WebCamera(2.8, MediaFileType.PHOTO, 1000));
        AllCamerasStorage.add(new SlrCamera(5, MediaFileType.VIDEO, 100));
        AllCamerasStorage.add(new PhoneCamera(15, MediaFileType.PHOTO, 10));
        AllCamerasStorage.add(new SlrCamera(100, MediaFileType.VIDEO, 1));
        MainMenu.menu();

    }
}