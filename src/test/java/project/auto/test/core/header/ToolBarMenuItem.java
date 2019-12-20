package project.auto.test.core.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ToolBarMenuItem {
    private ToolBarMenuItem() {

    }

    public static List<ToolBarMenuItem> wrapMenu(final List<WebElement> elements) {
        final List<ToolBarMenuItem> items = new ArrayList<>();
        for (final WebElement element :
                elements) {

        }
        return items;
    }

}
