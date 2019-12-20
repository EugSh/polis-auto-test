package project.auto.test.core.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;

import java.util.ArrayList;
import java.util.List;

public class ToolBarItem {
    private final WebElement element;

    private ToolBarItem(final WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }

    public static List<ToolBarItem> wrapTolBar(final List<WebElement> elements) {
        final List<ToolBarItem> items = new ArrayList<>();
        for (final WebElement element :
                elements) {
            items.add(new ToolBarItem(element));
        }
        return items;
    }

}
