package lk.kln.mit.config;

import java.io.*;
import java.util.Properties;

public class ConfigHandler {

    private static ConfigHandler instance = new ConfigHandler();

    public String getPath(String key){
        //Set inputstream with file path
        try (InputStream input = new FileInputStream("configs/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value corresponding to the key passed
            return prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ConfigHandler getInstance(){
        return instance;
    }

}
