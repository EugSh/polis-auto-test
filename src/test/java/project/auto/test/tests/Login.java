package project.auto.test.tests;

import org.junit.Test;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class Login extends TestBase{
    private TestBot bot = new TestBot("TechoBot7", "TechnoPolis19");

    @Test
    public void login() {
        final String nameSurname = new LoginPage(driver)
                .doLogin(bot)
                .header()
                .clickDropDownToolBar()
                .getName();
        assertEquals(bot.toString(), nameSurname);
    }
}
