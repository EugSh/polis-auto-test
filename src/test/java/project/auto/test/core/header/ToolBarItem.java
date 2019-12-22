package project.auto.test.core.header;

import org.openqa.selenium.WebElement;

public class ToolBarItem {
    private final WebElement element;

    /**
     * Элемент верхней панели.
     * Сообщения, Обсуждения, Оповещения, Друзья, Гости, События, Видео, Музыка.
     *
     * @param element {@link WebElement}
     */
    public ToolBarItem(final WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }
}
