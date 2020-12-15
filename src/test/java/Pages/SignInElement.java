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

    public void loginUser(User user) {
        driver.findElement(authLink).click();
        driver.findElement(loginInput).sendKeys(user.getUsername());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(enterButton).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.id("auth-modal")));
    }

    public void logOutUser() {
        driver.findElement(signOutButton).click();
    }

    public Boolean isLoggedIn(String userSurname) {
        if (driver.findElement(By.xpath("//a[contains(text(),\""+userSurname+"\")]"))!=null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
}
