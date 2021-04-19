package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

import static org.testng.AssertJUnit.assertTrue;

public class AdminLoginPage {
    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTTON = By.cssSelector("button.btn-primary");
    private static final By LOC_ERROR_MESSAGE = By.cssSelector("div.alert-danger.alert-dismissible");
    /**
     * Method which takes you to the admin login page.
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    /**
     * Method that logins a user by username and password.
     * @param username the name of the user.
     * @param password the password of the user.
     */
    public static void login(String username, String password) {

        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_LOGIN_BUTTON).click();

    }

    /**
     * Method which verifies the error validation message in admin login page.
     * @param expectedMessage expected error validation message
     * @param messageInCaseOfIncorrectValidationMessage message which will be logged in case the validation error message is not correct.
     */
    public static void verifyErrorValidationMessage(String expectedMessage, String messageInCaseOfIncorrectValidationMessage){
    String actualErrorValidationMessage=Browser.driver.findElement(LOC_ERROR_MESSAGE).getText();
        System.out.println(Browser.driver.findElement(LOC_ERROR_MESSAGE).getText());
      Assert.assertTrue(actualErrorValidationMessage.contains(expectedMessage), messageInCaseOfIncorrectValidationMessage);

    }
}
