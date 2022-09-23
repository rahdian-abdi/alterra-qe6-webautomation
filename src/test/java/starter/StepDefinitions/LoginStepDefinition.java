package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.LoginStep;

public class LoginStepDefinition {
    LoginStep login;
    SauceDemoInventoryPage inventory;

    @Given("Caca is on the homepage")
    public void caca_is_on_the_homepage() {
        login.openPage();
    }
    @When("She input {string} on the username field")
    public void she_input_on_the_username_field(String username) {
        login.inputUsername(username);
    }
    @When("She input {string} on the password field")
    public void she_input_on_the_password_field(String password) {
       login.inputPassword(password);
    }
    @When("She click on the Login button")
    public void she_click_on_the_login_button() {
        login.clickLogin();
    }
    @Then("She will be directed to inventory page")
    public void she_will_be_directed_to_inventory_page() {
        if (login.loginVerified() && inventory.verifiedInventoryPageHeader().equals("PRODUCTS")){
            System.out.println("Successfully login");
        }
    }

    @Then("She fail to login")
    public void sheFailToLogin() {
        login.failToLogin();

    }
}
