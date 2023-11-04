package org.btw.cameras;

public class SlrCamera extends Camera {
    int lastMediaFileId;

    public SlrCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
