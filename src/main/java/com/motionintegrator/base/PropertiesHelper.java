package com.motionintegrator.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    public Properties properties;
//    public String browser;
    public String baseUrl;

    public PropertiesHelper() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("src\\main\\resources\\config\\config.properties");
            properties.load(fis);

            baseUrl = properties.getProperty("baseUrl");
//            browser = properties.getProperty("browser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
