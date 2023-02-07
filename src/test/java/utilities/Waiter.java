package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {


    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        }catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean waitFor_Until_URL(String title, int seconds) {
        return new WebDriverWait(Driver.getDriver(), seconds).until(ExpectedConditions.urlContains(title));
    }

}