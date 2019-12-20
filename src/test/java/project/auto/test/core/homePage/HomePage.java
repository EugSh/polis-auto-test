package project.auto.test.core.homePage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.header.Header;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {
    }

    public Header header() {
        return new Header(driver);
    }

    public HPLeftContent leftColumnContent() {
        return new HPLeftContent(driver);
    }

    public HPMiddleContent middleColumnContent() {
        return new HPMiddleContent(driver);
    }
}
