package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartStep extends PageObject {
    WebDriver driver = getDriver();

    private final By removePreCondition = By.id("remove-sauce-labs-backpack");
    @Step
    public void clickAddToCart(String item){
        final By itemAdded = By.id(item);
        driver.findElement(itemAdded).click();
    }
    @Step
    public void clickAddToCartPreCondition() {
        $(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @Step
    public void clickRemovePreCondition() {
        driver.findElement(removePreCondition).click();
    }
    @Step
    public void moreItem(){
        $(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }
}
