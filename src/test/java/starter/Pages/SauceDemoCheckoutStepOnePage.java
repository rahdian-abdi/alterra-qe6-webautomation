package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class SauceDemoCheckoutStepOnePage extends PageObject {
    WebDriver driver = getDriver();

    public String verifiedUrl() {
        return driver.getCurrentUrl();
    }


}
