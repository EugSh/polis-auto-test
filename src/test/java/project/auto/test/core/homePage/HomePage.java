package project.auto.test.core.homePage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;
import project.auto.test.core.header.Header;

public class HomePage extends BasePage {
    private final Header header;
    private final HPLeftContent leftContent;
    private final HPMiddleContent middleContent;

    /**
     * Домашняя страница пользователя https://ok.ru/
     *
     * @param driver {@link WebDriver}
     */
    public HomePage(WebDriver driver) {
        super(driver);
        check();
        header = new Header(driver);
        leftContent = new HPLeftContent(driver);
        middleContent = new HPMiddleContent(driver);
    }

    @Override
    protected void check() {
    }

    public Header header() {
        return header;
    }

    public HPLeftContent leftColumnContent() {
        return leftContent;
    }

    public HPMiddleContent middleColumnContent() {
        return middleContent;
    }
}
