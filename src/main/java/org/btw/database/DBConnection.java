package org.btw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Prop prop = new Prop();
    Connection connection;
    public DBConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6", prop.getDBLogin(), prop.getDBPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
