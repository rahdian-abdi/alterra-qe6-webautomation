package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;

public class AddToCartStepDefinition {
    LoginStep login;
    AddToCartStep addtocart;
    @Given("Caca is already login already logged in with {string} username and {string} password")
    public void caca_is_already_login_with_username_and_password(String username, String password) {
        login.loginWithValidCredentialsFull();
    }
    @Given("She is already on inventory page")
    public void she_is_already_on_inventory_page() {
        login.loginVerified();
    }

    @When("She select item {string}")
    public void she_select_item(String item) {
        addtocart.clickAddToCart(item);
    }

    @Then("Add To Cart icon will get badge count")
    public void add_to_cart_icon_will_get_badge_count() {
        addtocart.addToCartVerified();
    }
}