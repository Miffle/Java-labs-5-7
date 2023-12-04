package org.btw.cameras;

public class PhoneCamera extends Camera {
    private int lastMediaFileId;
    private double zoom;
    private String selectedCameraModule;


    /**
     * @param aperture     Диафрагма
     * @param shootingMode Режим съемки
     * @param iso          исо
     */
    public PhoneCamera(double aperture, String shootingMode, int iso, double zoom, String selectedCameraModule) {
        super(aperture, shootingMode, iso);
        this.zoom = zoom;
        this.selectedCameraModule = selectedCameraModule;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\tZoom = " + zoom + "\n" +
                "\tВыбранный модуль камеры = " + selectedCameraModule;
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
        this.zoom = zoom;
    }

    @Override
    public void setStorage(double storage) {

    }

    @Override
    public void setOutputConnector(String connector) {

    }

    @Override
    public void setSelectedCameraModule(String Module) {
        this.selectedCameraModule = Module;
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
        return selectedCameraModule;
    }
}
