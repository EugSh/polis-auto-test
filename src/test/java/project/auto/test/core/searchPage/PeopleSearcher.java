package project.auto.test.core.searchPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.header.notification.NotificationFriendsCard;
import project.auto.test.core.header.notification.NotificationItems;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PeopleSearcher extends BasePage {
    private List<SearchedPeopleCard> cards;
    private static final By SEARCH_LOCATOR = By.xpath(".//*[contains(@class, 'it search-input_it')]");
    private static final By PEOPLE_CARDS_LOCATOR = By.xpath(".//div[contains(@class, 'gs_result_list')]");
    private static final By searchFromLocator = By.xpath(".//*[contains(@class, 'search-wrapper-form')]//div[contains(@class, 'it_w')]");

    public PeopleSearcher(WebDriver driver) {
        super(driver);
        check();
        cards = Utils.wrapElements(e -> new SearchedPeopleCard(driver, e), driver.findElements(PEOPLE_CARDS_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(SEARCH_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public PeopleSearcher search(final String name) {
        type(name, SEARCH_LOCATOR);
        final boolean searchingResult = explicitWait(ExpectedConditions
                        .not(ExpectedConditions
                                .attributeContains(searchFromLocator, "class", "search-input_searching")),
                maxCheckTime,
                msBetweenCheck);
        if (searchingResult) {
            return new PeopleSearcher(driver);
        }
        throw new AssertionFailedError("Поиск групп по запросу(" + name + ") длился дольше чем " + maxCheckTime + " секунд");
    }

    public SearchedPeopleCard getCardByName(final String name) {
        final int index = Utils.getFirstIndex(cards, name, SearchedPeopleCard::getSearchPeopleCardName, Utils.getLiteComparator());
        if (index == -1) {
            throw new AssertionFailedError("Указанная вами группа(" + name + ") не найдена среди списка доступных." + cards);
        }
        return cards.get(index);
    }

}
