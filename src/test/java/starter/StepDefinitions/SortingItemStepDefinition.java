package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.pages.PageObject;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;
import starter.Step.SortingItemStep;

import static org.junit.Assert.*;


public class SortingItemStepDefinition extends PageObject {
    SauceDemoInventoryPage inventory;
    LoginStep login;
    AddToCartStep addToCart;
    SortingItemStep sorting;

    @Given("User already logged in")
    public void user_already_logged_in() {
        login.loginWithValidCredentialsFull();
    }
    @Given("User already add an item to cart")
    public void user_already_add_an_item_to_cart() {
        addToCart.clickAddToCartPreCondition();
    }
    @When("User select sort by {string}")
    public void user_select_sort_by(String sortBy) {
        sorting.selectSortOption(sortBy);
    }
    @Then("The products should sorted by {string}")
    public void the_products_should_sorted_by(String sortBy) {
        assertEquals(sortBy, inventory.verifiedActiveSort());
        switch (sortBy) {
            case "Name (A to Z)":
                String[] productAscSortedList = new String[inventory.initiateProductListSize()];
                for (int i=0 ; i<inventory.initiateProductListSize();i++){
                    productAscSortedList[i] = inventory.initiateProductList().get(i);
                }
                assertArrayEquals(inventory.verifiedAscendingSortingItem(), productAscSortedList);
                break;
            case "Name (Z to A)":
                String[] productDescSortedList = new String[inventory.initiateProductListSize()];
                for (int i=0 ; i<inventory.initiateProductListSize();i++){
                    productDescSortedList[i] = inventory.initiateProductList().get(i);
                }
                assertArrayEquals(inventory.verifiedDescendingSortingItem(), productDescSortedList);
                break;
            case "Price (low to high)":
                Float[] priceAscSortedList = new Float[inventory.initiateProductListSize()];
                for (int i=0 ; i<inventory.initiateProductListSize();i++){
                    priceAscSortedList[i] = inventory.initiatePriceList().get(i);
                }
                assertArrayEquals(inventory.verifiedAscendingPriceSortingItem(), priceAscSortedList);
                break;
            case "Price (high to low)":
                Float[] priceDescSortedList = new Float[inventory.initiateProductListSize()];
                for (int i=0 ; i<inventory.initiateProductListSize();i++){
                    priceDescSortedList[i] = inventory.initiatePriceList().get(i);
                }
                assertArrayEquals(inventory.verifiedDescendingPriceSortingItem(), priceDescSortedList);
                break;
            default:
                System.out.println("Not expected");
        }
        addToCart.clickRemovePreCondition();
    }
}
