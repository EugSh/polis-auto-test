package project.tests;

import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.model.TestBot;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {
    private final TestBot testBot = new TestBot("TechoBot7", "TechnoPolis19");

//    @Test
    public void loginCheckAndLogout() {
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(testBot);
        final Header header = new Header(driver);
        assertEquals(header.clickToolBarDropDown().clickFirstLastName(), testBot.toString());
        header.clickToolBarDropDown().exit();
        loginPage.isLoginPage();
    }
}
