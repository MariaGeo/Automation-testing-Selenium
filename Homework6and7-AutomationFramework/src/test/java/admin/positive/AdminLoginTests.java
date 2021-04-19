package admin.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import pages.AdminLoginPage;
import utils.Browser;
import utils.CommonVerification;

public class AdminLoginTests {
    @BeforeMethod
    public void setUp(){
        Browser.open("edge");

    }
    @Test
    public void successfulAdminLoginTest(){
        AdminLoginPage.goTo();
        AdminLoginPage.login("admin", "parola123!");
        CommonVerification.verifyTitle("Dashboard","Error:The log wasn't successful");
        AdminDashboardPage.logout();
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }

}
