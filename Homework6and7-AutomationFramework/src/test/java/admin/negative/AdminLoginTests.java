package admin.negative;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;
import pages.AdminLoginPage;

public class AdminLoginTests {
    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void unsuccessfulAdminLogin(){
        AdminLoginPage.goTo();
        AdminLoginPage.login("blablabla", "parola123!");
        AdminLoginPage.verifyErrorValidationMessage("No match for Username and/or Password.","The expected validation error message is INCORRECT");
    }


}
