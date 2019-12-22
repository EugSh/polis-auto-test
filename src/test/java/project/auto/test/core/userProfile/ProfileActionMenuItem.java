package project.auto.test.core.userProfile;

import org.openqa.selenium.WebElement;

public class ProfileActionMenuItem {
    private final WebElement element;

    public ProfileActionMenuItem(final WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }
}
