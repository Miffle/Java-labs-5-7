package org.btw;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.mediafiles.MediaFileType;
import org.btw.menus.MainMenu;
import org.btw.menus.Menu;

public class Main {
    public static void main(String[] args) {
        testCamerasCreation();
        Menu menu = new MainMenu();
        boolean exit = false;
        while (!exit){
            exit =  menu.optionChoice();
        }
    }

    private static void testCamerasCreation() {
        AllCamerasStorage.add(new WebCamera(2.8, MediaFileType.PHOTO, 5, 0));
        AllCamerasStorage.add(new SlrCamera(5, MediaFileType.VIDEO, 100, 2, 512));
        AllCamerasStorage.add(new PhoneCamera(15, MediaFileType.PHOTO, 10, 41, 1));
        AllCamerasStorage.add(new SlrCamera(100, MediaFileType.VIDEO, 1, 12, 1024));
    }
}