package pages;

import utils.Browser;

public class Homepage {
    /**
     * Method that takes you to the user homepage.
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/");
    }
}
