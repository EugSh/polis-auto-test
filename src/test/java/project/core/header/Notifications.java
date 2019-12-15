package project.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Notifications extends BasePage {

    private static final By BTN_ACCEPT_LOCATOR = By.xpath(".//*[contains(@data-l,'t,btn_accept')]");
    private static final By NOTIF_TX_LOCATOR = By.className("notif_tx");
    private static final By CHECK_THAT_YOU_ARE_FRIENDS_LOCATOR = By.xpath("//div[contains(text(), 'и вы теперь друзья')]");

    public Notifications(WebDriver driver) {
        super(driver);
    }


    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(NOTIF_TX_LOCATOR),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(BTN_ACCEPT_LOCATOR),
                10,
                1000));
    }

    public boolean agree() {
        click(BTN_ACCEPT_LOCATOR);
        return driver.findElement(CHECK_THAT_YOU_ARE_FRIENDS_LOCATOR).isDisplayed();
    }

    public boolean watch() {
        return true;
    }
}
