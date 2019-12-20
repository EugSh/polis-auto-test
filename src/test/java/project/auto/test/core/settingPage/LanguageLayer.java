package project.auto.test.core.settingPage;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LanguageLayer extends BasePage {
    private final List<LanguageItem> items;
    private final By languegesLocator = By.xpath(".//*[contains(@class,'sel-lang_list')]/a");
    private final By currentLanguageLocator = By.xpath(".//*[contains(@class,'sel-lang_list')]/div");

    /**
     * Слой для изменения настроек языка портала. Оборачиваем доступные языка в {@link LanguageItem}.
     *
     * @param driver {@link WebDriver}
     */
    public LanguageLayer(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElemnts(LanguageItem::new, driver.findElements(languegesLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(languegesLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    /**
     * @return {@link String} возвращаем текущий язык портала.
     */
    public String getCurrentLanguage() {
        return getInnerText(currentLanguageLocator);
    }

    /**
     * Изменяем язык портала на язык, который указан в качестве параметров
     *
     * @param languageName язык на который хотим поменять локализацию портала
     * @return {@link SettingPage} возвращаем объект класса SettingPage,
     * тк после изменения языка попадаем на эту страницу.
     */
    private SettingPage changeLanguageTo(final String languageName) {
        items.get(getLangIndex(languageName))
                .click();
        return new SettingPage(driver);
    }

    private int getLangIndex(final String name) {
        int index = 0;
        for (final LanguageItem item : items) {
            if (item.getLangName().equals(name)) {
                return index;
            }
            index++;
        }
        throw new AssertionFailedError("Указанный вами язык (" + name + ")локализации не найден среди доступных");
    }

}
