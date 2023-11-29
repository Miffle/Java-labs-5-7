package org.btw.views;

import javafx.stage.Stage;

public class CameraWindow {
    private final Stage stage;

    public CameraWindow(Stage stage) {
        this.stage = stage;
    }

    public void closeWindow() {
        this.stage.close();
    }
}
