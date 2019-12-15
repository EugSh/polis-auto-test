package project.core.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import project.core.BasePage;

public class ToolBarDropDown extends BasePage {
    private static final By UCARD_MINI_LOCATOR = By.className("ucard-mini_cnt_i");
    private static final By T_SETTINGS_LOCATOR = By.xpath(".//*[contains(@data-l,'t,settings')]");
    private static final By USER_SETTINGS_PROFILE_LOCATOR = By.xpath(".//div[@class='user-settings __profile']/a");
    private static final By FIELD_NAME_LOCATOR = By.id("field_name");
    private static final By BUTTON_CLOSE_LOCATOR = By.id("buttonId_button_close");
    private static final By TOOLBAR_ACCOUNTS_MENU_LOCATOR = By.xpath(".//div[@class='toolbar_accounts-menu']/ul/li[5]/a");
    private static final By LOGOUT_LOCATOR = By.xpath(".//*[contains(@data-l,'t,logoutCurrentUser')]");
    private static final By T_CONFIRM_LOCATOR = By.xpath(".//*[contains(@data-l,'t,confirm')]");

    ToolBarDropDown(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
    }

    public String clickFirstLastName() {
        return getInnerText(UCARD_MINI_LOCATOR);
    }

    public void clickSettingAndChangeName(final String newName) {
        click(T_SETTINGS_LOCATOR);
        List<WebElement> l = driver.findElements(USER_SETTINGS_PROFILE_LOCATOR);
        l.get(0).click();
        type(newName, FIELD_NAME_LOCATOR);
        confirm();
        click(BUTTON_CLOSE_LOCATOR);
    }

    public void changeLanguage(final String language) {
        List<WebElement> l = driver.findElements(TOOLBAR_ACCOUNTS_MENU_LOCATOR);
        l.get(0).click();
        click(By.xpath(".//div[@class='sel-lang_list']/a[text()[contains(.,'" + language + "')]]"));
    }

    public void exit() {
        click(LOGOUT_LOCATOR);
        confirm();
    }

    private void confirm() {
        click(T_CONFIRM_LOCATOR);
    }

    public String currentLanguage(){
        List<WebElement> l = driver.findElements(TOOLBAR_ACCOUNTS_MENU_LOCATOR);
        return l.get(0).findElement(By.xpath("./div/span")).getAttribute("innerText");
    }
}
