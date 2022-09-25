package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCartPage extends PageObject {
    WebDriver driver = getDriver();

    private final By cartBadgeNumberOnCart = By.className("shopping_cart_badge");

    public String verifiedCartPage() {
        return driver.getCurrentUrl();
    }
    public int initiateProductListSizeOnCart() {
        List<String> getList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.className("cart_item"));
        for (WebElement list : elementList){
            getList.add(list.getText());
        }
        return getList.size();
    }
    public List<String> initiateProductListOnCart() {
        List<String> getList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.className("inventory_item_name"));
        for (WebElement list : elementList){
            getList.add(list.getText());
        }
        return getList;
    }

    public boolean isItemRemoved() {
        boolean result = false;
        final By catcher = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div");
        try {
            driver.findElement(catcher).isDisplayed();
        }
        catch(Exception e) {
            result = true;
        }
        return result;
    }

    public List<String> productListOnCart() {
        List<String> productList = new ArrayList<>();
        for (int i=3 ; i<initiateProductListSizeOnCart()+3 ; i++){
            try {
                productList.add($(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div["+i+"]/div[2]/a/div")).getText());
            } catch (Exception e) {
                return productList;
            }
        }
        return productList;
    }

    public int verifiedNumberBadge() {
        return Integer.parseInt(driver.findElement(cartBadgeNumberOnCart).getText());
    }

}
