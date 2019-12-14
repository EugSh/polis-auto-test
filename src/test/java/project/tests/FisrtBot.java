package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.core.Header;
import project.core.LeftColumn;
import project.core.LoginPage;
import project.model.TestBot;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FisrtBot {
    @Test
    public void addFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header header = new Header(webDriver);
        assertTrue(header.doSearch("TechoBot15").addFriend());
        Thread.sleep(1000);
    }

    @Test
    public void agreeFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header header = new Header(webDriver);
        assertTrue(header.checkNotifications().agree());
        Thread.sleep(1000);
    }

    @Test
    public void sendMessage() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header header = new Header(webDriver);
        header.sendMessage();
    }

    @Test
    public void readMessage() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header header = new Header(webDriver);
        header.readMessage();
    }

    @Test
    public void watchProfile() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header header = new Header(webDriver);
        header.watchProfile();
    }

    @Test
    public void checkGuests() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        Header header = new Header(webDriver);
        header.checkGuests();
    }

    @Test
    public void deleteFriend() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot7", "TechnoPolis19"));
        Header header = new Header(webDriver);
        assertTrue(header.deleteFriend());
        Thread.sleep(1000);
    }

    @Test
    public void cancelSubscription() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin(new TestBot("TechoBot15", "TechnoPolis19"));
        LeftColumn leftColumn = new LeftColumn(webDriver);
        assertFalse(leftColumn.checkSubscriptions().unsubscribe());
        Thread.sleep(1000);
    }
}
