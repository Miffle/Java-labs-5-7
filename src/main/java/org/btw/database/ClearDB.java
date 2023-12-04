package org.btw.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClearDB {
    Connection connection = new DBConnection().getConnection();
    public ClearDB(){
        String request = "DELETE FROM Cameras";
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
