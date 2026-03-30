package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        try {
            String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read config.properties file.");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
