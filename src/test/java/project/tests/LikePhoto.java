package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Friends;
import project.core.header.Header;
import project.core.middle_column.MiddleColumn;
import project.model.TestBot;

import static org.junit.Assert.assertTrue;

public class LikePhoto extends TwoBotsBase {
    private final TestBot bot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot bot2 = new TestBot("TechoBot15", "TechnoPolis19");
    private Header header1;
    private Friends friends1;
    private Header header2;

    @Before
    public void login() {
        final LoginPage loginPage1 = new LoginPage(driver1);
        loginPage1.doLogin(bot1);
        final LoginPage loginPage2 = new LoginPage(driver2);
        loginPage2.doLogin(bot2);
        header1 = new Header(driver1);
        header2 = new Header(driver2);
        friends1 = header1.doSearch(bot2.getLogin()).goToProfile();
    }

//    @Test
    public void klassPhotoAndCheckEvent() {
        friends1.klassPhoto();
        assertTrue(header2.checkEvent().isSetKlass());
    }

    @After
    public void resetKlass() {
        friends1.klassPhoto();
    }
}
