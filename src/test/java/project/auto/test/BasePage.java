package project.auto.test;

import com.google.common.base.Preconditions;
import com.sun.tools.javac.util.Assert;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    protected final int maxCheckTime = 10;
    protected final int msBetweenCheck = 1000;
    protected final String homePageURL = "https://ok.ru";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    protected void type(String text, By locator) {
        if (isElementPresent(locator)) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        //TODO: другое сообщение
        throw new AssertionFailedError("123");
    }

    protected String getInnerText(By locator) {
        if (isElementPresent(locator)){
            return driver.findElement(locator).getAttribute("innerText");
        }
        //TODO: Изменить сообщение об отсутствии элемента и сделать нормальный assert
        throw new AssertionFailedError("message");
    }

    protected void click(By locator) {
        if (isElementPresent(locator)) {
            driver.findElement(locator).click();
            return;
        }
        //TODO: изменить сообщение об отсутсвии элемента
        throw new AssertionFailedError("message");
    }


    protected boolean isElementVisible(By by) {
        return explicitWait(ExpectedConditions.visibilityOfElementLocated(by), maxCheckTime, msBetweenCheck);
    }

    protected boolean isElementPresent(By by) {
        return explicitWait(ExpectedConditions.presenceOfElementLocated(by), maxCheckTime, msBetweenCheck);
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void goToHomePage() {
        driver.get(homePageURL);
    }

    public boolean explicitWait(final ExpectedCondition<?> condition, long maxCheckTimeInSeconds, long millisecondsBetweenChecks) {
        Preconditions.checkNotNull(condition, "Condition must be not null");
        Preconditions.checkArgument(TimeUnit.MINUTES.toSeconds(3) > maxCheckTimeInSeconds, "Max check time in seconds should be less than 3 minutes");
        checkConditionTimeouts(maxCheckTimeInSeconds, millisecondsBetweenChecks);
        try {
            // сбрасываем ожидания в 0
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            // создаем эксплицитное ожидание
            WebDriverWait explicitWait = new WebDriverWait(driver, maxCheckTimeInSeconds, millisecondsBetweenChecks);
            // проверяем его
            explicitWait.until(condition);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            // при любом результате восстанавливаем значение имплицитного ожидания по умолчанию
            if (driver != null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                throw new IllegalArgumentException("Driver shouldnt be null");
            }
        }
    }

    /**
     * Проверяет таймаут провекри условия и интервал между проверками: таймаут
     * должен быть больше нуля, интервал проверки должен быть больше нуля
     * интервал между проверками умноженный на 1000 должен быть меньше таймаута
     * проверки
     *
     * @param maxCheckTimeInSeconds     максимальное время проверки в секундах
     * @param millisecondsBetweenChecks интервал между проверками в милисекундах
     */
    private void checkConditionTimeouts(long maxCheckTimeInSeconds, long millisecondsBetweenChecks) {
        Preconditions.checkState(maxCheckTimeInSeconds > 0, "maximum check time in seconds must be not 0");
        Preconditions.checkState(millisecondsBetweenChecks > 0, "milliseconds count between checks must be not 0");
        Preconditions.checkState(millisecondsBetweenChecks < (maxCheckTimeInSeconds * 1000),
                "Millis between checks must be less than max seconds to wait");
    }
}