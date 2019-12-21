package project.auto.test.core.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.groupPage.GroupsPage;
import project.auto.test.core.header.ToolBarItem;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HPLeftContent extends BasePage {
    private final By navigationBarLocator = By.xpath(".//*[contains(@data-l,'t,navigation')]/div[contains(@class, 'nav-side')]/*");
    private final List<ToolBarItem> toolBarItems;

    public HPLeftContent(WebDriver driver) {
        super(driver);
        check();
        toolBarItems = Utils.wrapElements(ToolBarItem::new, driver.findElements(navigationBarLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(navigationBarLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public GroupsPage clickGroups() {
        toolBarItems.get(NavToolBarItems.Groups.ordinal()).click();
        return new GroupsPage(driver);
    }

    private enum NavToolBarItems {
        UserInfo,
        Home,
        Recommended,
        Friends,
        Photos,
        Groups,
        Games,
        Gifts,
        Products,
        Professionals,
        Posts,
        PhotoContest,
        PaymentsSubscribes,
        Other
    }
}
