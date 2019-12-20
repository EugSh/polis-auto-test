package project.auto.test.core.settingPage;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class SettingPage extends BasePage {

    /**
     * Страница с настройками аккаунта.
     *
     * @param driver WebDriver
     */
    public SettingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    /**
     * Метод который возвращет объект для работы с центральным содержанием страницы.
     *
     * @return {@link MainSettingContent}
     */
    public MainSettingContent mainContent() {
        return new MainSettingContent(driver);
    }
}
