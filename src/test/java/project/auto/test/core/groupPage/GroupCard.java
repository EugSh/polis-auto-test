package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;
import project.auto.test.core.Utils;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupCard extends Element {
    private final WebElement element;
    private final By relativeTitleLocator = By.xpath(".//a[contains(@data-l, 't,visit')]");
    private final String title;

    public GroupCard(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.title = Utils.getInnerText(element, relativeTitleLocator);
    }

    public String getTitle() {
        return title;
    }

    public GroupProfilePage clickGroupProfile() {
        element.click();
        return new GroupProfilePage(driver);
    }
}
