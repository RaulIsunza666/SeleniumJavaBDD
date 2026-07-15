package base;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import utils.LoggerManager;

import java.time.Duration;

public class BasePage {

    protected final Logger logger = LoggerManager.getLogger(getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void click(By locator, String elementName) {
        logger.info("Click sobre elemento: {}", elementName);
        find(locator).click();
    }

    protected void enterText(By locator, String text, String elementName) {
        logger.info("Escribiendo texto en: {}", elementName);
        find(locator).sendKeys(text);
    }

    protected String getElementText(By locator, String elementName) {
        logger.info("Extrayendo texto de: {}", elementName);
        return find(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        logger.info("Validando elemento mostrado:");
        return find(locator).isDisplayed();
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    private WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}