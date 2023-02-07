package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class Carvana_BasePage {

    public Carvana_BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class*='14r2405']")
    public WebElement logo;

    @FindBy(css = "div[class$='ggtgcl']")
    public List<WebElement> navigationItems;

    @FindBy(css = "div[class^='SignInLink']>a")
    public WebElement signIn;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "div[class$='7-XzW'] p")
    public WebElement errorMessage;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    public void signIn_ErrorMessage() {
        signIn.click();
        emailInputBox.sendKeys("johndoe@gmail.com");
        continueButton.click();
        passwordInput.sendKeys("abcd1234");
        signInButton.click();
    }


}