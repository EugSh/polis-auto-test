package project.auto.test.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.core.settingPage.SettingPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DropDownToolBar extends BasePage {
    private static final By logoutLocator = By.xpath(".//*[contains(@data-l,'t,logoutCurrentUser')]");
    private static final By toolBarItems = By.xpath(".//*[contains(@data-l,'newbieCContainer,user_toolbar')]//li/a");
    private static final By uCardMini = By.className("ucard-mini_cnt_i");
    private final List<DropDownToolBarMenuItem> items;

    /**
     * Выпадающее меню, где можно получить Имя и Фамилию пользователя,
     * выйти из портала ОК
     * и нажать на один из элементов списке,
     * тк элементы похожи их можно обернуть в объект {@link DropDownToolBarMenuItem}.
     *
     * @param driver {@link WebDriver}
     */
    public DropDownToolBar(WebDriver driver) {
        super(driver);
        check();
        items = Utils.wrapElements(DropDownToolBarMenuItem::new, driver.findElements(toolBarItems));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(toolBarItems),
                maxCheckTime,
                msBetweenCheck));
    }

    /**
     * Нажимаем на кнопку Выйти.
     *
     * @return {@link LoginPage}
     */
    public LoginPage logOut() {
        click(logoutLocator);
        return new LoginPage(driver);
    }

    /**
     * Возвращаем Имя и Фамилию пользователя.
     *
     * @return {@link String} "Имя Фамилия"
     */
    public String getName() {
        return getInnerText(uCardMini);
    }

    /**
     * Нажимаем на кнопку Изменить настройки, тк она четвертая по счету,
     * то нужно достать соответсвующий элемент из коллекции.
     *
     * @return {@link SettingPage}
     */
    public SettingPage clickSetting() {
        items.get(3).click();
        return new SettingPage(driver);
    }

}
