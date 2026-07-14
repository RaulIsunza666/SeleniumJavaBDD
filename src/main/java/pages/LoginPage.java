package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureManager;

public class LoginPage extends BasePage {

    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By txtErrorMessage = By.className("error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage login(String usuario, String password) {
        AllureManager.step("Ingresar usuario");
        enterText(txtUsername, usuario, "Campo \"User\"");
        AllureManager.step("Ingresar contraseña");
        enterText(txtPassword, password, "Campo \"Password\"");
        AllureManager.step("Presionar Botón Login");
        click(btnLogin, "Botón login");
        return new InventoryPage(driver);
    }

    public void invalidLogin(String usuario, String password){
        enterText(txtUsername, usuario, "Ingresando credenciales de usuario:");
        enterText(txtPassword, password, "Ingresando Contraseña");
        click(btnLogin,"Botón login");
    }

    public String getErrorMessage() {
        return getElementText(txtErrorMessage, "Mostrando mensaje de error esprado");
    }
}