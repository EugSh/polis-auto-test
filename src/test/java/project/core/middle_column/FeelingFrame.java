package project.core.middle_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class FeelingFrame extends BasePage {

    FeelingFrame(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]")),
                maxCheckTime,
                msBetweenCheck));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.layer.fieldFeelingText")),
                maxCheckTime,
                msBetweenCheck));
    }

    public void chooseFeelingAndPost(final String feelingAlias, final String message) {
        click(By.xpath(".//*[contains(@alias,'" + feelingAlias + "')]/div[2]"));
        type(message, By.name("st.layer.fieldFeelingText"));
        click(By.xpath((".//*[contains(@class,'feeling-layer_form')]//*[contains(@class,'button-pro')]")));
    }
}
