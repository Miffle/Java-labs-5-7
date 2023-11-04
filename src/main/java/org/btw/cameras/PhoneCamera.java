package org.btw.cameras;

public class PhoneCamera extends Camera{
    int lastMediaFileId;
    public PhoneCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
