package project.auto.test.core.friendsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.auto.test.Element;
import project.auto.test.core.Utils;

public class FriendsCard extends Element {
    private static final By T_CONFIRM_LOCATOR = By.xpath(".//*[contains(@data-l,'t,confirm')]");
    private static final By USER_GRID_CARD_AVATAR_LOCATOR = By.xpath((".//*[contains(@class,'user-grid-card_img')]"));
    private static final By STOP_FRIENDSHIP_LOCATOR = By.xpath(".//span[contains(text(),'Прекратить дружбу')]");
    private static final By relativeFriendNameLocator = By.xpath(".//a[contains(@class, 'n-t bold')]");
    private final WebElement element;
    private final String friendName;

    public FriendsCard(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.friendName = Utils.getInnerText(element, relativeFriendNameLocator);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getFriendName() {
        return friendName;
    }

    public void clickDeleteFriend() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element.findElement(USER_GRID_CARD_AVATAR_LOCATOR)).build().perform();
        driver.findElement(STOP_FRIENDSHIP_LOCATOR).click();
        driver.findElement(T_CONFIRM_LOCATOR).click();
    }
}
