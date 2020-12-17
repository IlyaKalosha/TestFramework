package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPayServicePage {
    protected WebDriver driver;

    private final By numberInput = By.id("cc_pan");
    private final By cvvInput = By.id("cc_cvv");
    private final By monthInput = By.id("cc_month");
    private final By yearInput = By.id("cc_year");
    private final By nameInput = By.id("cc_name");
    private final By emailInput = By.id("cc_email");
    private final By payButton = By.id("payBtn");
    private final By errorCode = By.id("rc");

    public WebPayServicePage(WebDriver driver){
        this.driver = driver;
    }

    public String pay(User testUser){
        driver.findElement(numberInput).sendKeys(testUser.card.getNumber());
        driver.findElement(cvvInput).sendKeys(testUser.card.getCvv());
        driver.findElement(monthInput).sendKeys(testUser.card.getMonth());
        driver.findElement(yearInput).sendKeys(testUser.card.getYear());
        driver.findElement(nameInput).sendKeys(testUser.card.getName());
        driver.findElement(emailInput).sendKeys(testUser.getEmail());

        driver.findElement(payButton).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("errorPage")));

        return driver.findElement(errorCode).getText();
    }
}
