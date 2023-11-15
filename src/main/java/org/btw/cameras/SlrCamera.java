package org.btw.cameras;

import org.btw.menus_handlers.InputValidation;

public class SlrCamera extends Camera {
    private int lastMediaFileId;
    private double zoom;
    private String lens;
    private double storage;


    public SlrCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
        this.zoom = inputZoomValue();
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


    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
