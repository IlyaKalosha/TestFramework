package pages;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavouriteListPage {
    protected static WebDriver driver;

    private final By deleteFromFavouriteListButton = By.xpath("//button[contains(@class,\"inactive\")]");

    public FavouriteListPage(WebDriver driver) {
        FavouriteListPage.driver = driver;
    }

    public boolean isThereElement(Item testItem) {
        List<WebElement> favouriteList = driver.findElements(By.xpath("//*[@class=\"name\"]"));
        if (!favouriteList.isEmpty())
            for (WebElement item:
                    favouriteList) {
                if(item.getText().contains(testItem.getName())){
                    return true;
                }
            }
        return false;
    }

    public void deleteAddedItem(){
        driver.findElement(deleteFromFavouriteListButton).click();
    }
}
