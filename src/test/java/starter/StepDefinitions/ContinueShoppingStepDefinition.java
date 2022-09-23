package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoCartPage;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.ContinueShoppingStep;
import static org.junit.Assert.*;

public class ContinueShoppingStepDefinition {

    ContinueShoppingStep continueShopping;
    SauceDemoCartPage cart;
    SauceDemoInventoryPage inventory;
    @When("User clicked on the Cart icon")
    public void user_clicked_on_the_cart_icon() {
        continueShopping.goToCartPage();
    }
    @When("User redirected to Cart Page")
    public void user_redirected_to_cart_page() {
        String cartUrl = "https://www.saucedemo.com/cart.html";
        assertEquals(cartUrl, cart.verifiedCartPage());
    }
    @When("User clicked on Continue Shopping")
    public void user_clicked_on_continue_shopping() {
        continueShopping.clickContinueShopping();
    }
    @Then("User should be directed to products page")
    public void user_should_be_directed_to_products_page() {
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(inventoryUrl, inventory.verifiedInventoryPage());
    }
}
