package Pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInElement {
    protected static WebDriver driver;

    private final By authLink = By.id("auth-link");
    private final By signOutButton = By.xpath("//a[contains(text(),\"Выход\")]");
    private final By loginInput = By.id("j_username");
    private final By passwordInput = By.id("j_password");
    private final By enterButton = By.xpath("//button[contains(@class,\"auth\")]");

    public SignInElement(WebDriver driver) {
        SignInElement.driver = driver;
    }

    public MainPage loginUser(User testUser) {
        driver.findElement(authLink).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-modal")));
        driver.findElement(loginInput).sendKeys(testUser.getUsername());
        driver.findElement(passwordInput).sendKeys(testUser.getPassword());
        driver.findElement(enterButton).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.id("auth-modal")));
        return new MainPage(driver);
    }

    public void logOutUser() {
        driver.findElement(signOutButton).click();
    }

    public Boolean isTestUserLoggedIn(User testUser) {
        if (driver.findElement(By.xpath("//a[contains(text(),\""+testUser.getSurname()+"\")]"))!=null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    public Boolean isAnyUserLoggedIn() {
        if (driver.findElement(signOutButton)!=null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
}
