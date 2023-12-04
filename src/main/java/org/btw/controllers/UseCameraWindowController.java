package org.btw.controllers;


import org.btw.models.cameras.Camera;
import org.btw.elemetns.Table;
import org.btw.models.mediafiles.MediaFileType;

import static org.btw.elemetns.Buttons.*;

public class UseCameraWindowController {
    public static void makeButtonsEnable(Camera camera) {
        makePhoto.setOnAction(e -> {
            camera.createNewMediaFile(MediaFileType.PHOTO);
            Table.updateMediaList(camera);
        });
        makeVideo.setOnAction(e -> {
            camera.createNewMediaFile(MediaFileType.VIDEO);
            Table.updateMediaList(camera);
        });
        changeShootingMode.setOnAction(e -> {
            camera.toggleChangeShootingMode();
            Table.updateCamerasList();
        });
    }
}
