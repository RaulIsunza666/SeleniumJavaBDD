package base;

import core.ConfigKeys;
import core.ConfigurationReader;
import core.DriverFactory;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.EnvironmentManager;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();
        driver.get(ConfigurationReader.getProperty(ConfigKeys.URL));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @BeforeSuite
    public void beforeSuite() {
        EnvironmentManager.createEnvironmentFile();
    }
}