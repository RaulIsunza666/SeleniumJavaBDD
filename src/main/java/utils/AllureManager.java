package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

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
}