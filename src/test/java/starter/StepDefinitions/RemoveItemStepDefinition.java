package starter.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoCartPage;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;
import starter.Step.RemoveItemStep;
import static org.junit.Assert.*;

public class RemoveItemStepDefinition {
    RemoveItemStep removeItem;
    SauceDemoCartPage cart;
    @When("User add item with Add To Cart id {string}")
    public void user_add_item_with_add_to_cart_id(String addToCartItemId) {
        removeItem.addMoreItem(addToCartItemId);
    }
    @When("User click on cart icon")
    public void user_click_on_cart_icon() {
        removeItem.clickCartIcon();
    }
    @When("User is directed to Cart Page")
    public void user_is_directed_to_cart_page() {
        cart.verifiedCartPage();
        assertEquals(2, cart.verifiedItemNumberOnCart());
    }
    @When("User remove item with id {string}")
    public void user_remove_item_with_id(String remove) {
        removeItem.removeItem(remove);
        assertEquals(1, cart.verifiedItemNumberOnCart());
    }
    @Then("Item will be removed from cart")
    public void item_will_be_removed_from_cart() {
        boolean result = true;
        assertEquals(result, cart.isItemRemoved());
    }
}
