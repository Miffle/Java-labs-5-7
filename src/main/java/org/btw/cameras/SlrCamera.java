package org.btw.cameras;

public class SlrCamera extends Camera {
    private int lastMediaFileId;
    private double zoom;
    private double storage;

    public SlrCamera(double aperture, String shootingMode, int iso, double zoom, double storage) {
        super(aperture, shootingMode, iso);
        this.zoom = zoom;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tZoom = " + this.zoom + "\n" +
                "\tХранилище = " + this.storage;
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }

    @Override
    public double getStorage() {
        return storage;
    }

    @Override
    public void setZoom(double zoom){
        this.zoom = zoom;
    }

    @Override
    public void setStorage(double storage) {
        this.storage = storage;
    }

    @Override
    public void setOutputConnector(String connector) {

    }

    @Override
    public void setSelectedCameraModule(String Module) {

    }

    @Override
    public double getZoom() {
        return zoom;
    }

    @Override
    public String getOutputConnector() {
        return null;
    }

    @Override
    public String getSelectedCameraModule() {
        return null;
    }
}
