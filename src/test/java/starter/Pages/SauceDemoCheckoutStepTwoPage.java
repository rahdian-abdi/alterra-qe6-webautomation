package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCheckoutStepTwoPage extends PageObject {

    WebDriver driver = getDriver();

    public String verifiedUrl() {
        return driver.getCurrentUrl();
    }

    public int verifiedItemNumberOnStepTwoPage() {
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

    public List<String> productListOnStepTwoPage() {
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
