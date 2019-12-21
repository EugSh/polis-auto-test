package project.auto.test.core.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class HPMiddleContent extends BasePage {
    private final By postFeelingBtnLocator = By.xpath(".//*[contains(@data-l,'t,pf_feeling_button')]");

    public HPMiddleContent(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }



    public FeelingLayer clickPostFeeling(){
        click(postFeelingBtnLocator);
        throw new UnsupportedOperationException();
    }

}
