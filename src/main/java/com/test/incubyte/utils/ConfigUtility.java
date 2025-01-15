package com.test.incubyte.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
    private final Properties properties;
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";


    public ConfigUtility() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a property by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Writes a key-value pair to the properties file.
     *
     * @param key   the property key
     * @param value the property value
     */
    public static void writeProperty(String key, String value) {
        Properties properties = new Properties();

        try (FileOutputStream fileOutputStream = new FileOutputStream(PROPERTIES_FILE_PATH, true)) {
            properties.setProperty(key, value);
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write to the properties file.");
        }
    }

    /**
     * Writes user credentials to the properties file.
     *
     * @param email the user's email
     */
    public static void writeUserEmail(String email) {
        writeProperty("email", email);
    }
}
