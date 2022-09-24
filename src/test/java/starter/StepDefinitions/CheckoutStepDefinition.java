package starter.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoCartPage;
import starter.Pages.SauceDemoCheckoutComplete;
import starter.Pages.SauceDemoCheckoutStepOnePage;
import starter.Pages.SauceDemoCheckoutStepTwoPage;
import starter.Step.CheckoutStep;
import static org.junit.Assert.*;

public class CheckoutStepDefinition {
    CheckoutStep checkoutStep;
    SauceDemoCartPage cart;
    SauceDemoCheckoutStepOnePage stepOne;
    SauceDemoCheckoutStepTwoPage stepTwo;
    SauceDemoCheckoutComplete complete;

    @When("User click on Checkout Button")
    public void user_click_on_checkout_button() {
        cart.verifiedItemNumberOnCart();
        cart.productListOnCart();
        checkoutStep.clickCheckoutButton();
    }
    @When("User is redirected to Checkout Step One Page")
    public void user_is_redirected_to_checkout_step_one_page() {
        String url = "https://www.saucedemo.com/checkout-step-one.html";
        assertEquals(url, stepOne.verifiedUrl());
    }
    @When("User input first name on {string} field")
    public void user_input_first_name_on_field(String fName) {
        checkoutStep.inputFirstName(fName);
    }
    @When("User input last name on {string} field")
    public void user_input_last_name_on_field(String lName) {
        checkoutStep.inputLastName(lName);
    }
    @When("User input postal code on {string} field")
    public void user_input_postal_code_on_field(String zip) {
        checkoutStep.inputPostalCode(zip);
    }
    @When("User click on Continue Button")
    public void user_click_on_continue_button() {
        checkoutStep.clickContinueButton();
    }
    @When("User is redirected to Checkout Step Two Page")
    public void user_is_redirected_to_checkout_step_two_page() {
        String url = "https://www.saucedemo.com/checkout-step-two.html";
        assertEquals(url, stepTwo.verifiedUrl());
        // Verify that number of item on cart equals to number of item on final page
        assertEquals(cart.verifiedItemNumberOnCart(), stepTwo.verifiedItemNumberOnStepTwoPage());
        // Verify that item on cart appear on final page
        assertEquals(cart.productListOnCart(), stepTwo.productListOnStepTwoPage());
    }
    @When("User click on Finish Button")
    public void user_click_on_finish_button() {
        checkoutStep.clickFinishButton();
    }
    @Then("User will be directed to Checkout Complete Page")
    public void user_will_be_directed_to_checkout_complete_page() {
        String url = "https://www.saucedemo.com/checkout-complete.html";
        assertEquals(url, complete.verifiedUrl());
    }
}
