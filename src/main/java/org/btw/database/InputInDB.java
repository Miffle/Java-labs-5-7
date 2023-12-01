package org.btw.database;

import org.btw.cameras.Camera;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InputInDB {
    public InputInDB(Camera camera) {
        String request = "INSERT INTO Cameras(id,className,iso,aperture,shootingMode,zoom,storage,outputConnector,inputModule) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.setInt(1,camera.getId());
            statement.setString(2,camera.getClassName());
            statement.setInt(3,camera.getIso());
            statement.setDouble(4,camera.getAperture());
            statement.setString(5,camera.getShootingMode());
            statement.setDouble(6,camera.getZoom());
            statement.setDouble(7,camera.getStorage());
            statement.setString(8,camera.getOutputConnector());
            statement.setString(9,camera.getSelectedCameraModule());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
