package project.auto.test.core.friendsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.auto.test.core.Utils;

public class SubscriberCard {
    private final WebElement element;
    private final String subscriberName;
    private static final By relativeSubscriberNameLocator = By.xpath(".//a[contains(@class, 'n-t bold')]");
    private static final By USER_GRID_CARD_LOCATOR = By.className("user-grid-card_avatar");
    private static final By CANCEL_SUBSCRIPTION_LOCATOR = By.xpath(".//span[contains(text(),'Отписаться')]");
    private static final By BUTTON_ADD_CONFIRM_LOCATOR = By.id("hook_FormButton_button_add_confirm");

    public SubscriberCard(WebElement element) {
        this.element = element;
        this.subscriberName = Utils.getInnerText(element, relativeSubscriberNameLocator);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getFriendName() {
        return subscriberName;
    }

    public void unsubscribe(final WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(USER_GRID_CARD_LOCATOR)).build().perform();
        element.findElement(CANCEL_SUBSCRIPTION_LOCATOR).click();
        element.findElement(BUTTON_ADD_CONFIRM_LOCATOR).click();
    }
}
