package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStep extends PageObject {

    WebDriver driver = getDriver();

    private final By checkOutButton = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    @Step
    public void clickCheckoutButton() {
        driver.findElement(checkOutButton).click();
    }

    @Step
    public void inputFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }
    @Step
    public void inputLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }
    @Step
    public void inputPostalCode(String zip) {
        driver.findElement(postalCode).sendKeys(zip);
    }
    @Step
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
    @Step
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

}
