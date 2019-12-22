package project.auto.test;

import org.openqa.selenium.*;
import project.auto.test.core.homePage.HomePage;

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