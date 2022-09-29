package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.Pages.SauceDemoHomePage;
import starter.Pages.SauceDemoInventoryPage;

public class LoginStep extends PageObject {

    SauceDemoHomePage home;
    SauceDemoInventoryPage inventory;
    WebDriver driver = getDriver();

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    @Step
    public void openPage(){
        home.open();
    }
    @Step
    public void inputUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    @Step
    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    @Step
    public void loginWithValidCredentialsFull(){
        home.open();
        inputUsername("standard_user");
        inputPassword("secret_sauce");
        clickLogin();
    }
}
