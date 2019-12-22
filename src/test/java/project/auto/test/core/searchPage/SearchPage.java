package project.auto.test.core.searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchPage extends BasePage {
    private static final By categoryLocator = By.xpath(".//*[contains(@id, 'hook_Block_SearchResultGroups')]//span");
    private final List<SearchCategory> categoryList;

    public SearchPage(WebDriver driver) {
        super(driver);
        check();
        categoryList = Utils.wrapElements(SearchCategory::new, driver.findElements(categoryLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoryLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public PeopleSearcher clickPeople() {
        categoryList.get(Category.People.ordinal()).click();
        return new PeopleSearcher(driver);
    }

    public GroupSearcher clickGroup() {
        categoryList.get(Category.Groups.ordinal()).click();
        return new GroupSearcher(driver);
    }

    private enum Category {
        People,
        Groups,
        Games,
        Music,
        Video
    }

}
