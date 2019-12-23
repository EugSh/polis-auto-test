package project.auto.test.core.friendsPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FriendsList extends BasePage {
    private final List<FriendsCard> items;
    private static final By FRIEND_LIST_LOCATOR = By.xpath(".//ul[contains(@class, 'ugrid_cnt')]/li");

    public FriendsList(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(e -> new FriendsCard(driver, e), driver.findElements(FRIEND_LIST_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(FRIEND_LIST_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public FriendsCard getByName(final String name) {
        final int index = Utils.getFirstIndex(items, name, FriendsCard::getFriendName, Utils.getLiteComparator());
        if (index == -1){
            throw new AssertionFailedError("Друг с именем("+name+") не найден в списке доступных"+items);
        }
        return items.get(index);
    }
}
