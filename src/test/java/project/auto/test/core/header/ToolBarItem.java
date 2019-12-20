package project.auto.test.core.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;

import java.util.ArrayList;
import java.util.List;

public class ToolBarItem extends Element {
    private ToolBarItem(WebDriver driver) {
        super(driver);
    }

    public static List<ToolBarItem> wrapTolBar(final List<WebElement> elements){
        final List<ToolBarItem> items = new ArrayList<>();

        return items;
    }

}
