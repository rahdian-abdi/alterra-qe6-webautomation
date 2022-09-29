package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;
import static org.junit.Assert.*;

public class AddToCartStepDefinition {
    SauceDemoInventoryPage inventory;
    LoginStep login;
    AddToCartStep addtocart;

    @Given("Caca is already login already logged in with {string} username and {string} password")
    public void caca_is_already_login_with_username_and_password(String username, String password) {
        login.loginWithValidCredentialsFull();
    }
    @Given("She is already on inventory page")
    public void she_is_already_on_inventory_page() {
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(inventoryUrl, inventory.verifiedInventoryPage());
    }

    @When("She select item {string}")
    public void she_select_item(String item) {
        addtocart.clickAddToCart(item);
        addtocart.moreItem();
    }

    @Then("Add To Cart icon will get badge count")
    public void add_to_cart_icon_will_get_badge_count() {
        boolean expected = true;
        assertEquals(expected, inventory.verifiedAddToCart());
        // Verify if Badge Number equals to added item
        assertEquals(inventory.verifiedNumberBadge(), inventory.verifiedNumberItemHasAddedToCart());
    }
}
