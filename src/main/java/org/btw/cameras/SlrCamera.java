package org.btw.cameras;

public class SlrCamera extends Camera {
    private int lastMediaFileId;
    private double zoom;
    private String lens;
    private double storage;


    public SlrCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
