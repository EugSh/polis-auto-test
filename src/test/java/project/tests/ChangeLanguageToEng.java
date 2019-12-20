package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.LoginPage;
import project.core.header.Header;
import project.model.TestBot;

import static junit.framework.TestCase.assertEquals;

public class ChangeLanguageToEng extends TestBase {
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private String currentLanguage;
    private String changeTo = "English";
    private Header header;

    @Before
    public void login(){
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(bot);
        header = new Header(driver);
        currentLanguage = header.clickToolBarDropDown().currentLanguage();
        header.refresh();
    }

    @Test
    public void changeToEng(){
        header.clickToolBarDropDown().changeLanguage(changeTo);
        assertEquals(changeTo, header.clickToolBarDropDown().currentLanguage());
    }

    @After
    public void resetLanguage(){
        header.clickToolBarDropDown().changeLanguage(currentLanguage);
    }
}
