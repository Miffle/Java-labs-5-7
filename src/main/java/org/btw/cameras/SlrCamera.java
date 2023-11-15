package org.btw.cameras;

public class SlrCamera extends Camera {
    private int lastMediaFileId;
    private final double zoom;
    private final double storage;


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
}
