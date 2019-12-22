package project.auto.test.core.searchPage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class SearchPage extends BasePage {


    public SearchPage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {

    }

    public PeopleSearcher clickPeople() {
        throw new UnsupportedOperationException();
    }

    public GroupSearcher clickGroup() {
        throw new UnsupportedOperationException();
    }

}
