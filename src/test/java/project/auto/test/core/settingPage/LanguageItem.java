package project.auto.test.core.settingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.auto.test.core.Utils;

public class LanguageItem {
    private static final By relativeLangNameLocator = By.xpath(".");
    private final WebElement element;
    private final String langName;

    /**
     * Элемент представляющий собой, один из доступных в списке языков.
     *
     * @param element {@link WebElement}
     */
    public LanguageItem(WebElement element) {
        this.element = element;
        this.langName = Utils.getInnerText(element, relativeLangNameLocator);
    }

    /**
     * @return {@link String} возвращает имя языка текущего элемента.
     */
    public String getLangName() {
        return langName;
    }

    public void click() {
        element.click();
    }

    @Override
    public String toString() {
        return "LanguageItem{" +
                "langName='" + langName + '\'' +
                '}';
    }
}
