package project.tests;

import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.model.TestBot;

import static org.junit.Assert.assertTrue;

public class GuestTest extends TwoBotsBase {
    private final TestBot testBot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot testBot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private Header header1;
    private Header header2;

    @Before
    public void login() {
        final LoginPage loginPage1 = new LoginPage(driver1);
        loginPage1.doLogin(testBot1);
        final LoginPage loginPage2 = new LoginPage(driver2);
        loginPage2.doLogin(testBot2);
    }

//    @Test
    public void watchProfile() throws InterruptedException {
        header1 = new Header(driver1);
        header1.doSearch(testBot2.getLogin()).goToProfile();
        Thread.sleep(1000);
        header2 = new Header(driver2);
        assertTrue(header2.checkGuests());
        Thread.sleep(2000);
    }
}
