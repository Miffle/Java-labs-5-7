package org.btw.cameras;

public class PhoneCamera extends Camera {
    private int lastMediaFileId;
    private boolean macroShootingSupport;

    /**
     * @param aperture     Диафрагма
     * @param shootingMode Режим съемки
     * @param iso          исо
     */
    public PhoneCamera(double aperture, String shootingMode, int iso) {
        super(aperture, shootingMode, iso, "PhoneCamera");
    }

    @Override
    protected int makeIdForNewMediaFile() {
        return ++lastMediaFileId;
    }
}
