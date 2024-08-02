package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Constants.CONFIG_FILE_PATH;

public class ConfigReader {


    public static String getProperty(String propertyKey,String configFilePath) {
        Properties properties;
        String propertyValue = null;
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fis);
            propertyValue = properties.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propertyValue;
    }

    public static String getProperty(String propertyKey) {
        return getProperty(propertyKey,CONFIG_FILE_PATH);
    }

}
