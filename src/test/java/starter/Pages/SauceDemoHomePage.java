package starter.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/")
public class SauceDemoHomePage extends PageObject {
    WebDriver driver = getDriver();

    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public String failToLoginMessage(){
        return driver.findElement(errorMessage).getText();
    }

}
