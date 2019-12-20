package project.auto.test.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.auto.test.BasePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.core.settingPage.SettingPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DropDownToolBar extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(DropDownToolBar.class);
    private final By logoutLocator = By.xpath(".//*[contains(@data-l,'t,logoutCurrentUser')]");
    private final By toolBarItems = By.xpath(".//*[contains(@data-l,'newbieCContainer,user_toolbar')]//li");
    private final By uCardMini = By.className("ucard-mini_cnt_i");
    private final List<DropDownToolBarMenuItem> items;

    /**
     * Выпадающее меню, где можно получить Имя и Фамилию пользователя,
     * выйти из портала ОК
     * и нажать на один из элементов списке,
     * тк элементы похожи их можно обернуть в объект {@link DropDownToolBarMenuItem}.
     *
     * @param driver WebDriver
     */
    public DropDownToolBar(WebDriver driver) {
        super(driver);
        log.info("Проверяем, что элементы в выпадающем списке прогружен.");
        check();
        log.info("Оборачиваем элементы в выпадающем списке.");
        items = DropDownToolBarMenuItem.wrapMenu(driver.findElements(toolBarItems));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfAllElementsLocatedBy(toolBarItems),
                maxCheckTime,
                msBetweenCheck));
    }

    public LoginPage logOut() {
        log.info("Нажимаем на кнопку Выйти.");
        click(logoutLocator);
        log.info("Возвращаем объект класса LoginPage, тк после выхода открывается имено эта страница.");
        return new LoginPage(driver);
    }

    public String getName() {
        log.info("Возвращаем Имя и Фамилию пользователя.");
        return getInnerText(uCardMini);
    }

    public SettingPage clickSetting() {
        log.info("Нажимаем на кнопку Изменить настройки, тк она четвертая по счету, " +
                "то нужно достать соответсвующий элемент из коллекции.");
        items.get(3).click();
        return new SettingPage(driver);
    }

}
