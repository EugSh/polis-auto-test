package project.auto.test.core.guestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.friendsPage.FriendsCard;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GuestsList extends BasePage {
    private final List<GuestCard> items;
    private final By GUEST_LIST_LOCATOR = By.xpath(".//ul[contains(@class, 'ugrid_cnt')]");

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
        return items.get(Utils.getFirstIndex(items, name, GuestCard::getGuestName));
    }
}
