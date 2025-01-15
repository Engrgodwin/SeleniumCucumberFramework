package com.saucedemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    /**
     * Get a property value by key.
     *
     * @param key the property key
     * @return the property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Property " + key + " is not found in the config file.");
        }
        return value;
    }

    /**
     * Get multiple browsers specified in the config file as an array.
     *
     * @return an array of browser names
     */
    public static String[] getBrowsers() {
        String browsers = properties.getProperty("browser");
        if (browsers == null || browsers.isEmpty()) {
            throw new IllegalArgumentException("No browsers specified in the config file.");
        }
        return browsers.split(",");
    }



}
