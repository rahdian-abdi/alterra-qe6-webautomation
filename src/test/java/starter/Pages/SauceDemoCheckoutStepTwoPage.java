package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoCheckoutStepTwoPage extends PageObject {

    WebDriver driver = getDriver();

    public String verifiedUrl() {
        return driver.getCurrentUrl();
    }
    public int initiateNumberOfListItemInPageTwo(){
        List<String> getList = new ArrayList<>();
        List<WebElement> element = driver.findElements(By.className("inventory_item_name"));
        for (WebElement ge : element){
            getList.add(ge.getText());
        }
        return getList.size();
    }
    public List<String> initiateListItemInPageTwo() {
        List<String> getList = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.className("inventory_item_name"));
        for (WebElement we : elements){
            getList.add(we.getText());
        }
        return getList;
    }
}
