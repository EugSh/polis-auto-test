package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.core.left_column.LeftColumn;
import project.model.TestBot;

import static org.junit.Assert.assertTrue;

public class AddFriendTest extends TwoBotsBase {
    private final TestBot testBot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot testBot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private Header header1;

    @Before
    public void login() {
        final LoginPage loginPage1 = new LoginPage(driver1);
        loginPage1.doLogin(testBot1);
        final LoginPage loginPage2 = new LoginPage(driver2);
        loginPage2.doLogin(testBot2);
    }

//    @Test
    public void addFriend() {
        header1 = new Header(driver1);
        header1.doSearch("TechoBot15").addFriend();
        Header header2 = new Header(driver2);
        assertTrue(header2.checkNotifications().agree());

    }

    @After
    public void deleteFriend() {
        header1.delete().deleteFriend();
        LeftColumn leftColumn = new LeftColumn(driver2);
        leftColumn.checkSubscriptions().unsubscribe();
    }
}
