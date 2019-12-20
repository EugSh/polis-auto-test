package project.auto.test.core.homePage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.groupPage.GroupsPage;

public class HPLeftContent extends BasePage {
    public HPLeftContent(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public GroupsPage clickGroups(){
        throw new UnsupportedOperationException();
    }
}
