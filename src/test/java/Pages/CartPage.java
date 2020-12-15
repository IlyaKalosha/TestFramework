package Pages;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    protected static WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isThereElement(Item testItem) {
        List<WebElement> cartList = driver.findElements(By.xpath("//a[contains(@href,\"" + testItem.getId() + "\")]"));
        if (cartList.size() > 1)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;


    }
}
