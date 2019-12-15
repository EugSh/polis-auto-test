package project.tests;

import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Friends;
import project.core.header.Header;
import project.model.TestBot;

public class SendMessageTest extends TwoBotsBase {
    private final TestBot testBot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot testBot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private Header header1;
    private Friends friend2;

    @Before
    public void login() {
        final LoginPage loginPage1 = new LoginPage(driver1);
        loginPage1.doLogin(testBot1);
        final LoginPage loginPage2 = new LoginPage(driver2);
        loginPage2.doLogin(testBot2);
    }

    @Test
    public void sendAndReceiveMessage() {
        header1 = new Header(driver1);
        header1.doSearch(testBot2.getLogin()).goToProfile().sendMessage();
        friend2 = new Friends(driver2);
        friend2.readMessage();
    }
}
