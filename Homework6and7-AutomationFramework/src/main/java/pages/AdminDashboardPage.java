package pages;

import org.openqa.selenium.By;
import utils.Browser;


public class AdminDashboardPage {
    private static final By LOC_LOGOUT_BUTTON= By.cssSelector("i.fa-sign-out");
    /**
     * This method logout the admin user.
     */
    public static void logout(){
        Browser.driver.findElement(LOC_LOGOUT_BUTTON).click();
    }

}
