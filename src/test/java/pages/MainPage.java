package pages;

import PageElements.SignInElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected static WebDriver driver;
    public SignInElement signInElement;

    private final By searchButton = By.xpath("//a[contains(@class,\"search\")]");
    private final By searchWindow = By.xpath("//div[contains(@class,\"js-searchbox\")]");
    private final By searchField = By.xpath("//input[contains(@class,\"search-group\")]");
    private final By searchEnterButton = By.xpath("//button[contains(text(),\"Найти\")]");
    private final By language = By.xpath("//span[contains(@class,\"header__geo-item mr-lg-2 icn-internet text-uppercase box-link js-header-lang\")]");

    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
        signInElement = new SignInElement(driver);
    }

    public ListOfProductsPage search(String searchStatement){
        driver.findElement(searchButton).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(searchWindow));

        driver.findElement(searchField).sendKeys(searchStatement);
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchEnterButton));
        driver.findElement(searchEnterButton).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(searchWindow));

        return new ListOfProductsPage(driver);
    }

    public MainPage changeLang(){
        driver.findElement(language).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("lang-popover")));

        driver.findElement(By.xpath("//*[contains(@data-iso,\"en\")]")).click();
        return this;
    }

    public String getMenuLang(){
        return driver.findElement(By.id("auth-link")).getText();
    }


}
