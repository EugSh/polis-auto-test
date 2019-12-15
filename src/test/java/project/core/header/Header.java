package project.core.header;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    private static final By TOOLBAR_DROPDOWN_LOCATOR = By.className("toolbar_dropdown_w");
    private static final By TOOLBAR_LOCATOR = By.className("toolbar");
    private static final By IT_LOCATOR = By.className("it");
    private static final By TOOLBAR_SEARCH_LUPA_LOCATOR = By.className("toolbar_search_lupa");
    private static final By TOOLBAR_NAV_LOCATOR = By.className("toolbar_nav_i_ic");
    private static final By T_FRIENDS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,friends')]");
    private static final By T_MESSAGES_LOCATOR = By.xpath(".//*[contains(@data-l,'t,messages')]");
    private static final By T_NOTIFICATIONS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,notifications')]");
    private static final By T_GUESTS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,guests')]");
    private static final By T_SEND_MESSAGE_LOCATOR = By.xpath(".//*[contains(@data-l,'t,send_message')]");
    private static final By USER_GRID_CARD_AVATAR_LOCATOR = By.className("user-grid-card_avatar");
    private static final By T_TA_LOCATOR = By.xpath(".//*[contains(@data-l,'t,ta')]");
    private static final By COMMENTS_ADD_CONTROLS_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-controls')]/button");
    private static final By T_EVENTS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,marks')]");


    public Header(WebDriver driver) {
        super(driver);
    }

    public ToolBarDropDown clickToolBarDropDown() {
        click(TOOLBAR_DROPDOWN_LOCATOR);
        return new ToolBarDropDown(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(TOOLBAR_DROPDOWN_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(TOOLBAR_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(IT_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(TOOLBAR_SEARCH_LUPA_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(TOOLBAR_NAV_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(T_FRIENDS_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(T_MESSAGES_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(T_NOTIFICATIONS_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(T_GUESTS_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public Friends getFriend() {
        Friends friends = new Friends(driver);
        friends.check();
        return friends;
    }

    public Notifications getNotifications() {
        Notifications notifications = new Notifications(driver);
        notifications.check();
        return notifications;
    }

    public Friends doSearch(String loginBot) {
        type(loginBot, IT_LOCATOR);
        click(TOOLBAR_SEARCH_LUPA_LOCATOR);
        return getFriend();
    }

    public Notifications checkNotifications() {
        click(T_NOTIFICATIONS_LOCATOR);
        return getNotifications();
    }

    public Friends deleteFriend() {
        click(T_FRIENDS_LOCATOR);
        return getFriend();
    }

    public void sendMessage() {
        click(T_MESSAGES_LOCATOR);
        click(T_SEND_MESSAGE_LOCATOR);
        type("Hello! How are you?", T_TA_LOCATOR);
        click(COMMENTS_ADD_CONTROLS_LOCATOR);
    }

    public void readMessage() {
        click(T_MESSAGES_LOCATOR);
        click(T_SEND_MESSAGE_LOCATOR);
    }

    public void watchProfile() {
        click(T_FRIENDS_LOCATOR);
        click(USER_GRID_CARD_AVATAR_LOCATOR);
    }

    public void checkGuests() {
        click(T_GUESTS_LOCATOR);
    }

    public Event checkEvent() {
        click(T_EVENTS_LOCATOR);
        return new Event(driver);
    }
}