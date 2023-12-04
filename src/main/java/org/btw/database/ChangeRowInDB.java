package org.btw.database;

import org.btw.models.cameras.Camera;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeRowInDB {
    public ChangeRowInDB(Camera camera) {
        String request = "UPDATE Cameras SET iso="
                + camera.getIso() + ", aperture="
                + camera.getAperture() + ", shootingMode="
                + "'"+camera.getShootingMode()+"'" + ", zoom="
                + camera.getZoom() + ", storage="
                + camera.getStorage() + ", outputConnector="
                +"'"+ camera.getOutputConnector()+"'" + ",inputModule="
                +"'"+ camera.getSelectedCameraModule()+"'" +
                " WHERE id=" + camera.getId();
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
