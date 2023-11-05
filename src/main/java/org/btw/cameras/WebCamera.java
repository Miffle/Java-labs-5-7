package org.btw.cameras;

public class WebCamera extends Camera{
    private int lastMediaFileId;
    private String outputConnector; //A C


    public WebCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso, "WebCamera");
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
