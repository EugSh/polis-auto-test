package project.auto.test.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class SendReadMessage extends  TwoBotsBase {
    private HomePage homePage1;
    private HomePage homePage2;
    private final TestBot bot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot bot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private final String text = "Hello! What are you doing?";

    @Before
    public void login() {
        homePage1 = new LoginPage(driver1)
                .doLogin(bot1);
        homePage2 = new LoginPage(driver2)
                .doLogin(bot2);
    }

    @Test
    public void sendReadMessage() {
        homePage1.header()
                .clickLupa()
                .clickPeople()
                .search(bot2.getLogin())
                .getCardByName(bot2.getLogin())
                .clickProfile()
                .clickWriteMessage()
                .clickByName(bot2.getLogin())
                .textMSG(text)
                .clickSend();
        String currentLastMSG = homePage2.header()
                .clickMessage()
                .clickByName(bot1.getLogin())
                .getLastMessage();
        assertEquals(currentLastMSG, text);
    }
}
