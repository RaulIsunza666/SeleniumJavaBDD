package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {
    private final By btnFinish = By.id("finish");

    public CheckoutCompletePage finishPurchase() {
        click(btnFinish, "Botón terminar compra");
        return new CheckoutCompletePage();
    }
}