package project.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("toolbar")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("it")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("toolbar_search_lupa")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("toolbar_nav_i_ic")),
                10,
                1000));
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,friends')]")),
                10,
                1000));

    }

    public PostInvite doSearch(String loginBot) {
        type(loginBot, By.className("it"));
        click(By.className("toolbar_search_lupa"));
        PostInvite postInvite = new PostInvite();
        postInvite.check();
        return postInvite;
    }

    public Notifications checkNotifications() {
        click(By.xpath(".//*[contains(@data-l,'t,notifications')]"));
        Notifications notifications = new Notifications();
        notifications.check();
        return notifications;
    }

    public void deleteFriend() {
        click(By.xpath(".//*[contains(@data-l,'t,friends')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("user-grid-card_avatar"))).build().perform();
        click(By.xpath(".//span[contains(text(),'Прекратить дружбу')]"));
        click(By.xpath(".//*[contains(@data-l,'t,confirm')]"));
        click(By.id("hook_FormButton_button_close"));
    }

    public void cancelSubscriptions() {

    }

    public class Notifications {
        public Notifications() {
        }

        private void check() {
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("notif_tx")),
                    10,
                    1000));
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,btn_accept')]")),
                    10,
                    1000));

        }

        public boolean agree() {
            click(By.xpath(".//*[contains(@data-l,'t,btn_accept')]"));
            return driver.findElement(By.xpath("//div[contains(text(), 'и вы теперь друзья')]")).isDisplayed();
        }
    }

    public class PostInvite {
        public PostInvite() {
        }

        private void check() {
            /*assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("gs_result_list")),
                    10,
                    1000));
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("hookBlock")),
                    10,
                    1000));*/
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Добавить в друзья')]")),
                    10,
                    1000));

        }

        public boolean addFriend() {
            click(By.xpath("//span[contains(text(), 'Добавить в друзья')]"));
            return driver.findElement(By.xpath("//span[contains(text(), 'Запрос отправлен')]")).isDisplayed();
        }
    }
}

