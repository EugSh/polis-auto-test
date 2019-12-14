package project.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.model.TestBot;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    private final int checkTime = 10;

    public LoginPage(final WebDriver driver) {
        super(driver);
        check();
    }

    public void doLogin(final TestBot bot){
        type(bot.getLogin(), By.name("st.email"));
        type(bot.getPassword(), By.name("st.password"));
        click(By.xpath(".//*[contains(@data-l,'t,sign_in')]"));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,sign_in')]")),
                checkTime,
                500));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.email")),
                checkTime,
                500));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.password")),
                checkTime,
                500));
    }
}
