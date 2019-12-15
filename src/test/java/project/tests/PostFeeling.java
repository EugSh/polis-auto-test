package project.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.core.BasePage;
import project.core.LoginPage;
import project.core.middle_column.MiddleColumn;
import project.model.TestBot;

import static org.junit.Assert.assertEquals;

public class PostFeeling extends TestBase {
    private final TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
    private MiddleColumn middleColumn;
    private final String feelingMessage = "I'm so happy!";
    private final String feelingAlias = "sad";

    @Before
    public void login(){
        final LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(bot);
        middleColumn = new MiddleColumn(driver);
    }

    @Test
    public void postFeelingAndCheckIt(){
        middleColumn.postFeeling().chooseFeelingAndPost(feelingAlias, feelingMessage);
        middleColumn.refresh();
        assertEquals(feelingMessage, middleColumn.getFeelingPostText());
    }
}