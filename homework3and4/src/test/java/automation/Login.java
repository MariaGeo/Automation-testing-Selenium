package automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class Login {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Chrome browser
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
       //  driver = new ChromeDriver();

        //Firefox browser
        //System.setProperty("webdriver.gecko.driver","C:\\webdrivers\\geckodriver.exe");
       // driver=new FirefoxDriver();

        //Edge browser
        System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
         driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @AfterMethod
    public void closeTheBrowser() {
      driver.quit();
    }

    @Test
    public void validCredentials() throws InterruptedException {
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.xpath("//div[@id='content']//button[@class='btn btn-primary']"));
        login.click();
        WebElement logout  = driver.findElement(By.xpath("//span[@class=\"hidden-xs hidden-sm hidden-md\"]"));
        logout.click();
        Thread.sleep(5000);
    }
    @Test
    public void invalidCredentials () throws InterruptedException {
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("noadmin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123");
        WebElement login = driver.findElement(By.xpath("//div[@id='content']//button[@class='btn btn-primary']"));
        login.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='content']//div[@class='alert alert-danger alert-dismissible']"));
        String actualErrorMessage = errorMessage.getText();
         // String expectErrorMessage= " No match for Username and/or Password.\n" +
         //       "              ";
        String expectErrorMessage= "Invalid token session. Please login again.\n" +
                "×";
        Assert.assertEquals(actualErrorMessage,expectErrorMessage,"The error messages are not identical");
        Thread.sleep(5000);
    }
}