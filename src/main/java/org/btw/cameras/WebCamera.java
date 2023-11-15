package org.btw.cameras;

public class WebCamera extends Camera {
    private int lastMediaFileId;
    private final int outputConnector;


    public WebCamera(double aperture, String shootingMode, int iso, int outputConnector) {
        super(aperture, shootingMode, iso);
        this.outputConnector = outputConnector;
    }


    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tКоннектор = " + this.outputConnector;
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
