package project.auto.test.core.header.notification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class NotificationFriendsList extends BasePage {
    private final List<NotificationFriendsCard> items;
    private static final By NOTIFICATION_FRIENDS_LIST_LOCATOR = By.xpath(".//div[contains(@id, 'ntf_layer_content_inner')]");

    public NotificationFriendsList(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(NotificationFriendsCard::new, driver.findElements(NOTIFICATION_FRIENDS_LIST_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(NOTIFICATION_FRIENDS_LIST_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public NotificationFriendsCard getByName(final String name){
        return items.get(Utils.getFirstIndex(items, name, NotificationFriendsCard::getNotificationFriendsName));
    }

}
