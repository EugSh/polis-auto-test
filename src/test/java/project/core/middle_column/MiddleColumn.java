package project.core.middle_column;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class MiddleColumn extends BasePage {
    public MiddleColumn(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]")),
                maxCheckTime,
                msBetweenCheck));
    }

    public FeelingFrame postFeeling() {//throws InterruptedException {
        click(By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]"));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new FeelingFrame(driver);
    }

    public String getFeelingPostText() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'feed-w')][1]//*[contains(@class,'feeling-portlet_desc')]/div")),
                maxCheckTime,
                msBetweenCheck));
        return getInnerText(By.xpath(".//*[contains(@class,'feed-w')][1]//*[contains(@class,'feeling-portlet_desc')]/div"));
    }

    //click(By.xpath(".//*[contains(@class,'feed-w')][1]//*[contains(@class,'feeling-portlet_desc')]/div"));
}
