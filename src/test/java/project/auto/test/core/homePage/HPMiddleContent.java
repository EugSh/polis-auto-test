package project.auto.test.core.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import static org.junit.Assert.assertNotNull;


public class HPMiddleContent extends BasePage {
    private final By postFeelingBtnLocator = By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]");
    private final By feelingRecordLocator = By.id("hook_Block_MainFeedsNewFeed");
    private final By relativeFeelingStatusLocator = By.xpath(".//div[contains(@class, 'feeling-portlet_t __feed')]");
    private final By relativeFeelingMessageLocator = By.xpath(".//div[contains(@class, 'feeling-portlet_desc')]");
    private WebElement feelingRecord;

    public HPMiddleContent(WebDriver driver) {
        super(driver);
        feelingRecord = isElementVisible(feelingRecordLocator) ? driver.findElement(feelingRecordLocator) : null;
    }

    @Override
    protected void check() {
    }

    public FeelingLayer clickFeeling() {
        click(postFeelingBtnLocator);
        return new FeelingLayer(driver);
    }

    public String getFeelingStatus() {
        assertNotNull("Невозможно получить статус поста настроения, тк нет поста с настроением.", feelingRecord);
        return Utils.getInnerText(feelingRecord, relativeFeelingStatusLocator);
    }

    public String getFeelingMessage() {
        assertNotNull("Невозможно получить текст поста настроения, тк нет поста с настроением.", feelingRecord);
        return Utils.getInnerText(feelingRecord, relativeFeelingMessageLocator);
    }

}
