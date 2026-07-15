package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    private final By lblCompleteHeader = By.className("complete-header");

    public String getConfirmationMessage() {
        return getElementText(lblCompleteHeader, "Mostrando mensaje de confirmación");
    }
}