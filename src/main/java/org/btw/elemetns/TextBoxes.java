package org.btw.elemetns;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TextBoxes {
    public static TextField inputISO = new TextField("1");
    public static TextField inputAperture = new TextField("1");
    public static TextField inputZoom = new TextField("1");
    public static TextField inputStorage = new TextField("1");
    public static Label TypeLabel = new Label("Выбери тип камеры");
    public static Label ZoomLabel = new Label("Введите значение приближения");
    public static Label StorageLabel = new Label("Введите размер памяти");
    public static Label ISOLabel = new Label("Введите ISO");
    public static Label ApertureLabel = new Label("Введите значение диафрагмы");
    public static Label ShootingModeLabel = new Label("Введите режим съемки");
    public static Label OutputConnectorLabel = new Label("Введите тип разъема");
    public static Label ModuleLabel = new Label("Введите рабочий модуль");
    public static VBox isoVbox = new VBox(ISOLabel, inputISO);
    public static VBox apertureVbox = new VBox(ApertureLabel, inputAperture);
    public static VBox zoomVbox = new VBox(ZoomLabel, inputZoom);
    public static VBox storageVbox = new VBox(StorageLabel, inputStorage);
}
