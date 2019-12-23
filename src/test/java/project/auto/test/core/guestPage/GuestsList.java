package project.auto.test.core.guestPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.friendsPage.FriendsCard;
import project.auto.test.core.searchPage.SearchedPeopleCard;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GuestsList extends BasePage {
    private final List<GuestCard> items;
    private static final By GUEST_LIST_LOCATOR = By.xpath(".//div[contains(@data-l, 't,guests')]");

    public GuestsList(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(GuestCard::new, driver.findElements(GUEST_LIST_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(GUEST_LIST_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public GuestCard getByName(final String name) {
        final int index = Utils.getFirstIndex(items, name, GuestCard::getGuestName);
        if (index == -1) {
            throw new AssertionFailedError("Указанный вами гость(" + name + ") не найден среди списка доступных." + items);
        }
        return items.get(index);
        //return items.get(Utils.getFirstIndex(items, name, GuestCard::getGuestName));
    }
}
