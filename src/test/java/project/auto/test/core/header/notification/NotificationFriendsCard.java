package project.auto.test.core.header.notification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class NotificationFriendsCard {
    private final WebElement element;
    private final String notificationFriendsName;
    private static final By relativeNotificationFriendsNameNameLocator = By.xpath(".//*[contains(@data-l, 'nA,LINK_USER,t,user_link')]");
    private static final By BTN_ACCEPT_LOCATOR = By.xpath(".//*[contains(@data-l,'t,btn_accept')]");
    private static final By STATUS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,btn_accept')]");

    public NotificationFriendsCard(WebElement element) {
        this.element = element;
        this.notificationFriendsName = Utils.getInnerText(element, relativeNotificationFriendsNameNameLocator);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getNotificationFriendsName() {
        return notificationFriendsName;
    }

    public void accept(){
        element.findElement(BTN_ACCEPT_LOCATOR).click();
    }

    public String getAcceptStatus(){
        return (Utils.getInnerText(element, STATUS_LOCATOR)==" и вы теперь друзья.")?"You're friends":"";
    }
}
