package utils;

import core.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureManager {
    private AllureManager() {
    }

    public static void step (String description) {
        Allure.step(description);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }

    public static void captureScreenshot(String name) {

        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            System.out.println("No fue posible tomar screenshot: el driver es null.");
            return;
        }
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}