package project.auto.test.core;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static <T> List<T> wrapElemnts(Creator<T> creator, final List<WebElement> elements) {
        final List<T> items = new ArrayList<>();
        for (final WebElement element : elements) {
            items.add(creator.createItem(element));
        }
        return items;
    }

    public static String getInnerText(final SearchContext element, final By locator) {
        return element.findElement(locator).getAttribute("innerText");
    }
}
