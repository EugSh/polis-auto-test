package project.auto.test.core.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    private final By loginField = By.name("st.email");
    private final By passwordField = By.name("st.password");
    private final By signInButton = By.xpath(".//*[contains(@data-l,'t,sign_in')]");

    public LoginPage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {
        assertTrue(isElementVisible(loginField));
        assertTrue(isElementVisible(passwordField));
        assertTrue(isElementVisible(signInButton));
    }

    public HomePage doLogin(final TestBot bot) {
        type(bot.getLogin(), loginField);
        type(bot.getPassword(), passwordField);
        click(signInButton);
        return new HomePage(driver);
    }
}
