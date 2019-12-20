package project.auto.test.core.settingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class SettingItem {
    private final By relativeInnerTextLocator = By.xpath("/div[contains(@class,'user-settings_i_n')]");
    private final WebElement element;
    private final String title;

    /**
     * Объект, который представляет из себя обертку над элементами основних настроек.
     *
     * @param element {@link WebElement}
     */
    public SettingItem(WebElement element) {
        this.element = element;
        title = Utils.getInnerText(element, relativeInnerTextLocator);
    }

    /**
     * @return {@link String} заголовок текущего элемента настроек.
     */
    public String getTitle() {
        return title;
    }

    public void click() {
        element.click();
    }
}
