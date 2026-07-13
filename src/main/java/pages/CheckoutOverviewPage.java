package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By btnFinish = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage finishPurchase() {
        click(btnFinish, "Botón terminar compra");
        return new CheckoutCompletePage(driver);
    }
}