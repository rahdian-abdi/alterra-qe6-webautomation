package starter.Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.Base.BasePageObject;

import java.util.*;


public class SauceDemoInventoryPage extends BasePageObject {


    private final By cartNotification = By.cssSelector(".shopping_cart_badge");
    private final By getHeaderText = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By activeSort = By.className("active_option");
    private final By cartBadgeNumber = By.className("shopping_cart_badge");
    private final By numberOfProductList = By.className("inventory_item_name");

    public String verifiedInventoryPage(){
        return getUrl();
    }
    public String verifiedInventoryPageHeader() {
        return getText(getHeaderText);
    }
    public boolean verifiedAddToCart(){
        return isDisplayed(cartNotification);
    }
    public int initiateProductListSize() {
        List<String> getList = new ArrayList<>();
        List<WebElement> elementList = getElementList(numberOfProductList);
        for (WebElement list : elementList){
            getTextWebElement(list);
        }
        return getList.size();
    }
    public List<String> initiateProductList() {
        List<String> getList = new ArrayList<>();
        List<WebElement> elementList = findElements(numberOfProductList);
        for (WebElement list : elementList){
            getList.add(list.getText());
        }
        return getList;
    }
    public List<Float> initiatePriceList() {
        final By price = By.className("inventory_item_price");
        List<Float> getPriceList = new ArrayList<>();
        List<WebElement> priceElement = findElements(price);
        for (WebElement element : priceElement) {
            getPriceList.add(Float.parseFloat(element.getText().substring(1)));
        }
        return getPriceList;
    }
    public int verifiedNumberItemHasAddedToCart() {
        // can't use btn btn_secondary btn_small btn_inventory because class names not permitted
        // Thus using full xpath to get list that "Remove" button is exist on inventory page
        List<String> addedItem = new ArrayList<>();
        for (int i=1 ; i<initiateProductListSize() ; i++){
            try {
                if (getElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div[2]/button"))
                        .getAttribute("innerHTML")
                        .equals("Remove")){
                    addedItem.add(getElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div[2]/button"))
                            .getText());
                }
            } catch (Exception e){
                return addedItem.size();
            }
        }
        return addedItem.size();
    }

    public int verifiedNumberBadge() {
        return Integer.parseInt(getText(cartBadgeNumber));
    }
    public String verifiedActiveSort() {
        return getElement(activeSort).getAttribute("innerHTML");
    }
    public String[] verifiedAscendingSortingItem() {
        String[] arraySorted = new String[initiateProductListSize()];
        for (int i=0 ; i<initiateProductListSize();i++){
            arraySorted[i] = initiateProductList().get(i);
        }
        Arrays.sort(arraySorted);
        return arraySorted;
    }
    public String[] verifiedDescendingSortingItem() {
        String[] arraySorted = new String[initiateProductListSize()];
        for (int i=0 ; i<initiateProductListSize();i++){
            arraySorted[i] = initiateProductList().get(i);
        }
        Arrays.sort(arraySorted, Collections.reverseOrder());
        return arraySorted;
    }
    public Float[] verifiedAscendingPriceSortingItem() {
        Float[] arraySorted = new Float[initiateProductListSize()];
        for (int i=0 ; i<initiateProductListSize(); i++){
            arraySorted[i] = initiatePriceList().get(i);
        }
        Arrays.sort(arraySorted);
        return arraySorted;
    }

    public Float[] verifiedDescendingPriceSortingItem() {
        Float[] arraySorted = new Float[initiateProductListSize()];
        for (int i=0 ; i<initiateProductListSize(); i++){
            arraySorted[i] = initiatePriceList().get(i);
        }
        Arrays.sort(arraySorted, Collections.reverseOrder());
        return arraySorted;
    }

    public HashMap<String, Float> productAndPrice() {
        HashMap<String, Float> hm = new HashMap<>();
        for (int i=0 ; i<initiateProductListSize();i++){
            hm.put(initiateProductList().get(i), initiatePriceList().get(i));
        }
        return hm;
    }

    public HashMap<String, Float> productAndListAsc(){
        HashMap<String, Float> hmAsc = new HashMap<>();
        List<String> key = new ArrayList<>(productAndPrice().keySet());
        Collections.sort(key);
        //for (int i=0 ; i<key.size() ; i++){
        //    hmAsc.put(key.get(i), productAndPrice().get(key.get(i)));
        //}

        for (String k : key){
            hmAsc.put(k, productAndPrice().get(k));
        }
        return hmAsc;
    }

}