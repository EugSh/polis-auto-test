package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.core.middle_column.MiddleColumn;
import project.model.TestBot;

import static org.junit.Assert.assertEquals;

public class ChangeName extends TestBase {
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private Header header;
    private String changeName = "15TechoBot";
    private String newFirstLastName = changeName + " " + bot.getLogin();

    @Before
    public void login() {
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(bot);
        header = new Header(driver);
    }

    @Test
    public void changeNameAndCheck() {
        header.clickToolBarDropDown().clickSettingAndChangeName(changeName);
        assertEquals(newFirstLastName, header.clickToolBarDropDown().clickFirstLastName());
    }

    @After
    public void resetName() {
        header.clickToolBarDropDown().clickSettingAndChangeName(bot.getLogin());
    }
}