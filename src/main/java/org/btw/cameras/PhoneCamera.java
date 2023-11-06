package org.btw.cameras;

public class PhoneCamera extends Camera {
    private int lastMediaFileId;
    private boolean macroShootingSupport;
    private double storage;
    private double zoom;
    private int selectedCameraModule;


    /**
     * @param aperture     Диафрагма
     * @param shootingMode Режим съемки
     * @param iso          исо
     */
    public PhoneCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso);
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
