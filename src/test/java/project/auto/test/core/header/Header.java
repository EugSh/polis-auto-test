package project.auto.test.core.header;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.auto.test.BasePage;
import project.auto.test.core.friendsPage.FriendsPage;
import project.auto.test.core.guestPage.GuestsPage;
import project.auto.test.core.header.message.MessageLayer;
import project.auto.test.core.header.notification.NotificationLayer;
import project.auto.test.core.searchPage.SearchPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(Header.class);
    private final By dropDownToolBarLocator = By.className("toolbar_dropdown_w");
    private final By toolBarItemsLocator = By.xpath((".//*[contains(@class,'toolbar_nav')]//li"));
    private final List<ToolBarItem> toolBarItems;

    /**
     * Верхняя панель, которая присутствует на всех основных страница портала.
     * Имеющиеся элементы: Сообщения, Обсуждения, Оповещения, Друзья, Гости,
     * События, Видео, Музыка, строка поиска и меню с выпадающим списоком элемнтов.
     *
     * @param driver WebDriver
     */
    public Header(WebDriver driver) {
        super(driver);
        log.info("Проверям, что кнопки на верхней панели прогружены.");
        check();
        log.info("Оборачиваем список кнопок на верхней панеле.");
        toolBarItems = ToolBarItem.wrapTolBar(driver.findElements(toolBarItemsLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(toolBarItemsLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public DropDownToolBar clickDropDownToolBar() {
        log.info("Нажимаем на конку в правом верхнем углу, после чего должен появится выпадающий список." +
                ", где можно получить имя и фамилию пользователя, выйти из портала и список различных элементов");
        click(dropDownToolBarLocator);
        log.info("Возращаем объект представляющий собой выпадающий список.");
        return new DropDownToolBar(driver);
    }

    public SearchPage clickLupa() {
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new SearchPage();
    }

    public NotificationLayer clickNotification() {
        toolBarItems.get(2).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new NotificationLayer();
    }

    public FriendsPage clickFriends() {
        toolBarItems.get(3).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new FriendsPage();
    }

    public GuestsPage clickGuest() {
        toolBarItems.get(4).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new GuestsPage();
    }

    public MessageLayer clickMessage() {
        toolBarItems.get(0).click();
        //TODO : добавить параметры конструктора, когда будут реализован соответствующий класс
        return new MessageLayer();
    }

}
