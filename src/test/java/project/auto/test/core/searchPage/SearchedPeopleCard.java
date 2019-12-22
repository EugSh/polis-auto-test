package project.auto.test.core.searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;
import project.auto.test.core.Utils;
import project.auto.test.core.userProfile.UserProfilePage;

public class SearchedPeopleCard extends Element {
    private final WebElement element;
    private final String searchPeopleCardName;
    private static final By NAME_SEARCH_PEOPLE_CARD_LOCATOR = By.xpath(".//a[contains(@class, 'gs_result_i_t_name o')]");
    private static final By ADD_FRIEND_LOCATOR = By.xpath("//span[contains(text(), 'Добавить в друзья')]");

    public SearchedPeopleCard(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.searchPeopleCardName = Utils.getInnerText(element, NAME_SEARCH_PEOPLE_CARD_LOCATOR);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getSearchPeopleCardName() {
        return searchPeopleCardName;
    }

    public void clickAddFriend(){
        element.findElement(ADD_FRIEND_LOCATOR).click();
    }

    public UserProfilePage clickProfile(){
        element.findElement(NAME_SEARCH_PEOPLE_CARD_LOCATOR).click();
        return new UserProfilePage(driver);
    }
}
