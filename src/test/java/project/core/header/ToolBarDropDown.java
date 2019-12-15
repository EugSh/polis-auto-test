package project.core.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import project.core.BasePage;

public class ToolBarDropDown extends BasePage {
    ToolBarDropDown(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public String clickFirstLastName() {
        return getInnerText(By.className("ucard-mini_cnt_i"));
    }

    public void clickSettingAndChangeName(final String newName) {
        click(By.xpath(".//*[contains(@data-l,'t,settings')]"));
        List<WebElement> l = driver.findElements(By.xpath(".//div[@class='user-settings __profile']/a"));
        l.get(0).click();
        type(newName, By.id("field_name"));
        confirm();
        click(By.id("buttonId_button_close"));
    }

    public void changeLanguage(final String language) {
        List<WebElement> l = driver.findElements(By.xpath(".//div[@class='toolbar_accounts-menu']/ul/li[5]/a"));
        l.get(4).click();
        click(By.xpath(".//div[@class='sel-lang_list']/a[text()[contains(.,'" + language + "')]]"));
    }

    public void exit() {
        click(By.xpath(".//*[contains(@data-l,'t,logoutCurrentUser')]"));
        confirm();
    }

    private void confirm() {
        click(By.xpath(".//*[contains(@data-l,'t,confirm')]"));
    }
}
