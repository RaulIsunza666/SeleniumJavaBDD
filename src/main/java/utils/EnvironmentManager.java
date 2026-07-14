package utils;

import core.ConfigKeys;
import core.ConfigurationReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class EnvironmentManager {

    private EnvironmentManager() {
    }

    public static void createEnvironmentFile() {

        Properties properties = new Properties();

        properties.setProperty(EnvironmentKeys.BROWSER, ConfigurationReader.getProperty(ConfigKeys.BROWSER));
        properties.setProperty(EnvironmentKeys.URL, ConfigurationReader.getProperty(ConfigKeys.URL));
        properties.setProperty(EnvironmentKeys.JAVA, System.getProperty("java.version"));
        properties.setProperty(EnvironmentKeys.OS, System.getProperty("os.name"));
        Path resultsPath = Path.of("target", "allure-results");

        try {

            Files.createDirectories(resultsPath);
            Path environmentFile = resultsPath.resolve("environment.properties");
            try (FileOutputStream output = new FileOutputStream(environmentFile.toFile())) {
                properties.store(output, "Execution Environment");
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "No fue posible generar el archivo environment.properties",
                    e);
        }
    }
}