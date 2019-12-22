package project.auto.test.core.header.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class EventCard {
    private final WebElement element;
    private final String senderNameSurName;
    private final By senderLocator = By.xpath(".//a[contains(@data-l, 't,uL')]");

    /**
     * Карточка события.
     *
     * @param element {@link WebDriver}
     */
    public EventCard(WebElement element) {
        this.element = element;
        this.senderNameSurName = Utils.getInnerText(element, senderLocator);
    }

    public String getSenderNameSurName() {
        return senderNameSurName;
    }
}
