package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.Pages.SauceDemoCartPage;

import static org.junit.Assert.*;

public class RemoveItemStep extends PageObject {
    WebDriver driver = getDriver();
    SauceDemoCartPage cart;

    private final By goToCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    @Step
    public void addMoreItem(String addToCartItemId) {
        final By item = By.id("add-to-cart-"+addToCartItemId);
        driver.findElement(item).click();
    }
    @Step
    public void clickCartIcon() {
        driver.findElement(goToCart).click();
    }
    @Step
    public void removeItem(String removeItem) {
        final By item = By.id("remove-"+removeItem);
        driver.findElement(item).click();
    }

}
