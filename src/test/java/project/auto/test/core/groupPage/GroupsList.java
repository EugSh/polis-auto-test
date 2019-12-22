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
    private static final By groupCardLocator = By.xpath(".//*[contains(@id,'listBlockPanelDetailedUserGroupsListBlock')]//div[contains(@class,'ugrid_i')]");
    private final List<GroupCard> cards;

    /**
     * Блок, который содержит список всех групп, в которых состоит пользователь.
     *
     * @param driver {@link WebDriver}
     */
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

    /**
     * Метод, который возвращает первую совпавшую по заголовку карточку группы.
     *
     * @param title {@link String}
     * @return {@link GroupCard} объект-карточка группы
     */
    public GroupCard getByName(final String title) {
        final int index = Utils.getFirstIndex(cards, title, GroupCard::getTitle, Utils.getLiteComparator());
        System.out.println(cards);
        if (index == -1) {
            throw new AssertionFailedError("Указанная вами группа (" + title + ") не найденна среди групп пользователя.");
        }
        return cards.get(index);
    }

}
