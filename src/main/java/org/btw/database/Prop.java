package org.btw.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {

    Properties prop = new Properties();
    public Prop(){

        try (InputStream file = getClass().getResourceAsStream("/app.properties")){
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
