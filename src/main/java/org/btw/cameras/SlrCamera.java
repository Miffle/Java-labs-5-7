package org.btw.cameras;

public class SlrCamera extends Camera {
    private int lastMediaFileId;
    private double zoom;
    private String lens;
    public SlrCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso, "SlrCamera");
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
