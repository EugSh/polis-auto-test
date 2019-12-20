package project.auto.test.core.header;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownToolBarMenuItem {
    private DropDownToolBarMenuItem() {

    }

    public static List<DropDownToolBarMenuItem> wrapMenu(final List<WebElement> elements) {
        final List<DropDownToolBarMenuItem> items = new ArrayList<>();
        for (final WebElement element :
                elements) {

        }
        return items;
    }

}
