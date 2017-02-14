package com.yishnish.samplemvc;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(PropertiesLoader.class.getResource(fileName).openStream());
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
