package project.auto.test.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.loginPage.LoginPage;

import static org.junit.Assert.assertTrue;

public class DropDownToolBar extends BasePage {
    private final By logoutLocator = By.xpath(".//*[contains(@data-l,'t,logoutCurrentUser')]");

    public DropDownToolBar(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
    }

    public LoginPage logOut(){
        click(logoutLocator);
        return new LoginPage(driver);
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

}
