package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SeleniumBDDTests extends BaseTest {

    @Test
    public void validLogin() {
        System.out.println(driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.openCart();
    }

    @Epic("Authentication")
    @Feature("Login")
    @Story("Invalid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void invalidLoginShouldDisplayError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("standard_user","hola");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void completePurchase(){
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventory = loginPage.login("standard_user", "secret_sauce");
        inventory.addBackpackToCart();
        CartPage cart = inventory.openCart();
        Assert.assertTrue(cart.isBackpackDisplayed());
        CheckoutPage checkout = cart.goToCheckout();
        CheckoutOverviewPage overview = checkout.fillCustomerInformation("Raul", "Isunza", "12345");
        CheckoutCompletePage complete = overview.finishPurchase();
        Assert.assertEquals(complete.getConfirmationMessage(), "Thank you for your order!");
    }
}