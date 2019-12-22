package project.auto.test.core.userProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.header.message.MessageLayer;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserProfilePage extends BasePage {
    private static final By avatarLocator = By.xpath(".//*[contains(@class, 'entity-avatar')]");
    private static final By actionMenuItemsLocator = By.xpath(".//*[contains(@class, 'header-action-menu')]/li");
    private final List<ProfileActionMenuItem> menuItemList;

    public UserProfilePage(WebDriver driver) {
        super(driver);
        check();
        menuItemList = Utils.wrapElements(ProfileActionMenuItem::new, driver.findElements(actionMenuItemsLocator));
    }


    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(actionMenuItemsLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public MessageLayer clickWriteMessage() {
        menuItemList.get(ActionMenuItems.Write.ordinal()).click();
        return new MessageLayer(driver);
    }

    public PhotosLayer clickAvatar() {
        click(avatarLocator);
        return new PhotosLayer(driver);
    }

    public UserProfilePage clickAddFriend() {
        menuItemList.get(ActionMenuItems.AddToFriends.ordinal()).click();
        return this;
    }

    private enum ActionMenuItems {
        AddToFriends,
        Write,
        Other
    }
}
