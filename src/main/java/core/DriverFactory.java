package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver() {

        String browser = ConfigurationReader.getProperty(ConfigKeys.BROWSER);

        return switch (browser.toLowerCase()) {
            case "firefox" -> new FirefoxDriver();
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Navegador no existente " + browser);
        };
    }
}