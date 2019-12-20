package project.auto.test.core.header;

import org.openqa.selenium.WebElement;
import project.auto.test.Element;

import java.util.ArrayList;
import java.util.List;

public class DropDownToolBarMenuItem {
    private final WebElement element;

    /**
     * Представляем собой обертку над элементами выпадающего меню,
     * которые в русской локализации следующие:
     * Купить Оки, Закрыть профиль, Включить неведимку,
     * Изменить настройки, Русский(язык), Сервисы Mail.ru Group, Помощь.
     *
     * @param element
     */
    private DropDownToolBarMenuItem(final WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public static List<DropDownToolBarMenuItem> wrapMenu(final List<WebElement> elements) {
        final List<DropDownToolBarMenuItem> items = new ArrayList<>();
        for (final WebElement element : elements) {
            items.add(new DropDownToolBarMenuItem(element));
        }
        return items;
    }

}
