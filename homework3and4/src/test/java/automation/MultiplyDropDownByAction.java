package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class MultiplyDropDownByAction {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // Chrome browser
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //  driver = new ChromeDriver();

        //Firefox browser
        //System.setProperty("webdriver.gecko.driver","C:\\webdrivers\\geckodriver.exe");
        //driver=new FirefoxDriver();

        //Edge browser
        System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
        driver = new EdgeDriver();

        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void MultiplyDropDown() throws InterruptedException {
        WebElement colorOptions = driver.findElement(By.name("color"));

        Select colors = new Select (colorOptions);

        Actions builder = new Actions(driver);

        WebElement redOption = driver.findElement(By.xpath("//select[@name='color']//option[@value='rd']"));
        WebElement silverOption = driver.findElement(By.xpath("//select[@name='color']//option[@value='sl']"));

        builder
                .click(redOption)
                .keyDown(Keys.CONTROL)
                .click(silverOption)
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(5000);

        List<String> exp_selection= Arrays.asList("Red","Silver");
        List<String> act_selection= new ArrayList<String>();

        for (WebElement color:colors.getAllSelectedOptions() ) {
            act_selection.add(color.getText());

        }

         assertEquals(act_selection,exp_selection);
    }


}


