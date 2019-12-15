package project.core.left_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Subscriptions extends BasePage {
    private static final By MY_SUBSCRIPTIONS_LOCATOR = By.xpath("//div[contains(text(), 'Мои подписки')]");
    private static final By USER_GRID_CARD_LOCATOR = By.className("user-grid-card_avatar");
    private static final By CANCEL_SUBSCRIPTION_LOCATOR = By.xpath(".//span[contains(text(),'Отписаться')]");
    private static final By BUTTON_ADD_CONFIRM_LOCATOR = By.id("hook_FormButton_button_add_confirm");
    private static final By MY_SUBSCRIPTIONS_N_LOCATOR = By.xpath("//span[contains(text(), '1')]");

    public Subscriptions(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(MY_SUBSCRIPTIONS_LOCATOR),
                10,
                1000));
    }

    public boolean unsubscribe() {
        click(MY_SUBSCRIPTIONS_LOCATOR);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(USER_GRID_CARD_LOCATOR)).build().perform();
        click(CANCEL_SUBSCRIPTION_LOCATOR);
        click(BUTTON_ADD_CONFIRM_LOCATOR);
        return driver.findElement(MY_SUBSCRIPTIONS_N_LOCATOR).isDisplayed();
    }
}
