package project.auto.test.core.groupPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GroupsList extends BasePage {
    private final By groupCardLocator = By.xpath(".//*[contains(@id,'listBlockPanelDetailedUserGroupsListBlock')]//div[contains(@class,'ugrid_i')]");
    private final List<GroupCard> cards;

    public GroupsList(WebDriver driver) {
        super(driver);
        check();
        cards = Utils.wrapElements(e -> new GroupCard(driver, e),
                driver.findElements(groupCardLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(groupCardLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public GroupCard getByName(final String name) {
        final int index = Utils.getFirstIndex(cards, name, GroupCard::getTitle, Utils.getLiteComparator());
        if (index == -1) {
            throw new AssertionFailedError("Указанная вами группа (" + name + ") не найденна среди групп пользователя.");
        }
        return cards.get(index);
    }

}
