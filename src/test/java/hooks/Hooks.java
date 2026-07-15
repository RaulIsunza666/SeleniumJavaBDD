package hooks;

import core.ConfigKeys;
import core.ConfigurationReader;
import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    protected WebDriver driver;

    @Before
    public void setUp() {
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(ConfigurationReader.getProperty(ConfigKeys.URL));
    }

    @After
    public void tearDown(Scenario scenario) {
        DriverFactory.quitDriver();
    }
}