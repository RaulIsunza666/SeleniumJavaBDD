package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AllureManager;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("el usuario abre la aplicación")
    public void el_usuario_abre_la_aplicación() {

    }
    @When("ingresa credenciales válidas")
    public void ingresa_credenciales_válidas() {
        loginPage.login("standard_user", "secret_sauce");
    }
    @Then("visualiza el inventario")
    public void visualiza_el_inventario() {
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
        AllureManager.captureScreenshot("Página productos");
    }

    @When("ingresa nombre válido y contraseña incorrecta")
    public void ingresaNombreVálidoYContraseñaIncorrecta() {
        loginPage.invalidLogin("standard_user","hola");
    }

    @When("ingresa nombre inválido y contraseña correcta")
    public void ingresaNombreInválidoYContraseñaCorrecta() {
        loginPage.invalidLogin("standard","secret_sauce");
    }

    @Then("visualiza mensaje de error")
    public void visualizaMensajeDeError() {
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        AllureManager.captureScreenshot("Mensaje de error esperado");
    }
}