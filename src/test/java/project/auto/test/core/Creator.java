package project.auto.test.core;

import org.openqa.selenium.WebElement;

public interface Creator<T> {
    T createItem(final WebElement element);
}
