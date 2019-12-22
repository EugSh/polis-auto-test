package project.auto.test.core.guestPage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class GuestsPage extends BasePage {

    public GuestsPage(WebDriver driver) {
        super(driver);
        check();
    }

    @Override
    protected void check() {

    }

    public GuestsList getGuestList() {
        return new GuestsList(driver);
    }
}
