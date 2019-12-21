package project.auto.test.core;

import com.sun.tools.javac.util.StringUtils;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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
     * Поумолчанию сравнивает строки целиком.
     *
     * @param elements     коллекция элементов, в которой нужно найти инекс первого вхождения key.
     * @param key          ключ, индекс первого вхождения которого ищется.
     * @param keyExtractor интерфейс для получения из объекта класса Т, ключа класса R для сравнения с key.
     * @param <T>          класс, которым параметризован список elements.
     * @param <R>          класс, которым параметризован key.
     * @return возвращает индекс первого вхождения key коллекцию elements, если элемент не найдет возвращается -1.
     */
    public static <T, R> int getFirstIndex(final Collection<T> elements, final R key, final Function<T, R> keyExtractor) {
        return getFirstIndex(elements, key, keyExtractor, Comparator.comparing(R::toString));
    }

    /**
     * Метод, чтобы в коллекции элементов elements класса Т найти индекци первого вхождения key класса R.
     * Для сравнения используется компаратор.
     *
     * @param elements     коллекция элементов, в которой нужно найти инекс первого вхождения key.
     * @param key          ключ, индекс первого вхождения которого ищется.
     * @param keyExtractor интерфейс для получения из объекта класса Т, ключа класса R для сравнения с key.
     * @param comparator   компаратор для сравнения двух ключей.
     * @param <T>          класс, которым параметризован список elements.
     * @param <R>          класс, которым параметризован key.
     * @return возвращает индекс первого вхождения key коллекцию elements, если элемент не найдет возвращается -1.
     */
    public static <T, R> int getFirstIndex(final Collection<T> elements, final R key, final Function<T, R> keyExtractor, Comparator<R> comparator) {
        int index = 0;
        for (final T element :
                elements) {
            if (comparator.compare(key, keyExtractor.apply(element)) == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }


}
