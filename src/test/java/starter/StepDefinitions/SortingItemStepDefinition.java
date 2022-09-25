package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;
import starter.Step.SortingItemStep;

import static org.junit.Assert.*;


public class SortingItemStepDefinition {
    SauceDemoInventoryPage inventory;
    LoginStep login;
    AddToCartStep addtocart;
    SortingItemStep sorting;

    @Given("User already logged in")
    public void user_already_logged_in() {
        login.loginWithValidCredentialsFull();
    }
    @Given("User already add an item to cart")
    public void user_already_add_an_item_to_cart() {
        addtocart.clickAddToCartPre();
    }
    @When("User select sort by {string}")
    public void user_select_sort_by(String sortBy) {
        sorting.selectSortOption(sortBy);
    }
    @Then("The products should sorted by {string}")
    public void the_products_should_sorted_by(String sortBy) {
        assertEquals(sortBy, inventory.verifiedActiveSort());
        // Verify that first item appear is as expected
        String expectedFirst = "Test.allTheThings() T-Shirt (Red)";
        assertEquals(expectedFirst, inventory.initiateProductList().get(0));
        // Verify that last item appear is as expected
        String expectedLast = "Sauce Labs Backpack";
        assertEquals(expectedLast, inventory.initiateProductList().get(5));
        inventory.verifiedDescendingSortingItem();
        // To confirm sorted items are the same
        String[] productSortedList = new String[inventory.initiateProductListSize()];
        for (int i=0 ; i<inventory.initiateProductListSize();i++){
            productSortedList[i] = inventory.initiateProductList().get(i);
        }
        assertArrayEquals(inventory.verifiedDescendingSortingItem(), productSortedList);
    }
}
