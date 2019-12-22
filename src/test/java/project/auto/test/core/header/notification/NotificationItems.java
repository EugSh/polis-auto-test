package project.auto.test.core.header.notification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationItems {
    private final WebElement element;

    /**
     *
     * @param element {@link WebElement}
     */
    public NotificationItems(final WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }
}
