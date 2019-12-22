package project.auto.test.core.header.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class DialogItem {
    private final WebElement element;
    private final String dialogName;
    private static final By DIALOG_NAME_LOCATOR = By.xpath(".//div[contains(@class, 'chats_i_h ellip')]");
    private static final By COMMENTS_ADD_CONTROLS_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-controls')]/button");
    private static final By T_TA_LOCATOR = By.xpath(".//*[contains(@data-l,'t,ta')]");
    private static final By MSG_LOCATOR = By.xpath(".//div[contains(@class, 'msg_tx_cnt')]/span");
    private final String text = "Hello! How are you?";

    public DialogItem(WebElement element) {
        this.element = element;
        this.dialogName = Utils.getInnerText(element, DIALOG_NAME_LOCATOR);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getDialogName() {
        return dialogName;
    }

    public void textMSG(String text) {
        element.findElement(T_TA_LOCATOR).sendKeys(text);
    }

    public DialogItem clickSend() {
        element.findElement(COMMENTS_ADD_CONTROLS_LOCATOR).click();
        return this;
    }

    public String getLastMessage() {
        return Utils.getInnerText(element, MSG_LOCATOR);
    }

    public DialogItem clickDialogItem() {
        element.click();
        return this;
    }
}
