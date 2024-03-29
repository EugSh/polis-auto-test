package project.auto.test.core.friendsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SubscribersList extends BasePage {
    private final List<SubscriberCard> items;
    private static final By SUBSCRIBER_LIST_LOCATOR = By.xpath(".//*[contains(@class, 'ugrid __xl __align-bottom')]/div[contains(@class, 'ugrid_cnt')]/div");

    public SubscribersList(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(e -> new SubscriberCard(driver, e), driver.findElements(SUBSCRIBER_LIST_LOCATOR));

    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(SUBSCRIBER_LIST_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public SubscriberCard getByName(final String name) {
        return items.get(Utils.getFirstIndex(items, name, SubscriberCard::getFriendName, Utils.getLiteComparator()));
    }

}
