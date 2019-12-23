package project.auto.test.core.header.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;
import project.auto.test.core.Utils;

public class DialogItem extends Element {
    private final WebElement element;
    private final String dialogName;
    private static final By DIALOG_NAME_LOCATOR = By.xpath(".//div[contains(@class, 'chats_i_h ellip')]");
    private static final By COMMENTS_ADD_CONTROLS_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-controls')]/button");
    private static final By T_TA_LOCATOR = By.xpath(".//*[contains(@class,'comments_add-itx')]");
    private static final By MSG_LOCATOR = By.xpath(".//div[contains(@class, 'msg_tx_cnt')]/span");

    public DialogItem(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.dialogName = Utils.getInnerText(element, DIALOG_NAME_LOCATOR);
    }

    /**
     * @return {@link String} возвращает имя текущего элемента.
     */
    public String getDialogName() {
        return dialogName;
    }

    public MessageForm clickDialogItem() {
        element.click();
        return new MessageForm(driver);
    }
}
