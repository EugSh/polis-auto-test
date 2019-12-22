package project.auto.test.core.header.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class EventsLayer extends BasePage {
    private static final By eventCardLocator = By.xpath(".//*[contains(@data-l, 't,item')]");
    private final List<EventCard> cards;

    /**
     * Слой, в котором представлен список событий {@link EventCard}
     *
     * @param driver {@link WebDriver}
     */
    public EventsLayer(WebDriver driver) {
        super(driver);
        check();
        cards = Utils.wrapElements(EventCard::new, driver.findElements(eventCardLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(eventCardLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public EventCard getFirstEvent() {
        return cards.get(0);
    }
}
