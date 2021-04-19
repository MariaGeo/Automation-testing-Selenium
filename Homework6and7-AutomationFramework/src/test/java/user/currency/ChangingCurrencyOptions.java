package user.currency;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.Homepage;
import utils.Browser;
import utils.CommonVerification;

public class ChangingCurrencyOptions {
    @BeforeMethod
    public void setUp(){
        Browser.open("chrome");
        Homepage.goTo();

    }
    @Test
    public void testChangingCurrencyToEuro(){
        HeaderPage.changingCurrencyTo("Euro");
        CommonVerification.verifyEURCurrencyOfTheProducts();
    }
    @Test
    public void testChangingCurrencyToGBP(){
        HeaderPage.changingCurrencyTo("Pound Sterling");
        CommonVerification.verifyGBPCurrencyOfTheProducts();
    }
    @Test
    public void testChangingCurrencyToUSD(){
        HeaderPage.changingCurrencyTo("US dollar");
        CommonVerification.verifyUSDCurrencyOfTheProducts();
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }


}
