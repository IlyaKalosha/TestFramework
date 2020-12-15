package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String ResourcesPath = "src/test/resources";

    private DriverSingleton(){}

    public static WebDriver getInstance() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
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
}