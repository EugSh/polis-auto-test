package project.core.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.core.BasePage;

import static org.junit.Assert.assertTrue;

public class Event extends BasePage {
    public Event(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }


    public boolean isSetKlass() {
        return explicitWait(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@data-l,'t,item')]/div[contains(@class,'notif_media')][1]")),
                10,
                1000);
    }
}
