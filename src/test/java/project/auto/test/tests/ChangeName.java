package project.auto.test.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class ChangeName extends TestBase {
    private static final String newName = "NeBot";
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private static final String defaultName = "TechoBot15";
    private HomePage homePage;

    @Before
    public void login() {
        homePage = new LoginPage(driver)
                .doLogin(bot);
    }

    @Test
    public void changeName() {
        final String name = homePage.header()
                .clickDropDownToolBar()
                .clickSetting()
                .mainContent()
                .clickPersonalInfo()
                .changeNameTo(newName)
                .saveChanges()
                .header()
                .clickDropDownToolBar()
                .getName();
        assertEquals(newName + " " + bot.getLogin(), name);
    }

    @After
    public void setDefaultName() {
        BasePage.goToHomePage(driver)
                .header()
                .clickDropDownToolBar()
                .clickSetting()
                .mainContent()
                .clickPersonalInfo()
                .changeNameTo(defaultName)
                .saveChanges();
    }
}
