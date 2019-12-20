package project.auto.test.core.header;

import org.openqa.selenium.WebElement;

public class ToolBarItem {
    private final WebElement element;

    /**
     *
     * @param element {@link WebElement}
     */
    public ToolBarItem(final WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }
}
