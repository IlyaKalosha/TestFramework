package Pages;

import org.openqa.selenium.WebDriver;

public class MainPage {
    protected static WebDriver driver;
    public SignInElement signInElement;

    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
        signInElement = new SignInElement(driver);
    }
}
