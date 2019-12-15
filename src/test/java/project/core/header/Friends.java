package project.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Friends extends BasePage {

    private static final By ADD_FRIEND_LOCATOR = By.xpath("//span[contains(text(), 'Добавить в друзья')]");
    private static final By INVITE_SENT_LOCATOR = By.xpath("//span[contains(text(), 'Запрос отправлен')]");
    private static final By BUTTON_CLOSE_LOCATOR = By.id("hook_FormButton_button_close");
    private static final By T_CONFIRM_LOCATOR = By.xpath(".//*[contains(@data-l,'t,confirm')]");
    private static final By USER_GRID_CARD_AVATAR_LOCATOR = By.className("user-grid-card_avatar");
    private static final By STOP_FRIENDSHIP_LOCATOR = By.xpath(".//span[contains(text(),'Прекратить дружбу')]");


    public Friends(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        /*assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("gs_result_list")),
                    10,
                    1000));
            assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("hookBlock")),
                    10,
                    1000));*/
//        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Добавить в друзья')]")),
//                10,
//                1000));

    }

    public boolean addFriend() {
        click(ADD_FRIEND_LOCATOR);
        return driver.findElement(INVITE_SENT_LOCATOR).isDisplayed();
    }

    public boolean deleteFriend() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(USER_GRID_CARD_AVATAR_LOCATOR)).build().perform();
        click(STOP_FRIENDSHIP_LOCATOR);
        click(T_CONFIRM_LOCATOR);
        return driver.findElement(BUTTON_CLOSE_LOCATOR).isDisplayed();
    }

    public Friends goToProfile(){
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath((".//*[contains(@class,'ellip')]/a[contains(@class,'gs_result_i_t_name')]"))),
                maxCheckTime,
                msBetweenCheck));
        click(By.xpath((".//*[contains(@class,'ellip')]/a[contains(@class,'gs_result_i_t_name')]")));
        return this;
    }

    public void klassPhoto(){
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class,'lcTc_avatar')]//span[contains(@class,'widget_cnt')]")),
                maxCheckTime,
                msBetweenCheck));
        click(By.xpath(".//div[contains(@class,'lcTc_avatar')]//span[contains(@class,'widget_cnt')]"));
    }
}
