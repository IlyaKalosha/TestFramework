package driver;

import pages.MainPage;
import rervice.TestDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getInstance() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

    public static MainPage openMainPage(){
        driver.get(TestDataReader.getPage("testdata.page.mainpage"));
        return new MainPage(driver);
    }
}
