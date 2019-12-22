package project.auto.test.core.searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;

public class SearchedGroupCard extends Element {
    private final WebElement element;
    private static final By titleLocator = By.xpath(".//a[contains(@data-l, 'NAME')]");
    private static final By joinBtnLocator = By.xpath(".//span[contains(@class, 'button-pro')]");
    private static final By joinStatusLocator = By.xpath(".//div[contains(@class, 'join-group-result')]");
    private final String title;

    public SearchedGroupCard(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.title = getInnerText(element, titleLocator);

    }


    public String getTitle() {
        return title;
    }

    public SearchedGroupCard join() {
        click(element, joinBtnLocator);
        return this;
    }

    public String getJoinStatus() {
        return getInnerText(element, joinStatusLocator);
    }

    @Override
    public String toString() {
        return "SearchedGroupCard{" +
                "title='" + title + '\'' +
                '}';
    }
}
