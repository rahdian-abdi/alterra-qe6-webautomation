package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCartPage extends PageObject {
    WebDriver driver = getDriver();

    public String verifiedCartPage() {
        return driver.getCurrentUrl();
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

    public int verifiedItemNumberOnCart() {
        int initiateProductSize = 10;
        int actualProductSize = 0;
        List<String> productList = new ArrayList<>();
        for (int i=3 ; i<initiateProductSize ; i++){
            try {
                productList.add($(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div["+i+"]/div[2]/a/div")).getText());
            } catch (Exception e) {
                actualProductSize = productList.size();
            }
        }
        return actualProductSize;
    }

    public List<String> productListOnCart() {
        int initiateProductSize = 10;
        List<String> productList = new ArrayList<>();
        for (int i=3 ; i<initiateProductSize ; i++){
            try {
                productList.add($(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div["+i+"]/div[2]/a/div")).getText());
            } catch (Exception e) {
                return productList;
            }
        }
        return productList;
    }

}
