package org.btw.menus;

public class CameraFeaturesInput {
    public static int getCameraId(String x) {
        System.out.println(x);
        return InputValidation.inputInt();
    }

    public static int getIsoForCameras() {
        System.out.println("Введи целое число для значения ISO");
        return InputValidation.isoInputValidation();
    }

    public static String getShootingMod() {
        System.out.println("Введи 'photo' или 'video' для выбора начального режима съёмки");
        return InputValidation.inputShootingMod();
    }

    public static double getApertureForCameras() {
        System.out.println("Введи число для значения диафрагмы");
        return InputValidation.apertureInputValidation();
    }

}