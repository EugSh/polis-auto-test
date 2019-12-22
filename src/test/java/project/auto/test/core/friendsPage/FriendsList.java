package project.auto.test.core.friendsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FriendsList extends BasePage {
    private final List<FriendsCard> items;
    private final By FRIEND_LIST_LOCATOR = By.xpath(".//ul[contains(@class, 'ugrid_cnt')]");

    public FriendsList(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(FriendsCard::new, driver.findElements(FRIEND_LIST_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(FRIEND_LIST_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public FriendsCard getByName(final String name) {
        return items.get(Utils.getFirstIndex(items, name, FriendsCard::getFriendName));
    }
}
