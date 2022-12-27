package starter;

import starter.Pages.SauceDemoHomePage;
import starter.Pages.SauceDemoInventoryPage;
import starter.Step.AddToCartStep;
import starter.Step.LoginStep;
import starter.Step.SortingItemStep;

public class BaseTest {
    public SauceDemoInventoryPage inventory = new SauceDemoInventoryPage();
    public LoginStep login = new LoginStep();
    public AddToCartStep addToCart = new AddToCartStep();
    public SortingItemStep sorting = new SortingItemStep();
    public SauceDemoHomePage home = new SauceDemoHomePage();
}
