package Pages;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavouriteListPage {
    protected static WebDriver driver;

    private final By deleteFromFavouriteListButton = By.xpath("//button[contains(@class,\"inactive\")]");

    public FavouriteListPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isThereElement(Item testItem) {
        List<WebElement> cartList = driver.findElements(By.cssSelector("[data-product=\""+testItem.getId()+"\"]"));
        if (cartList.size() > 0)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    public void deleteAddedItem(){
        driver.findElement(deleteFromFavouriteListButton).click();
    }
}
