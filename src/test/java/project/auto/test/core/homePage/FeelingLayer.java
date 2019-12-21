package project.auto.test.core.homePage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FeelingLayer extends BasePage {
    private final By feelingCardsLocator = By.xpath(".//*[contains(@class,'feeling-layer_list_i')]");
    private final List<FeelingCard> feelingCards;

    public FeelingLayer(WebDriver driver) {
        super(driver);
        check();
        feelingCards = Utils.wrapElements(FeelingCard::new, driver.findElements(feelingCardsLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(feelingCardsLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public FeelingLayer clickOnCardByAlias(final String alias) {
        final int cardIndex = Utils.getFirstIndex(feelingCards, alias, FeelingCard::getAlias);
        if (cardIndex < 0) {
            throw new AssertionFailedError("Указанный вами алиас (" + alias + ") не найден среди доступных." + feelingCards);
        }
        throw new UnsupportedOperationException();
    }
}
