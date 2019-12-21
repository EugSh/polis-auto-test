package project.auto.test.core;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Utils {
    public static final String INNER_TEXT_ATTR = "innerText";
    public static final String ALIAS_ATTR = "alias";

    /**
     * Метод чтобы обернуть коллекцию WebElement элементов в коллекцию элементов типа Т.
     *
     * @param creator  интерфейс, который создает экземпляр класса T.
     * @param elements коллекция WebElement элементов.
     * @param <T>      класс, объекты которого будут содержаться в возвращаемой коллекции.
     * @return коллекцию элементов,в кторой объекты.
     */
    public static <T> List<T> wrapElements(Function<WebElement, T> creator, final Collection<WebElement> elements) {
        final List<T> items = new ArrayList<>();
        for (final WebElement element : elements) {
            items.add(creator.apply(element));
        }
        return items;
    }

    public static String getInnerText(final SearchContext element, final By locator) {
        return getAttribute(element, locator, INNER_TEXT_ATTR);
    }

    public static String getAttribute(final SearchContext element, final By locator, final String attributeName) {
        return element.findElement(locator).getAttribute(attributeName);
    }

    /**
     * Метод, чтобы в коллекции элементов elements класса Т найти индекци первого вхождения key класса R.
     *
     * @param elements     коллекция элементов, в которой нужно найти инекс первого вхождения key.
     * @param key          ключ, индекс первого вхождения которого ищется.
     * @param keyExtractor интерфейс для получения из объекта класса Т, ключа класса R для сравнения с key.
     * @param <T>          класс, которым параметризован список elements.
     * @param <R>          класс, которым параметризован key.
     * @return возвращает индекс первого вхождения key коллекцию elements, если элемент не найдет возвращается -1.
     */
    public static <T, R> int getFirstIndex(final Collection<T> elements, final R key, final Function<T, R> keyExtractor) {
        int index = 0;
        for (final T element :
                elements) {
            if (keyExtractor.apply(element).equals(key)) {
                return index;
            }
            index++;
        }
        return -1;
    }


}
