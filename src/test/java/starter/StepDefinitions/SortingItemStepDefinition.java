package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.BaseTest;

import static org.junit.Assert.*;


public class SortingItemStepDefinition extends BaseTest {
    @When("User select sort by {string}")
    public void user_select_sort_by(String sortBy) {
        sorting.selectSortOption(sortBy);
    }
    @Then("The products should sorted by {string}")
    public void the_products_should_sorted_by(String sortBy) {
        // Expected - Actual
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
    }
}
