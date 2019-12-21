package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class GroupProfilePage extends BasePage {
    private final By participantBtnLocator = By.xpath(".//*[contains(@data-l,'t,join')]/div");
    private final By leaveGroupBtnLocator = By.xpath(".//*[contains(@data-l,'t,join')]//a[contains(@class, 'dropdown_i')]");

    public GroupProfilePage(WebDriver driver) {
        super(driver);
    }

    public GroupProfilePage exitFromGroup() {
        click(participantBtnLocator);
        click(leaveGroupBtnLocator);
        throw new UnsupportedOperationException();
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
