package project.core.left_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class LeftColumn extends BasePage {
    private static final By T_FRIENDS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,friends')]");
    private static final By USER_ALT_GROUP_LOCATOR = By.xpath(".//*[contains(@data-l,'t,userAltGroup')]");
    private static final By LEFT_COLUMN_LOCATOR = By.id("leftColumn");

    public LeftColumn(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(USER_ALT_GROUP_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(LEFT_COLUMN_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        /*assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,userFriend')]")),
                10,
                1000));*/
    }

    public GroupsPage groups(){
        click(USER_ALT_GROUP_LOCATOR);
        return new GroupsPage(driver);
    }

    public Subscriptions checkSubscriptions() {
        click(T_FRIENDS_LOCATOR);
        Subscriptions subscriptions = new Subscriptions(driver);
        subscriptions.check();
        return subscriptions;
    }
}
