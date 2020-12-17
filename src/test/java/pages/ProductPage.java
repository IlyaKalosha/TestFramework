package pages;

import PageElements.SignInElement;
import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    protected static WebDriver driver;
    protected SignInElement signInElement;

    private final By addToCartButton = By.xpath("(//*[@class=\"w-100\"]/button)[2]");
    private final By openCartButton = By.xpath("//a[contains(@href,\"/ru/cart\")]");
    private  final By addToFavouriteListButton = By.xpath("//div[contains(@class,\"d-flex flex-nowrap position-relative\")]/button");
    private  final By openFavouriteListButton = By.xpath("//a[contains(@class,\"favourite\")]");

    public ProductPage(WebDriver driver, Item testItem) {
        ProductPage.driver = driver;
        driver.get("https://new.faberlic.com/p/" + testItem.getId());
        signInElement = new SignInElement(driver);
    }

    public ProductPage addToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage openCart() {
        driver.findElement(openCartButton).click();
        return new CartPage(driver);
    }

    public ProductPage addToFavouriteList(){
        driver.findElement(addToFavouriteListButton).click();
        return this;
    }

    public FavouriteListPage openFavouriteList(){
        driver.findElement(openFavouriteListButton).click();
        return new FavouriteListPage(driver);
    }
}
