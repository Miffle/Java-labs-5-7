package org.btw.database;

import org.btw.models.cameras.AllCamerasStorage;
import org.btw.models.cameras.PhoneCamera;
import org.btw.models.cameras.SlrCamera;
import org.btw.models.cameras.WebCamera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFromDB {
    private final Connection connection = new DBConnection().getConnection();

    public ReadFromDB() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Cameras ORDER BY id");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                switch (result.getString(2)) {
                    case "SlrCamera" -> {
                        AllCamerasStorage.add(
                                new SlrCamera(result.getDouble(4),
                                        result.getString(5),
                                        result.getInt(3),
                                        result.getDouble(6),
                                        result.getDouble(7)));
                        AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1).setId(result.getInt(1));
                    }
                    case "WebCamera" -> {
                        AllCamerasStorage.add(
                                new WebCamera(result.getDouble(4),
                                        result.getString(5),
                                        result.getInt(3),
                                        result.getString(8)));
                        AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1).setId(result.getInt(1));
                    }
                    case "PhoneCamera" -> {
                        AllCamerasStorage.add(
                                new PhoneCamera(result.getDouble(4),
                                        result.getString(5),
                                        result.getInt(3),
                                        result.getDouble(6),
                                        result.getString(9))
                        );
                        AllCamerasStorage.get(AllCamerasStorage.getAllCamerasArray().size() - 1).setId(result.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
