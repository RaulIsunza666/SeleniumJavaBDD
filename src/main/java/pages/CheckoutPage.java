package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By txtFirstName = By.id("first-name");
    private final By txtLastName = By.id("last-name");
    private final By txtPostalCode = By.id("postal-code");
    private final By btnContinue = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage fillCustomerInformation(String firstName, String lastName, String postalCode) {
        enterText(txtFirstName, firstName, "Ingresando nombre: ".concat(firstName));
        enterText(txtLastName, lastName, "Ingresando apellido: ".concat(lastName));
        enterText(txtPostalCode, postalCode, "Ingresando C.P.: ".concat(postalCode));
        click(btnContinue, "Botón CheckoutOverview");
        return new CheckoutOverviewPage(driver);
    }
}