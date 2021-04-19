package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class OrderDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Chrome browser
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //  driver = new ChromeDriver();

        //Firefox browser
        //System.setProperty("webdriver.gecko.driver","C:\\webdrivers\\geckodriver.exe");
        //driver=new FirefoxDriver();

        //Edge browser
        System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://shop.pragmatic.bg/admin");
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.xpath("//div[@id='content']//button[@class='btn btn-primary']"));
        login.click();

    }

    @AfterMethod
    public void closeTheBrowser() {
        driver.quit();
    }

    @Test
    public void CheckingOrderDropDown() throws InterruptedException {
        WebElement sale = driver.findElement(By.id("menu-sale"));
        sale.click();
        Thread.sleep(5000);

        WebElement order = driver.findElement(By.xpath("//ul[@id='collapse4']//a[contains(@href,'order')]"));
        order.click();
        Thread.sleep(5000);

        WebElement dropdown = driver.findElement(By.id("input-order-status"));

        Select orderStatus= new Select(dropdown);

        assertFalse(orderStatus.isMultiple());

        assertEquals(orderStatus.getOptions().size(), 16);

        List<String> exp_status = Arrays.asList("","Missing Orders","Canceled","Canceled Reversal","Chargeback","Complete","Denied","Expired","Failed","Pending","Processed","Processing","Refunded","Reversed","Shipped","Voided");
        List<String> act_status = new ArrayList<String>();

        List<WebElement> allStatus=orderStatus.getOptions();
        for (WebElement status:allStatus) {
            act_status.add(status.getText());
        }
        assertEquals(act_status,exp_status);

        WebElement logout  = driver.findElement(By.xpath("//span[@class=\"hidden-xs hidden-sm hidden-md\"]"));
        logout.click();

    }
}
