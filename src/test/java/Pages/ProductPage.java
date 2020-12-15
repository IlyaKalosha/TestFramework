package Pages;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    protected static WebDriver driver;
    protected SignInElement signInElement;

    private final By addToCartButton = By.xpath("(//*[@class=\"w-100\"]/button)[2]");//*[@class="w-100"]/button
    private final By openCartButton = By.xpath("//a[contains(@href,\"/ru/cart\")]");
    public ProductPage(WebDriver driver, Item testItem) {
        ProductPage.driver = driver;
        driver.get("https://new.faberlic.com/p/" + testItem.getId());
        signInElement = new SignInElement(driver);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public CartPage openCart() {
        driver.findElement(openCartButton).click();
        return new CartPage(driver);
    }
}
