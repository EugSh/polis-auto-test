package project.auto.test.core.guestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class GuestCard {
    private final WebElement element;
    private final String guestName;
    private static final By relativeGuestNameLocator = By.xpath(".//a[contains(@class, 'n-t bold')]");

    public GuestCard(WebElement element) {
        this.element = element;
        this.guestName = Utils.getInnerText(element, relativeGuestNameLocator);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getGuestName() {
        return guestName;
    }
}
