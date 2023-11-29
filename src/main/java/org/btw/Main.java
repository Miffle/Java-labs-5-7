package org.btw;

import javafx.application.Application;
import javafx.stage.Stage;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;
import org.btw.mediafiles.MediaFileType;
import org.btw.views.MainWindow;

public class Main extends Application {
    public static void main(String[] args) {
        testCamerasCreation();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        new MainWindow(stage);
    }

    private static void testCamerasCreation() {
        AllCamerasStorage.add(new WebCamera(2.8, MediaFileType.PHOTO, 5, "USB-A"));
        AllCamerasStorage.add(new SlrCamera(5, MediaFileType.VIDEO, 100, 2, 512));
        AllCamerasStorage.add(new PhoneCamera(15, MediaFileType.PHOTO, 10, 41, 1));
        AllCamerasStorage.add(new SlrCamera(100, MediaFileType.VIDEO, 1, 12, 1024));
    }
}