package project.auto.test.core.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class FeelingCard {
    private final WebElement element;
    private final String title;
    private final String alias;
    private final By relativeTitleLocator = By.xpath("//div[contains(@class, 'feeling-card_tx')]");
    private final By relativeAliasLocator = By.xpath("/div");

    public FeelingCard(WebElement element) {
        this.element = element;
        this.title = Utils.getInnerText(element, relativeTitleLocator);
        this.alias = Utils.getAttribute(element, relativeAliasLocator, Utils.ALIAS_ATTR);
    }

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public void click() {
        element.click();
    }


    @Override
    public String toString() {
        return "FeelingCard{" +
                "title='" + title + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
