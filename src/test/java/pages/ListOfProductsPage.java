package pages;

import model.Item;
import model.SearchStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListOfProductsPage {
    protected static WebDriver driver;

    public ListOfProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean getSearchResults(SearchStatement searchStatement) {
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//a[@class=\"prod-card__title fs-14 js-product-link\"]"));
        if (!listOfProducts.isEmpty())
            for (WebElement item:
                    listOfProducts) {
                if(item.getText().contains(searchStatement.getStatement())){
                    return true;
                }
            }
        return false;
    }
}
