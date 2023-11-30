package org.btw.cameras;

public class WebCamera extends Camera {
    private int lastMediaFileId;
    private String outputConnector;


    public WebCamera(double aperture, String shootingMode, int iso, String outputConnector) {
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

    @Override
    public double getStorage() {
        return 0;
    }

    @Override
    public void setZoom(double zoom) {

    }

    @Override
    public void setStorage(double storage) {

    }

    @Override
    public void setOutputConnector(String connector) {
        this.outputConnector = connector;
    }

    @Override
    public void setSelectedCameraModule(String Module) {

    }

    @Override
    public double getZoom() {
        return 0;
    }

    @Override
    public String getOutputConnector() {
        return outputConnector;
    }

    @Override
    public String getSelectedCameraModule() {
        return null;
    }
}
