package project.auto.test.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JoinToGroup extends TestBase {
    private HomePage homePage;
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private static final String groupName = "Hi-Tech";
    private static final String joinStatus = "Вы подписаны!";

    @Before
    public void login() {
        homePage = new LoginPage(driver)
                .doLogin(bot);
    }

    @Test
    public void joinToGroup() {
        final String status = homePage.header()
                .clickLupa()
                .clickGroup()
                .search(groupName)
                .getCardByName(groupName)
                .join()
                .getJoinStatus();
        assertEquals(joinStatus, status);
    }

    @After
    public void quitFromGroup() {
        BasePage.goToHomePage(driver)
                .leftColumnContent()
                .clickGroups()
                .myGroups()
                .getByName(groupName)
                .clickGroupProfile()
                .clickParticipant()
                .clickLeaveGroup();
    }
}
