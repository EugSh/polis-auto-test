package project.core.left_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class LeftColumn extends BasePage {
    public LeftColumn(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,userAltGroup')]")),
                maxCheckTime,
                msBetweenCheck));
    }

    public GroupsPage groups(){
        click(By.xpath(".//*[contains(@data-l,'t,userAltGroup')]"));
        return new GroupsPage(driver);
    }
}
