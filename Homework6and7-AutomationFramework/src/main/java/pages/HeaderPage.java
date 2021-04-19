package pages;

import org.openqa.selenium.By;
import org.w3c.dom.html.HTMLInputElement;
import utils.Browser;

public class HeaderPage {

    private static final By LOC_DESKTOP_MENU_OPTIONS = By.xpath("//li[@class=\"dropdown\"]//a[text()=\"Desktops\"]");
    private static final By LOC_PC_DESKTOP_OPTION = By.xpath("//li[@class=\"dropdown open\"]//following-sibling::div[@class=\"dropdown-menu\"] //a[contains(text(),'PC')]");
    private static final By LOC_MAC_DESKTOP_OPTION = By.xpath("//li[@class=\"dropdown open\"]//following-sibling::div[@class=\"dropdown-menu\"] //a[contains(text(),'Mac')]");
    private static final By LOC_ALL_DESKTOP_OPTION = By.xpath("//li[@class=\"dropdown open\"]//following-sibling::div[@class=\"dropdown-menu\"] //a[contains(text(),'Show All Desktops')]");
    private static final By LOC_LOGO_LINK = By.id("logo");
    private static final By LOC_CURRENCY = By.id("form-currency");
    private static final By LOC_EURO_CURRENCY_OPTION = By.xpath("//button[@name=\"EUR\"]");
    private static final By LOC_GBP_CURRENCY_OPTION = By.xpath("//button[@name=\"GBP\"]");
    private static final By LOC_USD_CURRENCY_OPTION = By.xpath("//button[@name=\"USD\"]");

    /**
     * Method that takes you to the user homepage.
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/");
    }

    /**
     * Method that choose option from Desktop Menu.
     * valid options are: "PC", "Mac", "All"
     *
     * @param option - option in Desktop Menu
     */
    public static void chooseOptionFromDesktopMenu(String option) {
        Browser.driver.findElement(LOC_DESKTOP_MENU_OPTIONS).click();
        switch (option) {
            case "PC":
                Browser.driver.findElement(LOC_PC_DESKTOP_OPTION).click();
                break;
            case "Mac":
                Browser.driver.findElement(LOC_MAC_DESKTOP_OPTION).click();
                break;
            case "All":
                Browser.driver.findElement(LOC_ALL_DESKTOP_OPTION).click();
                break;
            default:
                throw new RuntimeException("Error: The option " + option + " is not correct!");

        }

    }

    /**
     * Method that clicks on logo link and should redirect the user to the homepage
     */
    public static void clickLogo() {
        Browser.driver.findElement(LOC_LOGO_LINK).click();
    }

    /**
     * This method changes  the price of the products based on the chosen currency.
     * Valid currency options are : Euro, Pound Sterling, US Dollar
     * @param currency currency in which to be shown the price of the products
     */
    public static void changingCurrencyTo(String currency) {
        Browser.driver.findElement(LOC_CURRENCY).click();
        switch (currency) {
            case "Euro":
                Browser.driver.findElement(LOC_EURO_CURRENCY_OPTION).click();
                break;
            case "Pound Sterling":
                Browser.driver.findElement(LOC_GBP_CURRENCY_OPTION).click();
                break;
            case "US dollar":
                Browser.driver.findElement(LOC_USD_CURRENCY_OPTION).click();
                break;
            default:
                throw new RuntimeException("The currency " + currency + "is not available on the site");
        }


    }
}


