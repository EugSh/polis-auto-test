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

    public PeopleSearcher(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(SEARCH_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public PeopleSearcher search(final String name){
        type(name, SEARCH_LOCATOR);
        final int index = Utils.getFirstIndex(cards, name, SearchedPeopleCard::getSearchPeopleCardName);
        if (index == -1) {
            throw new AssertionFailedError("Указанный вами человек(" + name + ") не был найден среди списка доступных." + cards);
        }
        cards = Utils.wrapElements(SearchedPeopleCard::new, driver.findElements(PEOPLE_CARDS_LOCATOR));
        return this;
    }

    public SearchedPeopleCard getCardByName(final String name){
        return cards.get(Utils.getFirstIndex(cards, name, SearchedPeopleCard::getSearchPeopleCardName));
    }

}
