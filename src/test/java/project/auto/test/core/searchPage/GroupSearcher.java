package project.auto.test.core.searchPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GroupSearcher extends BasePage {
    private final By groupCardsLocator = By.xpath(".//*[contains(@class, 'gs_result_group-card')]");
    private final List<SearchedGroupCard> cards;

    public GroupSearcher(WebDriver driver) {
        super(driver);
        check();
        cards = Utils.wrapElements(e -> new SearchedGroupCard(driver, e), driver.findElements(groupCardsLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(groupCardsLocator),
                maxCheckTime,
                msBetweenCheck));

    }

    public GroupSearcher search(final String str) {

        throw new UnsupportedOperationException();
    }

    public SearchedGroupCard getCardByName(final String groupName) {
        final int index = Utils.getFirstIndex(cards, groupName, SearchedGroupCard::getTitle, Utils.getLiteComparator());
        if (index == -1) {
            throw new AssertionFailedError("Указанная вами группа(" + groupName + ") не найдена среди списка доступных." + cards);
        }
        return cards.get(index);
    }
}
