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
    private static final By languegesLocator = By.xpath(".//*[contains(@class,'sel-lang_list')]/a");
    private static final By currentLanguageLocator = By.xpath(".//*[contains(@class,'sel-lang_list')]/div");
    private final List<LanguageItem> languageItems;

    /**
     * Слой для изменения настроек языка портала. Оборачиваем доступные языка в {@link LanguageItem}.
     *
     * @param driver {@link WebDriver}
     */
    public LanguageLayer(WebDriver driver) {
        super(driver);
        check();
        languageItems = Utils.wrapElements(LanguageItem::new, driver.findElements(languegesLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(languegesLocator),
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
    public SettingPage changeLanguageTo(final String languageName) {
        final int langIndex = Utils.getFirstIndex(languageItems, languageName, LanguageItem::getLangName);
        if (langIndex < 0) {
            throw new AssertionFailedError("Указанный вами язык локализации (" + languageName + ") не найден среди доступных." + languageItems);
        }
        languageItems.get(langIndex)
                .click();
        return new SettingPage(driver);
    }
}
