package project.auto.test.core.header.notification;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.searchPage.SearchedGroupCard;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class NotificationFriendsList extends BasePage {
    private final List<NotificationFriendsCard> items;
    private static final By NOTIFICATION_FRIENDS_LIST_LOCATOR = By.xpath(".//div[contains(@id, 'ntf_layer_content_inner')]/div");

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
        final int index = Utils.getFirstIndex(items, name, NotificationFriendsCard::getNotificationFriendsName, Utils.getLiteComparator());
        if (index == -1) {
            throw new AssertionFailedError("Указанная вами группа(" + name + ") не найдена среди списка доступных." + items);
        }
        return items.get(index);
    }

}
