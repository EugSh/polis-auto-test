package project.auto.test.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import project.auto.test.core.homePage.HPMiddleContent;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertEquals;

public class PostFeeling extends TestBase {
    private static final int messageLength = 32;
    private static final String message = RandomStringUtils.randomAlphabetic(messageLength);
    private static final String aliasFeeling = "dreamy";
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");


//    @Test
    public void postFeeling() {
        String actualMessage = new LoginPage(driver)
                .doLogin(bot)
                .middleColumnContent()
                .clickFeeling()
                .clickOnCardByAlias(aliasFeeling)
                .enterText(message)
                .clickPost()
                .middleColumnContent()
                .getFeelingMessage();
        assertEquals(message, actualMessage);
    }

}
