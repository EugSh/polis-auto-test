package project.auto.test.tests;

import org.junit.Before;
import org.junit.Test;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class NewGuest extends TwoBotsBase{
    private HomePage homePage1;
    private HomePage homePage2;
    private final TestBot bot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot bot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private final String fullnameBot1 = "TechoBot7 TechoBot7";

    @Before
    public void login() {
        homePage1 = new LoginPage(driver1)
                .doLogin(bot1);
        homePage2 = new LoginPage(driver2)
                .doLogin(bot2);
    }

    @Test
    public void newGuest() {
        homePage1.header()
                .clickLupa()
                .clickPeople()
                .search(bot2.getLogin())
                .getCardByName(bot2.getLogin())
                .clickProfile();
        String currentGuest = homePage2.header()
                .clickGuest()
                .getGuestList()
                .getByName(fullnameBot1)
                .getGuestName();
        assertEquals(currentGuest, fullnameBot1);
    }
}
