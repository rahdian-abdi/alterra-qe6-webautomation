package starter.Base;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePageObject extends PageObject {

    WebDriver driver = getDriver();
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void click(By by){
        findElement(by).click();
    }
    public WebElement getElement(By by){
        return findElement(by);
    }
    public List<WebElement> getElementList(By by){
        return findElements(by);
    }
    public String getTextWebElement(WebElement e){
        return e.getText();
    }
    public String getText(By by) {
        return findElement(by).getText();
    }
    public boolean isDisplayed(By by){
        return findElement(by).isDisplayed();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
