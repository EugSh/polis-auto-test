package project.tests;

import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.core.LoginPage;
import project.core.header.Friends;
import project.core.header.Header;
import project.core.left_column.LeftColumn;
import project.model.TestBot;

import static org.junit.Assert.*;

public class SimpleTest extends TestBase {

    @Test
    public void simpleTest() {
        LoginPage loginPage = new LoginPage(driver);
        TestBot bot = new TestBot("TechoBot7", "TechnoPolis19");
        TestBot bot2 = new TestBot("TechoBot15", "TechnoPolis19");
        loginPage.doLogin(bot);
        Header header = new Header(driver);
        Friends fr2 = header.doSearch(bot2.getLogin()).goToProfile();
        fr2.klassPhoto();
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://ok.ru");
        LoginPage loginPage1 = new LoginPage(driver2);
        loginPage1.doLogin(bot2);
        Header header1 = new Header(driver2);
        assertTrue(header1.checkEvent().isSetKlass());

        fr2.klassPhoto();

//        LeftColumn leftColumn = new LeftColumn(driver);
//        Header header = new Header(driver);
//        leftColumn.groups().searchAndJoinToGroup("Hi-Tech Mail");
////        leftColumn.refresh();
//        leftColumn.feed();
//        assertTrue(leftColumn.groups().checkThatJoined("Hi-Tech Mail"));
//        leftColumn.feed();
//        leftColumn.groups().quitFromGroup("Hi-Tech Mail");
//        leftColumn.feed();
//        assertFalse(leftColumn.groups().checkThatJoined("Hi-Tech Mail"));

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
