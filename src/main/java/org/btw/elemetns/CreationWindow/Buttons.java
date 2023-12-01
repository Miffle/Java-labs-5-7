package org.btw.elemetns.CreationWindow;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import org.btw.mediafiles.MediaFileType;

public class Buttons {
    public final RadioButton SLRCamera = new RadioButton("SLR камера"),
            WebCamera = new RadioButton("Веб камера"),
            PhoneCamera = new RadioButton("Камера телефона");
    public RadioButton inputShootingModePhoto = new RadioButton(MediaFileType.PHOTO);
    public RadioButton inputShootingModeVideo = new RadioButton(MediaFileType.VIDEO);
    public RadioButton connectorTypeA = new RadioButton("USB-A");
    public RadioButton connectorTypeC = new RadioButton("USB-C");
    public RadioButton frontModule = new RadioButton("фронтальная камера");
    public RadioButton mainModule = new RadioButton("Основная камера");
    public Button create = new Button("Подтвердить");




}
