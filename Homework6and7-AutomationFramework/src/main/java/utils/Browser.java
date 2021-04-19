package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Browser {

    public static WebDriver driver;

    /**
     * Method which opens a browser by passed browserType.
     * Valid options are: chrome, firefox, edge.
     * @param browserType the browser type which will be opened
     */
    public static void open(String browserType){
        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
                driver=new EdgeDriver();
                break;
             default:
                 throw new RuntimeException("The Browser that is chosen "+browserType+ " is not a valid Browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    /**
     * Method that close the browser.
     */
    public static void quit(){
        driver.quit();
    }
}
