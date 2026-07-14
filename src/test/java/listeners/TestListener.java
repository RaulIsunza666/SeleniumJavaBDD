package listeners;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureManager;
import utils.LoggerManager;
import utils.ScreenshotManager;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Iniciando prueba: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Prueba exitosa: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Prueba fallida: {}", result.getMethod().getMethodName());
        WebDriver driver = DriverFactory.getDriver();
        byte [] screenshot = ScreenshotManager.takeScreenshot(driver);
        AllureManager.attachScreenshot(screenshot);
    }
}