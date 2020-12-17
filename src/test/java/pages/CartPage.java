package pages;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    protected static WebDriver driver;

    public CartPage(WebDriver driver) {
        CartPage.driver = driver;
    }

    public boolean isThereElement(Item testItem) {
        List<WebElement> cartList = driver.findElements(By.xpath("//*[@class=\"name\"]"));
        if (!cartList.isEmpty())
            for (WebElement item:
                 cartList) {
                if(item.getText().contains(testItem.getName())){
                    return true;
                }
            }
        return false;
    }

    public String getCurrentCost(){
        List<WebElement> cartList = driver.findElements(By.xpath("//*[@class=\"price__item price__current current\"]/span"));
        if (!cartList.isEmpty())
           return cartList.get(0).getText();
        return null;
    }
}
