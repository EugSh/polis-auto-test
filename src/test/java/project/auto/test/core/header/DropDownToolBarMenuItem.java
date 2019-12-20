package project.auto.test.core.header;

import org.openqa.selenium.WebElement;
public class DropDownToolBarMenuItem {
    private final WebElement element;

    /**
     * Представляем собой обертку над элементами выпадающего меню,
     * которые в русской локализации следующие:
     * Купить Оки, Закрыть профиль, Включить неведимку,
     * Изменить настройки, Русский(язык), Сервисы Mail.ru Group, Помощь.
     *
     * @param element {@link WebElement}
     */
    public DropDownToolBarMenuItem(final WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }
}
