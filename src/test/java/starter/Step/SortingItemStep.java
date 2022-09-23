package starter.Step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import starter.Pages.SauceDemoInventoryPage;

public class SortingItemStep extends PageObject {
    SauceDemoInventoryPage inventory;
    WebDriver driver = getDriver();
    private final By sortOptionDropdown = By.className("product_sort_container");

    @Step
    public void selectSortOption(String sortBy) {
        Select sortDropDown = new Select(driver.findElement(sortOptionDropdown));
        sortDropDown.selectByVisibleText(sortBy);
    }

}
