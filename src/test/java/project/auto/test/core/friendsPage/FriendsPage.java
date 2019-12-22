package project.auto.test.core.friendsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;

import static org.junit.Assert.assertTrue;

public class FriendsPage extends BasePage {
    private static final By MY_SUBSCRIPTIONS_LOCATOR = By.xpath("//div[contains(text(), 'Мои подписки')]");

    public FriendsPage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(MY_SUBSCRIPTIONS_LOCATOR),
                maxCheckTime,
                msBetweenCheck));
    }

    public FriendsList getFriendList() {
         return new FriendsList(driver);
    }

    public SubscribersList clickSubscriber(){
        click(MY_SUBSCRIPTIONS_LOCATOR);
        return new SubscribersList(driver);
    }

    /*public int subscriberCount(){
        throw new UnsupportedOperationException();
    }*/
}
