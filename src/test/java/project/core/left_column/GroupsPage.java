package project.core.left_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GroupsPage extends BasePage {
    GroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.query")),
                maxCheckTime,
                msBetweenCheck));
    }

    public void searchAndJoinToGroup(final String groupName) {
        type(groupName, By.name("st.query"));
//        click(By.xpath(".//*[contains(@class,'search-input_control')]"));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,visit')][text()[contains(.,'" + groupName + "')]]")),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,join')]")),
                maxCheckTime,
                msBetweenCheck));
        click(By.xpath(".//*[contains(@data-l,'t,join')]"));
//        By.xpath(".//*[contains(@class,'caption')]//*[contains(@class,'join-group-result')]")
    }

    public boolean checkThatJoined(final String groupName) {
        return explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@alt,'" + groupName + "')]")),
                maxCheckTime,
                msBetweenCheck);
    }

    public void quitFromGroup(final String groupName){
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@alt,'" + groupName + "')]")),
                maxCheckTime,
                msBetweenCheck));
        click(By.xpath(".//*[contains(@alt,'" + groupName + "')]"));
        click(By.xpath(".//*[contains(@class,'main-content-header_data_main-menu')]//span[text()[contains(.,'Участник')]]"));
        click(By.xpath(".//*[contains(@class,'main-content-header_data_main-menu')]//div[text()[contains(.,'Покинуть')]]"));
    }

}
