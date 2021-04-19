package user.logo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import utils.Browser;
import utils.CommonVerification;

public class CheckingIfLogoLinkDirectToHomePage {
    @BeforeMethod
    public void setUp(){
        Browser.open("chrome");
    }
    @Test
    public void testCheckingLogoOnDeskstopPage(){
        HeaderPage.goTo();
        HeaderPage.chooseOptionFromDesktopMenu("All");
        CommonVerification.verifyTitle("Desktops","Error:You are not on Desktops page!");
        HeaderPage.clickLogo();
        CommonVerification.verifyHomepage();
        //????
        //Логото e част от непроменящата се горна  част на страниците-т.е е в Header page, нали?
        //Въпросът ми е, веднъж като съм установила, че работи -както в този тест, че при натискането на логото от Desktop страницатата  пренасочва към homepage, това
        // означава ли, че и на всяка друга страница то ще работи, тъй като Header page e един и същ за всички страници.На мен ми се струва логично да е така.
        // Макар, че при тестване ръчно на сайт ми се е случвало например линк от Footer да не работи само на определена страница.
        // Т.е има ли някакъв тънък момент, с който реално да си спестиш време за тестване и автоматизация(както тук с логото).

        }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }

}
