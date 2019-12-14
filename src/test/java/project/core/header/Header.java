package project.core.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    public ToolBarDropDown clickToolBarDropDown() {
        click(By.className("toolbar_dropdown_w"));
        return new ToolBarDropDown();
    }

    public void feed(){
        click(By.id("toolbar_logo_id"));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.presenceOfElementLocated(By.className("toolbar_dropdown_w")),
                maxCheckTime,
                msBetweenCheck));
    }

    public class ToolBarDropDown {
        private ToolBarDropDown() {
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

        public void changeLanguage(final String language){
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
}
