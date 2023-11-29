package org.btw.cameras;

public class PhoneCamera extends Camera {
    private int lastMediaFileId;
    private final double zoom;
    private final String selectedCameraModule;


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
}
