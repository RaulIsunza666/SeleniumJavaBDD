package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By btnCheckout = By.id("checkout");
    private final By backpackName = By.xpath("//div[text()='Sauce Labs Backpack']");

    public boolean isBackpackDisplayed() {
        return isElementDisplayed(backpackName);
    }

    public CheckoutPage goToCheckout() {
        click(btnCheckout,"Botón checkout");
        return new CheckoutPage();
    }
}