package project.auto.test.core.header;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.friendsPage.FriendsPage;
import project.auto.test.core.guestPage.GuestsPage;
import project.auto.test.core.header.message.MessageLayer;
import project.auto.test.core.header.notification.NotificationLayer;
import project.auto.test.core.searchPage.SearchPage;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);

    }

    @Override
    protected void check() {

    }

    public DropDownToolBar clickDropDownToolBar(){
        return new DropDownToolBar(driver);
    }

    public SearchPage clickLupa(){
        return new SearchPage();
    }

    public NotificationLayer clickNotification(){
        throw new UnsupportedOperationException();
    }

    public FriendsPage clickFriends(){
        throw new UnsupportedOperationException();
    }

    public GuestsPage clickGuest(){
        throw new UnsupportedOperationException();
    }

    public MessageLayer clickMessage(){
        throw new UnsupportedOperationException();
    }






}
