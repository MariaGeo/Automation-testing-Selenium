package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;
import org.testng.Assert;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class ProductPage {


    private static final By LOC_SORT_BY_DROPDOWN = By.xpath("//select[@id=\"input-sort\"]");
            //By.id("id=\"input-sort\"");


    /**
     * Method that orders the products based on the price.
     * valid order are: Low to High, High to Low
     * @param order the order that the products appear
     *
     */
    public static void sortByPrice(String order) {
        //Thread.sleep(5000);
        Select dropDownSetBy= new Select(Browser.driver.findElement(LOC_SORT_BY_DROPDOWN));
        assertFalse(dropDownSetBy.isMultiple());

        switch(order){
            case "Low to High":
                dropDownSetBy.selectByVisibleText("Price (Low > High)");
                break;
            case "High to Low":
                dropDownSetBy.selectByVisibleText("Price (High > Low)");
                break;
            default:
                throw new RuntimeException("The order based on Price " + order + "is not valid option");
        }

    }
}
