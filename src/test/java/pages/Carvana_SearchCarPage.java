package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;
import java.util.stream.IntStream;

public class Carvana_SearchCarPage extends Carvana_BasePage{

    public Carvana_SearchCarPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "a[data-cv-test*='headerSearchLink']")
    public WebElement searchCarsLink;

    @FindBy(id = "header-facets-wrapper")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-test='SearchBarInput']")
    public WebElement searchBarInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement go_Button;

    @FindBy(css = "div[class=‘result-tile]")
    public List<WebElement> resultTiles;

    @FindBy(css = "div[class='result-tile'] img")
    public List<WebElement> images_ResultTile;

    @FindBy(css = "div[class='result-tile'] svg")
    public List<WebElement> add_FavouriteButton_ResultTile;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "carvana-certified")
    public List<WebElement> inventory_Type_Tiles;

    @FindBy(css = "div[class='make-model']")
    public List<WebElement> yearModelInfo_Tiles;

    @FindBy(css = "div[class='trim-mileage']")
    public List<WebElement> trimAndMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> priceOfTiles;

    @FindBy(css = "div[data-qa='base-terms']")
    public List<WebElement> monthly_Down_Payments;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> deliveryChip;

    @FindBy(css = "button[data-cv-test$='NextPageButton']")
    public WebElement nextButton;

    @FindBy(css = "svg[class$='llqIcd']")
    public WebElement closeButton;


    public void routeToCars() {
        searchCarsLink.click();
    }
}