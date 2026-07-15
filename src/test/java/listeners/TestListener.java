package listeners;

import org.slf4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureManager;
import utils.LoggerManager;

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
        AllureManager.captureScreenshot("Fallo - " + result.getMethod().getMethodName());
    }
}