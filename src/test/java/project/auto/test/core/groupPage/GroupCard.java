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
    public static final Comparator<String> COMPARATOR = (str, key) -> {
        final Pattern pattern = Pattern.compile(key);
        final Matcher matcher = pattern.matcher(str);
        return matcher.find() ?
                0 :
                str.length() > key.length() ?
                        1 :
                        -1;
    };
    private final WebElement element;
    private final By relativeTitleLocator = By.xpath(".//a[contains(@data-l, 't,visit')]");
    private final String title;

    public GroupCard(WebElement element, WebDriver driver) {
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
