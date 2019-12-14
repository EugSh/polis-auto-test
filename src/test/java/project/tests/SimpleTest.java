package project.tests;

import org.junit.Test;

import project.core.LoginPage;
import project.core.header.Header;
import project.core.left_column.LeftColumn;
import project.model.TestBot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleTest extends TestBase {

    @Test
    public void simpleTest() {
        LoginPage loginPage = new LoginPage(driver);
        TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
        loginPage.doLogin(bot);
        LeftColumn leftColumn = new LeftColumn(driver);
        Header header = new Header(driver);
        leftColumn.groups().searchAndJoinToGroup("Hi-Tech Mail");
//        leftColumn.refresh();
        header.feed();
        assertTrue(leftColumn.groups().checkThatJoined("Hi-Tech Mail"));
//        leftColumn.groups().quitFromGroup("Hi-Tech Mail");
//        Header header = new Header(driver);
//        MiddleColumn middleColumn = new MiddleColumn(driver);
//        middleColumn.postFeeling().chooseFeelingAndPost("dreamy", "123");
//        middleColumn.refresh();
//        assertEquals(middleColumn.getFeelingPostText(), "123");
//        header.clickToolBarDropDown().changeLanguage("English");
//        header.clickToolBarDropDown().changeLanguage("Русский");
//        header.clickToolBarDropDown().changeLanguage(new String("Русский".getBytes(), StandardCharsets.UTF_8));
//        driver.close();
    }
}
