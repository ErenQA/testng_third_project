package test_scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Carvana_BasePage;
import pages.Carvana_SearchCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Carvana_Base {

    WebDriver driver;
    Carvana_BasePage carvana_basePage;
    Carvana_SearchCarPage carvana_searchCarPage;

    @BeforeMethod
    public void setup() {

        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        carvana_basePage = new Carvana_BasePage();
        carvana_searchCarPage = new Carvana_SearchCarPage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}