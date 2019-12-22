package project.auto.test.core.header.notification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class NotificationLayer extends BasePage {
    private final List<NotificationItems> items;
    private static final By LEFT_MENU_NOTIFICATION_LOCATOR = By.xpath(".//*[contains(@class, 'toolbar-layer_menu custom-scrolling usel-off')]/div[contains(@class, 'nav-side __navigation')]");

    public NotificationLayer(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(NotificationItems::new, driver.findElements(LEFT_MENU_NOTIFICATION_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(LEFT_MENU_NOTIFICATION_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public NotificationFriendsList clickFriendship() {
        items.get(NotificationLayer.LeftMenuNotificationItems.Friendship.ordinal()).click();
        return new NotificationFriendsList(driver);
    }

    private enum LeftMenuNotificationItems {
        All,
        Friendship,
        Gifts,
        Groups,
        Games,
        Pays,
        Video,
        Other
    }

}
