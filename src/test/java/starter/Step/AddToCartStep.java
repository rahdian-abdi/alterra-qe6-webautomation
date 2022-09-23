package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.Pages.SauceDemoInventoryPage;

public class AddToCartStep extends PageObject {
    SauceDemoInventoryPage inventory;
    @Step
    public void clickAddToCart(String item){
        $(By.id(item)).click();
    }
    @Step
    public void addToCartVerified(){
        if (inventory.verifiedAddToCart()) {
            System.out.println("Item successfully added");
        };
    }

    @Step
    public void clickAddToCartPre() {
        $(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
}
