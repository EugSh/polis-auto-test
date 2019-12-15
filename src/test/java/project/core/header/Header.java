package project.core.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    public ToolBarDropDown clickToolBarDropDown() {
        click(By.className("toolbar_dropdown_w"));
        return new ToolBarDropDown(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("toolbar_dropdown_w")),
                maxCheckTime,
                msBetweenCheck));
    }

}
