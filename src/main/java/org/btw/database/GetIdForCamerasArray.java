package org.btw.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetIdForCamerasArray {
    Connection connection = new DBConnection().getConnection();
    public int getNewId(){
        try {
            String request = "SELECT * FROM Cameras ORDER BY id DESC";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet result = statement.executeQuery(request);
            result.next();
            int resultId = result.getInt("id")+1;
            return resultId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
