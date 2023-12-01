package org.btw.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    FileInputStream file;
    Properties prop = new Properties();
    public Prop(){
        try {
            file = new FileInputStream("src/main/resources/app.properties");
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getDBLogin(){
        return prop.getProperty("DBLogin");
    }
    public String getDBPassword(){
        return prop.getProperty("DBPassword");
    }
}
