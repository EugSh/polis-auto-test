package project.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class LeftColumn extends BasePage1 {

    public LeftColumn(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.id("leftColumn")),
                10,
                1000));
        /*assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,userFriend')]")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,userAltGroup')]")),
                10,
                1000));*/
    }

    public Subscriptions checkSubscriptions() {
        click(By.xpath(".//*[contains(@data-l,'t,friends')]"));
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.check();
        return subscriptions;
    }

    public class Subscriptions {
        public Subscriptions() {
        }

        public void check() {
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Мои подписки')]")),
                    10,
                    1000));
        }

        public boolean unsubscribe() {
            click(By.xpath("//div[contains(text(), 'Мои подписки')]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.className("user-grid-card_avatar"))).build().perform();
            click(By.xpath(".//span[contains(text(),'Отписаться')]"));
            click(By.id("hook_FormButton_button_add_confirm"));
            return driver.findElement(By.xpath("//span[contains(text(), '1')]")).isDisplayed();
        }
    }
}
