package project.auto.test.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class ChangeLanguageToEng extends TestBase {
    private static final String newLang = "English";
    private HomePage homePage;
    private String defaultLang;
    private TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");

    @Before
    public void login() {
        defaultLang = new LoginPage(driver)
                .doLogin(bot)
                .header()
                .clickDropDownToolBar()
                .clickSetting()
                .mainContent()
                .clickLanguage()
                .getCurrentLanguage();
        homePage = BasePage.goToHomePage(driver);
    }

    //@Test
    public void changeLanguage() {
        final String language = homePage.header()
                .clickDropDownToolBar()
                .clickSetting()
                .mainContent()
                .clickLanguage()
                .changeLanguageTo(newLang)
                .mainContent()
                .clickLanguage()
                .getCurrentLanguage();
        assertEquals(newLang, language);
    }

    @After
    public void setDefaultLang() {
        homePage = BasePage.goToHomePage(driver);
        homePage.header()
                .clickDropDownToolBar()
                .clickSetting()
                .mainContent()
                .clickLanguage()
                .changeLanguageTo(defaultLang);
    }
}
