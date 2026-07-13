package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By btnCheckout = By.id("checkout");
    private final By backpackName = By.xpath("//div[text()='Sauce Labs Backpack']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBackpackDisplayed() {
        return isElementDisplayed(backpackName, "Validando elemento renderizado");
    }

    public CheckoutPage goToCheckout() {
        click(btnCheckout,"Botón checkout");
        return new CheckoutPage(driver);
    }
}