package pages;

import model.Item;
import model.SearchStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ListOfProductsPage {
    protected static WebDriver driver;

    public ListOfProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public ListOfProductsPage openListOfProdpage(String link){
        driver.get(link);
        return this;
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

    public void promotionFilterOn(){
        driver.findElement(By.xpath("//*[@id=\"facet-options\"]/div[2]/div[2]/div[3]/div/label")).click();
    }

    public boolean isAllItemsHavePromotion(){
        List<WebElement> items = driver.findElements(By.xpath("//a[@class=\"prod-card__title fs-14 js-product-link\"]"));
        List<WebElement> itemsWithPromotion = driver.findElements(By.xpath("//a[@class=\"prod-link__text prod-link__text--link js-product-shield-promotion js-product-promo-shield\"]"));
        if(items.size()==itemsWithPromotion.size())
            return false;
        else
            return true;
    }
}
