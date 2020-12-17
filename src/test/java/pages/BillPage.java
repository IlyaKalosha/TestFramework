package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rervice.TestDataReader;

public class BillPage {
    protected WebDriver driver;

    private final By moneyInput = By.id("amount");
    private final By inputButton = By.xpath("//*[@id=\"Fedit\"]/div[2]/table/tbody/tr/td/input");
    private final By username = By.xpath("//*[@id=\"formLoginAuth\"]/div/form[1]/div[1]/div[3]/input");
    private final By password = By.xpath("//*[@id=\"formLoginAuth\"]/div/form[1]/div[1]/div[4]/div[1]/div/input");
    private final By loginButton = By.xpath("//*[@id=\"formLoginAuth\"]/div/form[1]/div[1]/div[4]/input");

    public BillPage(WebDriver driver){
        this.driver = driver;
    }

    public BillPage openBillPage(){
        driver.get(TestDataReader.getPage("testdata.page.billpage"));
        return this;
    }
    public BillPage login(User testUser){
        driver.findElement(username).sendKeys(testUser.getUsername());
        driver.findElement(password).sendKeys(testUser.getPassword());
        driver.findElement(loginButton).click();
        return this;
    }
    public WebPayServicePage enterValue(User testUser){
        driver.findElement(moneyInput).sendKeys(testUser.getFaberlicMoney());
        driver.findElement(inputButton).click();
        return new WebPayServicePage(driver);
    }
}
