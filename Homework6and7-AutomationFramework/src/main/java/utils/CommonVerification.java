package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class CommonVerification {

    private static final By LOC_PRODUCTS = By.xpath("//div[@id='content']// div[@class=\"row\"]");
    private static final By LOC_PRICE_OF_PRODUCTS = By.cssSelector("p.price");
    private static final By LOC_ALL_PRICE_DESKTOP_PRODUCTS= By.xpath("//div[@class=\"row\"]//div[contains(@class,'product-layout')]//p[@class='price']");

    /**
     * Method which verifies the title of a page based on expected title and logs a message in case of assert failure.
     *
     * @param expectedTitle the expected title
     * @param errorMessage  error message in case assert fails
     */
    public static void verifyTitle(String expectedTitle, String errorMessage) {
        String actualTitle = Browser.driver.getTitle();
        assertEquals(actualTitle, expectedTitle, errorMessage);

    }

    /**
     * Method that verifies if an open page is a homepage.
     */
    public static void verifyHomepage() {
        String actualPageSource = Browser.driver.getPageSource();
        assertTrue(actualPageSource.contains("id=\"common-home\""));


    }

    /**
     * Method which verifies that the price of the products are in Euro.
     */
    public static void verifyEURCurrencyOfTheProducts() {
        List<WebElement> productsList = Browser.driver.findElements(LOC_PRODUCTS);
        for (WebElement product:productsList) {
            assertTrue(product.getText().contains("€"));
        }
    }
    ///???? Исках тази верификация да я направя с един метод, в който да включа switch(currency) и според валутата да имам трите вида verification,но не
    // можах да измисля как параметъра String currency ot HeaderPage.changingCurrencyTo метода да го използвам тук. Пробвах public String currency да го задам като поле
    //в HeaderPage, но това поле не е видимо от utils пакета, където ми е този клас на верификацията.
    //Как да направя поле в клас от един пакет така, че да е видим за друг пакет?

    /**
     * Method which verifies that the price of the products are in Pound Sterling(GBP).
     */
    public static void verifyGBPCurrencyOfTheProducts() {
        List<WebElement> productsList = Browser.driver.findElements(LOC_PRODUCTS);
        for (WebElement product:productsList) {
            assertTrue(product.getText().contains("£"));
        }
    }

    /**
     * Method which verifies that the price of the products are in US dollar(USD).
     */
    public static void verifyUSDCurrencyOfTheProducts() {
        List<WebElement> productsList = Browser.driver.findElements(LOC_PRODUCTS);
        for (WebElement product:productsList) {
            assertTrue(product.getText().contains("$"));
        }
    }

    /**
     * Method that verifies that the products are ordered by Low to High price.
     */
    public static void verifyProductOrderByLowToHighPrice() {

        List<WebElement> allPrices = Browser.driver.findElements(LOC_ALL_PRICE_DESKTOP_PRODUCTS);

        //???

        for (WebElement price:allPrices) {

            System.out.println(price.getText());


        }
    }
}
