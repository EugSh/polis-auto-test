package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class GroupProfilePage extends BasePage {
    private static final By participantBtnLocator = By.xpath(".//*[contains(@data-l,'t,join')]/div");
    private static final By leaveGroupBtnLocator = By.xpath(".//*[contains(@data-l,'t,join')]//a[contains(@class, 'dropdown_i')]");

    /**
     * Страница профиля группы.
     *
     * @param driver {@link WebDriver}
     */
    public GroupProfilePage(WebDriver driver) {
        super(driver);
    }

    public GroupProfilePage clickParticipant() {
        click(participantBtnLocator);
        return this;
    }

    public GroupProfilePage clickLeaveGroup() {
        click(leaveGroupBtnLocator);
        return this;
    }

    @Override
    protected void check() {
    }
}
