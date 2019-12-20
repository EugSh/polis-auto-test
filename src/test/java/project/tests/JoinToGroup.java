package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.core.left_column.LeftColumn;
import project.model.TestBot;

import static junit.framework.TestCase.assertTrue;

public class JoinToGroup extends TestBase {
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private final String groupName = "Hi-Tech Mail";
    private LeftColumn leftColumn;

    @Before
    public void login(){
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(bot);
        leftColumn = new LeftColumn(driver);
    }

//    @Test
    public void joinToGroupAndCheckThanJoined(){
        leftColumn.groups().searchAndJoinToGroup(groupName);
        leftColumn.feed();
        assertTrue(leftColumn.groups().checkThatJoined(groupName));
    }

    @After
    public void resetGroup(){
        leftColumn.feed();
        leftColumn.groups().quitFromGroup(groupName);
    }
}
