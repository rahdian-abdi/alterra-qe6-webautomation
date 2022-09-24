package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SauceDemoInventoryPage extends PageObject {
    WebDriver driver = getDriver();

    private final By cartNotification = By.cssSelector(".shopping_cart_badge");
    private final By getHeaderText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By activeSort = By.className("active_option");
    private final By cartBadgeNumber = By.className("shopping_cart_badge");

    public String verifiedInventoryPage(){
        return driver.getCurrentUrl();
    }
    public String verifiedInventoryPageHeader() {
        return driver.findElement(getHeaderText).getText();
    }
    public boolean verifiedAddToCart(){
        return driver.findElement(cartNotification).isDisplayed();
    }
    public int verifiedNumberItemHasAddedToCart() {
        int initiateProductSize = 10;
        List<String> addedItem = new ArrayList<>();
        for (int i=1 ; i<initiateProductSize ; i++){
            try {
                if ($(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div[2]/button"))
                        .getAttribute("innerHTML")
                        .equals("Remove")){
                    addedItem.add($(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div[2]/button"))
                            .getText());
                }
            } catch (Exception e){
                return addedItem.size();
            }
        }
        return addedItem.size();
    }

    public int verifiedNumberBadge() {
        return Integer.parseInt(driver.findElement(cartBadgeNumber).getText());
    }
    public String verifiedActiveSort() {
        return driver.findElement(activeSort).getAttribute("innerHTML");
    }
    public List<String> productListOnInventoryPage() {
        int initiateProductSize = 10;
        List<String> productList = new ArrayList<>();
        for (int i=1 ; i<initiateProductSize ; i++){
            try {
                productList.add($(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div[1]/a/div")).getText());
            } catch (Exception e) {
                return productList;
            }
        }
        return productList;
    }
}