package org.btw.elemetns;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
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
    public static Button create = new Button("Подтвердить");
    public static Button confirmEdit = new Button("Подтвердить");

    public static VBox inputShootingModeVBox() {
        VBox inputShootingModeVBox = new VBox();
        return fillVBox(inputShootingModeVBox, TextBoxes.ShootingModeLabel, Groups.ShootingModeGroup, inputShootingModePhoto, inputShootingModeVideo);
    }

    public static VBox connectorTypeVBox() {
        VBox connectorTypeVBox = new VBox();
        return fillVBox(connectorTypeVBox, TextBoxes.OutputConnectorLabel, Groups.OutputConnectorGroup, connectorTypeA, connectorTypeC);
    }

    public static VBox moduleVBox() {
        VBox moduleVBox = new VBox();
        return fillVBox(moduleVBox, TextBoxes.ModuleLabel, Groups.InputModuleGroup, frontModule, mainModule);
    }

    private static VBox fillVBox(VBox v, Label l, ToggleGroup g, RadioButton r1, RadioButton r2) {
        r1.setToggleGroup(g);
        r2.setToggleGroup(g);
        v.getChildren().addAll(l, r1, r2);
        return v;
    }
}
