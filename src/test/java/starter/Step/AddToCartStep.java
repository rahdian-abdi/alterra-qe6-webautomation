package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.Pages.SauceDemoInventoryPage;

public class AddToCartStep extends PageObject {
    WebDriver driver = getDriver();
    @Step
    public void clickAddToCart(String item){
        final By itemAdded = By.id(item);
        driver.findElement(itemAdded).click();
    }
    @Step
    public void clickAddToCartPre() {
        $(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
}
