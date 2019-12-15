package project.core;

import project.model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    public LoginPage(final WebDriver driver) {
        super(driver);
        isLoginPage();
    }

    public void isLoginPage(){
        check();
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.email")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.password")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,sign_in')]")),
                10,
                1000));
    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.name("st.email"));
        type(testBot.getPassword(), By.name("st.password"));
        click(By.xpath(".//*[contains(@data-l,'t,sign_in')]"));
    }
}
