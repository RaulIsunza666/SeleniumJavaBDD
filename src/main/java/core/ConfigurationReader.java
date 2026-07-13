package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {

        try (InputStream input = ConfigurationReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró config.properties");
            }

            properties.load(input);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public static String getProperty(String key) {

        return properties.getProperty(key);

    }
}
