package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.Pages.SauceDemoCartPage;
import starter.Pages.SauceDemoInventoryPage;
import static org.junit.Assert.*;

public class ContinueShoppingStep extends PageObject {
    WebDriver driver = getDriver();

    SauceDemoInventoryPage inventory;
    SauceDemoCartPage cart;

    private final By cartPageIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    @Step
    public void goToCartPage() {
        driver.findElement(cartPageIcon).click();
    }
    @Step
    public void clickContinueShopping() {
        $(By.id("continue-shopping")).click();
    }

}
