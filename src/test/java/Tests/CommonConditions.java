package Tests;

import Driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String UserName = "+375298092169";
    protected static final String UserPassword = "Yagdtazh135";


    @BeforeMethod
    public void setUp(){
        driver = DriverSingleton.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void resetBrowser(){
        DriverSingleton.deleteAllCookies();
    }

    @AfterTest()
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
