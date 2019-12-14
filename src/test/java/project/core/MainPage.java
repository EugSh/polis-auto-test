package project.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.middle_column.FeelingFrame;

import static org.junit.Assert.assertTrue;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]")),
                maxCheckTime,
                msBetweenCheck));
    }

    public void postFeeling(final String text) throws InterruptedException {
//        click(By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]"));
//        Thread.sleep(200);
////        return new FeelingFrame();
////        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.name("st.layer.fieldFeelingText")),
////                maxCheckTime,
////                msBetweenCheck));
//        click(By.xpath(".//*[contains(@alias,'dreamy')]/div[2]"));

    }
}
