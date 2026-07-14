package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void initializeDriver() {
        String browser = ConfigurationReader.getProperty(ConfigKeys.BROWSER);
        WebDriver driver = switch (browser.toLowerCase()) {
            case "firefox" -> new FirefoxDriver();
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Navegador no existente " + browser);
        };
        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            DRIVER.remove();
        }
    }
}