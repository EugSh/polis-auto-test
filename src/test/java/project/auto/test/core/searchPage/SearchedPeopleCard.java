package project.auto.test.core.searchPage;

import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;
import project.auto.test.core.userProfile.UserProfilePage;

public class SearchedPeopleCard{
    private final WebElement element;
    private final String searchPeopleCardName;

    public SearchedPeopleCard(WebElement element) {
        this.element = element;
        this.searchPeopleCardName = Utils.getInnerText(element, relativeNotificationFriendsNameNameLocator);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getSearchPeopleCardName() {
        return searchPeopleCardName;
    }

    public void clickAddFriend(){
        throw new UnsupportedOperationException();
    }

    public UserProfilePage clickProfile(){
        throw new UnsupportedOperationException();
    }
}
