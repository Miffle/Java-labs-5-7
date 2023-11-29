package org.btw.elemetns;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import org.btw.mediafiles.MediaFileType;

public class Buttons {

    public static final Button add = new Button("Создать камеру");
    public static final Button delete = new Button("Удалить камеру");
    public static final Button edit = new Button("Изменить камеру");
    public static final Button use = new Button("Использовать камеру");
    public static final RadioButton SLRCamera = new RadioButton("SLR камера"),
            WebCamera = new RadioButton("Веб камера"),
            PhoneCamera = new RadioButton("Камера телефона");
    public static RadioButton inputShootingModePhoto = new RadioButton(MediaFileType.PHOTO);
    public static RadioButton inputShootingModeVideo = new RadioButton(MediaFileType.VIDEO);
    public static RadioButton connectorTypeA = new RadioButton("USB-A");
    public static RadioButton connectorTypeC = new RadioButton("USB-C");
    public static RadioButton frontModule = new RadioButton("фронтальная камера");
    public static RadioButton mainModule = new RadioButton("Основная камера");
    public static Button confirm = new Button("Подтвердить");

}
