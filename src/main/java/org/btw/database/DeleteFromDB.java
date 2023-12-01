package org.btw.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromDB {
    public DeleteFromDB(int id){
        String request = "DELETE FROM Cameras WHERE id="+id;
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
