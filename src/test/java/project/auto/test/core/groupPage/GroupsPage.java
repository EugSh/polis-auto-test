package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class GroupsPage extends BasePage {
    private final By myGroupBtnLocator = By.xpath(".//*[contains(@id,'hook_Block_MyGroupsNavBlock')]//div[contains(@class,'portlet_h_name_t')]");

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    public GroupsList myGroups(){
        click(myGroupBtnLocator);
        return new GroupsList(driver);
    }

    @Override
    protected void check() {

    }
}
