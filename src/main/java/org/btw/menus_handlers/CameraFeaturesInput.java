package org.btw.menus_handlers;

public class CameraFeaturesInput {
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

    public static double inputZoomValue() {
        System.out.println("Введи значение Zoom.");
        double value;
        while (true) {
            value = InputValidation.inputDouble();
            if (value < 100 && value >= 0.5) {
                return value;
            }
        }
    }

    public static int inputModule() {
        System.out.println("Выбери модуль: \n\t 0) Фронтальная камера \n\t 1) Основная камера");
        int value;
        while (true) {
            value = InputValidation.inputInt();
            if (value == 0 || value == 1) {
                return value;
            }
        }
    }

    public static int inputConnector() {
        System.out.println("""
                Введи тип коннектора:
                \t 0) А
                \t 1) C""");
        int value;
        while (true) {
            value = InputValidation.inputInt();
            if (value == 0 || value == 1) {
                return value;
            }
        }
    }
    public static double inputStorageValue() {
        System.out.println("Введи размер хранилища.");
        double value;
        while (true) {
            value = InputValidation.inputDouble();
            if (value <= 1024 && value >= 0.5) {
                return value;
            }
        }
    }

}
