package project.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import project.core.LoginPage;
import project.model.TestBot;

public class SimpleTest extends TestBase {

    @Test
    public void simpleTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        TestBot bot = new TestBot("TechoBot15", "TechnoPolis19");
        loginPage.doLogin(bot);
//        driver.close();
    }
}
