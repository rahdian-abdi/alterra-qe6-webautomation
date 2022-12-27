package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoHomePage;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.LoginStep;
import static org.junit.Assert.*;

public class LoginStepDefinition {
    LoginStep login;
    SauceDemoInventoryPage inventory;
    SauceDemoHomePage home;

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
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(inventoryUrl, inventory.verifiedInventoryPage());
        String homeTitle = "products";
        assertEquals(homeTitle, inventory.verifiedInventoryPageHeader().toLowerCase());
    }
    @Then("She fail to login")
    public void sheFailToLogin() {
        assertNotNull(home.failToLoginMessage());
    }
}
