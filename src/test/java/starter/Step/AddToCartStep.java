package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.Base.BasePageObject;

public class AddToCartStep extends BasePageObject {
    WebDriver driver = getDriver();
    private final By addToCartPrecondition = By.id("add-to-cart-sauce-labs-backpack");
    private final By removePreCondition = By.id("remove-sauce-labs-backpack");
    @Step
    public void clickAddToCart(String item){
        final By itemAdded = By.id(item);
        driver.findElement(itemAdded).click();
    }
    @Step
    public void clickAddToCartPreCondition() {
        driver.findElement(addToCartPrecondition).click();
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
