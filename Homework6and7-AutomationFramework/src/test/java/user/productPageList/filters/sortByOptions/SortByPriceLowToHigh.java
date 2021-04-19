package user.productPageList.filters.sortByOptions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.HeaderPage;
import pages.Homepage;
import utils.Browser;
import utils.CommonVerification;

public class SortByPriceLowToHigh {
    @BeforeMethod
    public void SetUp(){
        Browser.open("chrome");

    }
    @Test
    public void sortByPriceLowToHighOnDesktopPage() throws InterruptedException {
        Homepage.goTo();
        HeaderPage.chooseOptionFromDesktopMenu("All");
        CommonVerification.verifyTitle("Desktops","Error:You are not on Desktops page!");
        ProductPage.sortByPrice("Low to High");
        CommonVerification.verifyProductOrderByLowToHighPrice();

    }
}
