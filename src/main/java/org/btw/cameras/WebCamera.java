package org.btw.cameras;

public class WebCamera extends Camera{
    int lastMediaFileId;
    public WebCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
