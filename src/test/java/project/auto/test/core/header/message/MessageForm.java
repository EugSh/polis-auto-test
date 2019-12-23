package project.auto.test.core.header.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class MessageForm extends BasePage {
    private static final By COMMENTS_ADD_CONTROLS_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-controls')]/button");
    private static final By T_TA_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-itx')]//div[contains(@data-l, 't,ta')]");//(".//*[contains(@class,'comments_add-itx')]");
    private static final By MSG_LOCATOR = By.xpath(".//div[contains(@class, 'msg_tx_cnt')]/span");

    public MessageForm(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public MessageForm textMSG(String text) {
        driver.findElement(T_TA_LOCATOR).sendKeys(text);
        return this;
    }

    public MessageForm clickSend() {
        click(COMMENTS_ADD_CONTROLS_LOCATOR);
        return this;
    }

    public String getLastMessage() {
        return getInnerText(MSG_LOCATOR);
    }
}
