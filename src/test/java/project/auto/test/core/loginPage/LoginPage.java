package project.auto.test.core.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.model.TestBot;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    private static final By loginField = By.name("st.email");
    private static final By passwordField = By.name("st.password");
    private static final By signInButton = By.xpath(".//*[contains(@data-l,'t,sign_in')]");

    /**
     * Страница входа на порта.
     *
     * @param driver {@link WebDriver}
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {
//        System.out.println(isElementPresent(signInButton));
        assertTrue(isElementPresent(signInButton));
        assertTrue(isElementPresent(loginField));
        assertTrue(isElementPresent(passwordField));
//        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(loginField),
//                maxCheckTime,
//                msBetweenCheck));
//        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.password")),
//                maxCheckTime,
//                msBetweenCheck));
//        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,sign_in')]")),
//                maxCheckTime,
//                msBetweenCheck));
    }

    public HomePage doLogin(final TestBot bot) {
        type(bot.getLogin(), loginField);
        type(bot.getPassword(), passwordField);
        click(signInButton);
        return new HomePage(driver);
    }
}
