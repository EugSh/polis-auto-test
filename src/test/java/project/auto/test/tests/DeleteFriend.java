package project.auto.test.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

public class DeleteFriend extends TwoBotsBase {
    private HomePage homePage1;
    private HomePage homePage2;
    private final TestBot bot1 = new TestBot("TechoBot7", "TechnoPolis19");
    private final TestBot bot2 = new TestBot("TechoBot15", "TechnoPolis19");

    @Before
    public void login() {
        homePage1 = new LoginPage(driver1)
                .doLogin(bot1);
        homePage2 = new LoginPage(driver2)
                .doLogin(bot2);
        homePage1.header()
                .clickLupa()
                .clickPeople()
                .search(bot2.getLogin())
                .getCardByName(bot2.getLogin())
                .clickProfile()
                .clickAddFriend();
        homePage2.header()
                .clickNotification()
                .clickFriendship()
                .getByName(bot1.getLogin())
                .accept();
        homePage1 = BasePage.goToHomePage(driver1);
        homePage2 = BasePage.goToHomePage(driver2);
    }

    @Test(expected = AssertionError.class)
    public void deleteFriend() {
        homePage1.header()
                .clickFriends()
                .getFriendList()
                .getByName(bot2.getLogin())
                .clickDeleteFriend();
        homePage2.header()
                .clickFriends()
                .clickSubscriber()
                .getByName(bot1.getLogin())
                .unsubscribe();

        BasePage.goToHomePage(driver1)
                .header()
                .clickFriends()
                .getFriendList()
                .getByName(bot2.getLogin());
    }
}
