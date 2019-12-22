package project.auto.test;

import com.google.common.base.Preconditions;
import com.sun.tools.javac.util.Assert;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.auto.test.core.homePage.HomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class BasePage extends Element {
    protected static final String homePageURL = "https://ok.ru";

    public BasePage(WebDriver driver) {
        super(driver);
        check();
    }

    protected abstract void check();

    public void refresh() {
        driver.navigate().refresh();
    }

    public static HomePage goToHomePage(final WebDriver driver) {
        driver.get(homePageURL);
        return new HomePage(driver);
    }
}