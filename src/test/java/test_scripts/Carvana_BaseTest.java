package test_scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.Waiter;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Carvana_BaseTest extends Carvana_Base {

    @Test(priority = 1, description = "Validate Home Page title and URL")
    public void validate_PageTitle_URL() {

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validate_logo() {

        Assert.assertTrue(carvana_basePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validation for Navigation Section Items")
    public void validate_NavigateSectionItems() {

        IntStream.range(0, carvana_basePage.navigationItems.size()).forEach(i ->
                Assert.assertTrue(carvana_basePage.navigationItems.get(i).isDisplayed()));
    }

    @Test(priority = 4, description = "Validation the Sign In Error Message")
    public void validate_SignIn_ErrorMessage() {

        carvana_basePage.signIn_ErrorMessage();
        Assert.assertEquals(carvana_basePage.errorMessage.getText(),
                "Email address and/or password combination is incorrect.");
    }

    @Test(priority = 5, description = "Validation for the Search Filter Options and Search Button")
    public void validate_FilterOptions() {

        carvana_searchCarPage.routeToCars();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.carvana.com/cars");

        IntStream.range(0, carvana_searchCarPage.filterOptions.size()).forEach(i ->
                Assert.assertTrue(carvana_searchCarPage.filterOptions.get(i).isDisplayed()));
    }

    @Test(priority = 6, description = "Validation for the Search Result Tiles")
    public void validate_SearchResult_Tiles() {

        carvana_searchCarPage.routeToCars();
        carvana_searchCarPage.searchBarInputBox.sendKeys("mercedes-benz");
        carvana_searchCarPage.go_Button.click();

        Assert.assertTrue(Waiter.waitFor_Until_URL("mercedes-benz", 60));
        Actions action = new Actions(Driver.getDriver());

        while (carvana_searchCarPage.nextButton.isEnabled()) {

            IntStream.range(0, carvana_searchCarPage.resultTiles.size()).forEach(i -> {
                Assert.assertTrue(carvana_searchCarPage.resultTiles.get(i).isDisplayed());
                Assert.assertTrue(carvana_searchCarPage.images_ResultTile.get(i).isDisplayed());
                Assert.assertTrue(carvana_searchCarPage.add_FavouriteButton_ResultTile.get(i).isDisplayed());
                Assert.assertTrue(carvana_searchCarPage.tileBody.get(i).isDisplayed());
                Assert.assertNotNull(carvana_searchCarPage.inventory_Type_Tiles.get(i).getText());
                Assert.assertTrue(carvana_searchCarPage.trimAndMileage.get(i).isDisplayed());
                Assert.assertNotNull(carvana_searchCarPage.trimAndMileage.get(i).getText());

                Assert.assertTrue(Integer.parseInt(carvana_searchCarPage.priceOfTiles.get(i).getText().replaceAll("[^0-9]", ""))
                        > 0);

                Assert.assertTrue(carvana_searchCarPage.monthly_Down_Payments.get(i).isDisplayed());
                Assert.assertNotNull(carvana_searchCarPage.monthly_Down_Payments.get(i).getText());
                Assert.assertTrue(carvana_searchCarPage.deliveryChip.get(i).isDisplayed());
                Assert.assertNotNull(carvana_searchCarPage.deliveryChip.get(i).getText());


            });
            action.moveToElement(carvana_searchCarPage.nextButton).click().perform();

            try {
                carvana_searchCarPage.closeButton.click();
            }catch(Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
