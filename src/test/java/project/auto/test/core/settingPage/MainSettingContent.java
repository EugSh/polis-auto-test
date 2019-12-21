package project.auto.test.core.settingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainSettingContent extends BasePage {
    private final List<SettingItem> items;
    private final By settingItemLocator = By.xpath(".//*[contains(@class,'user-settings')]/a");

    /**
     * Класс, который содержит в себе основные настроки:
     * Личные данные, Пароль, Номер телефона, Двойная защита, Адрес элю почты,
     * Язык, Ссыла на профиль. Каждый элемент можно обернуть в {@link SettingItem}
     *
     * @param driver {@link WebDriver}
     */
    public MainSettingContent(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(SettingItem::new, driver.findElements(settingItemLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(settingItemLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    /**
     * Выбрать Личные настройки.
     *
     * @return {@link PersonalInfoLayer} слой для изменения личных настроек.
     */
    public PersonalInfoLayer clickPersonalInfo() {
        items.get(0).click();
        return new PersonalInfoLayer(driver);
    }

    /**
     * Выбрать настройки языка.
     *
     * @return {@link LanguageLayer} слой для изменения настроек языка.
     */
    public LanguageLayer clickLanguage() {
        items.get(5).click();
        return new LanguageLayer(driver);
    }
}
