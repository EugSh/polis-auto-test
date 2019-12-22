package project.auto.test.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.friendsPage.FriendsPage;
import project.auto.test.core.guestPage.GuestsPage;
import project.auto.test.core.header.events.EventsLayer;
import project.auto.test.core.header.message.MessageLayer;
import project.auto.test.core.header.notification.NotificationLayer;
import project.auto.test.core.searchPage.SearchPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    private static final By dropDownToolBarLocator = By.className("toolbar_dropdown_w");
    private static final By toolBarItemsLocator = By.xpath((".//*[contains(@class,'toolbar_nav')]//li"));
    private final List<ToolBarItem> toolBarItems;

    /**
     * Верхняя панель, которая присутствует на всех основных страница портала.
     * Имеющиеся элементы: Сообщения, Обсуждения, Оповещения, Друзья, Гости,
     * События, Видео, Музыка, строка поиска и меню с выпадающим списоком элемнтов.
     *
     * @param driver {@link WebDriver}
     */
    public Header(WebDriver driver) {
        super(driver);
        check();
        toolBarItems = Utils.wrapElements(ToolBarItem::new, driver.findElements(toolBarItemsLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(toolBarItemsLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    /**
     * Нажимаем на конку в правом верхнем углу, после чего должен появится выпадающий список.
     * где можно получить имя и фамилию пользователя, выйти из портала и список различных элементов
     *
     * @return {@link DropDownToolBar} Возращаем объект представляющий собой выпадающий список.
     */
    public DropDownToolBar clickDropDownToolBar() {
        click(dropDownToolBarLocator);
        return new DropDownToolBar(driver);
    }

    public SearchPage clickLupa() {
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new SearchPage(driver);
    }

    public NotificationLayer clickNotification() {
        toolBarItems.get(NavToolBarItems.Notifications.ordinal()).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new NotificationLayer();
    }

    public FriendsPage clickFriends() {
        toolBarItems.get(NavToolBarItems.Friends.ordinal()).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new FriendsPage();
    }

    public GuestsPage clickGuest() {
        toolBarItems.get(NavToolBarItems.Guests.ordinal()).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new GuestsPage();
    }

    public MessageLayer clickMessage() {
        toolBarItems.get(NavToolBarItems.Messages.ordinal()).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new MessageLayer();
    }

    public EventsLayer clickEvents() {
        toolBarItems.get(NavToolBarItems.Events.ordinal()).click();
        return new EventsLayer(driver);
    }

    private enum NavToolBarItems {
        Messages,
        Discussions,
        Notifications,
        Friends,
        Guests,
        Events,
        Video,
        Music
    }

}
