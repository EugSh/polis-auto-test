package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.core.Header1;
import project.core.LeftColumn;
import project.core.LoginPage11;
import project.model.TestBot;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FisrtBot {
    @Test
    public void addFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        assertTrue(header1.doSearch("TechoBot15").addFriend());
        Thread.sleep(1000);
    }

    @Test
    public void agreeFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        assertTrue(header1.checkNotifications().agree());
        Thread.sleep(1000);
    }

    @Test
    public void sendMessage() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        header1.sendMessage();
    }

    @Test
    public void readMessage() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        header1.readMessage();
    }

    @Test
    public void watchProfile() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        header1.watchProfile();
    }

    @Test
    public void checkGuests() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        header1.checkGuests();
    }

    @Test
    public void deleteFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header1 header1 = new Header1(webDriver);
        assertTrue(header1.deleteFriend());
        Thread.sleep(1000);
    }

    @Test
    public void cancelSubscription() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage11 loginPage1 = new LoginPage11(webDriver);
        loginPage1.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        LeftColumn leftColumn = new LeftColumn(webDriver);
        assertFalse(leftColumn.checkSubscriptions().unsubscribe());
        Thread.sleep(1000);
    }
}
