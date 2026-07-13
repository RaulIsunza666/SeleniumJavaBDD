package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By lblTitle = By.className("title");
    private final By btnAddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By btnAddBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By shoppingCart = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart(){
        click(btnAddBackpack, "Botón agregar producto");
    }

    public void addBikeLightToCart(){
        click(btnAddBikeLight, "Botón agregar producto");
    }

    public CartPage openCart(){
        click(shoppingCart, "Botón carrito de compras");
        return new CartPage(driver);
    }

    public String getPageTitle() {
        return getElementText(lblTitle, "Mostrando título de la página");
    }
}