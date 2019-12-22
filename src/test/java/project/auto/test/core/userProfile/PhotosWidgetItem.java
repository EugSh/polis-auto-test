package project.auto.test.core.userProfile;

import org.openqa.selenium.WebElement;

public class PhotosWidgetItem {
    private final WebElement element;

    public PhotosWidgetItem(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }
}
