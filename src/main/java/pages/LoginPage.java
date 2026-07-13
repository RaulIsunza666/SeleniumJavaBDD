package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By txtErrorMessage = By.className("error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage login(String usuario, String password) {
        enterText(txtUsername, usuario);
        enterText(txtPassword, password);
        click(btnLogin);
        return new InventoryPage(driver);
    }

    public void invalidLogin(String usuario, String password){
        enterText(txtUsername, usuario);
        enterText(txtPassword, password);
        click(btnLogin);
    }

    public String getErrorMessage() {
        return getElementText(txtErrorMessage);
    }
}