package project.auto.test.core.header.message;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.groupPage.GroupCard;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MessageLayer extends BasePage {
    private final List<DialogItem> items;
    private static final By LEFT_MENU_MESSAGE_LOCATOR = By.xpath(".//div[contains(@class, 'chats custom-scrolling h-mod')]//div[contains(@class, 'chats_i h-mod')]");

    public MessageLayer(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(e -> new DialogItem(driver, e), driver.findElements(LEFT_MENU_MESSAGE_LOCATOR));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(LEFT_MENU_MESSAGE_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public MessageForm clickByName(String name) {
        final int index = Utils.getFirstIndex(items, name, DialogItem::getDialogName, Utils.getLiteComparator());
        if (index == -1) {
            throw new AssertionFailedError("Указанное вами имя (" + name + ") не найдено среди диалогов пользователя.");
        }
        return items.get(index).clickDialogItem();
    }

}
