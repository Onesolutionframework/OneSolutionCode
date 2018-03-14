package com.servicenow.zProgress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Deepak on 5/7/17.
 */
public class Configuration {

    static Properties prop = null;
    public static String propertyFilePath = "./frontend/src/main/resources/Config.property";

    public static void loadProperties() {
        prop = new Properties();

        try {
            prop.load(new FileInputStream(new File(propertyFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties propertyList(){
        return prop;
    }
}
