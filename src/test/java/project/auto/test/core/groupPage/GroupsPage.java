package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class GroupsPage extends BasePage {
    private final By myGroupBtnLocator = By.xpath(".//*[contains(@id,'hook_Block_MyGroupsNavBlock')]//div[contains(@class,'portlet_h_name_t')]");

    /**
     * Страница групп.
     *
     * @param driver {@link WebDriver}
     */
    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод возвращает объек, который содержит себе все группы, в которых состоит пользователь.
     *
     * @return {@link GroupsList}
     */
    public GroupsList myGroups() {
        click(myGroupBtnLocator);
        return new GroupsList(driver);
    }

    @Override
    protected void check() {

    }
}
