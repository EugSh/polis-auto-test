package project.auto.test.core.settingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.auto.test.BasePage;

public class PersonalInfoLayer extends BasePage {
    //TODO: сделать javadoc и логирование
    private final By inputNameLocator = By.name("fr.name");
    private final By saveBtnLocator = By.xpath("//*[contains(@data-l,'t,confirm')]");
    private final By closeBtnLocator = By.id("buttonId_button_close");

    /**
     * Объект представляет собой слой, на котором можно изменить персональную информацию о пользователе:
     * Имя, Фамилия, Дата рождения, Пол, Город проживания, Родной город.
     * Так же можно сохранить изменения и отменить их.
     *
     * @param driver {@link WebDriver}
     */
    public PersonalInfoLayer(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
    }

    /**
     * Вводим в поле Имя, переданное в качестве параметра новое имя.
     *
     * @param newName {@link String} именя, но которое хотим поменять
     * @return {@link PersonalInfoLayer} Возвращаем this, потому что остались на том же слое.
     */
    public PersonalInfoLayer changeNameTo(final String newName) {
        type(newName, inputNameLocator);
        return this;
    }

    /**
     * Сохраняем сделанне изменения, для этого необходимо нажать на кнопку Сохранить,
     * а затем в окошке,где уведомляют от том, что ваши личные данные были изменены,
     * нажать Закрыть.
     *
     * @return {@link SettingPage} Возвращаем объект классса SettingPage, тк после сохранения изменени
     * мы возвращаемся именно на эту страницу
     */
    public SettingPage saveChanges() {
        click(saveBtnLocator);
        click(closeBtnLocator);
        return new SettingPage(driver);
    }
}
