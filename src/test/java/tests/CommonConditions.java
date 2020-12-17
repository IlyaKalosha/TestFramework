package tests;

import driver.DriverSingleton;
import pages.MainPage;
import util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = DriverSingleton.getInstance();
    }

    @BeforeMethod
    public void resetBrowser(){
        DriverSingleton.deleteAllCookies();
        MainPage mainPage = DriverSingleton.openMainPage();
    }

    @AfterTest()
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
