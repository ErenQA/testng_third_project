package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }


    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");
        if (driver == null) {
            switch (browser.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default :
                    throw new IllegalStateException();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver() {
        if(driver != null)
            driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

}