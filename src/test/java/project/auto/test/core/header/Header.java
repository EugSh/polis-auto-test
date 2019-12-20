package project.auto.test.core.header;

import org.openqa.selenium.WebDriver;
import project.auto.test.BasePage;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);

    }

    @Override
    protected void check() {

    }

    public DropDownToolBar clickDropDownToolBar(){
        return new DropDownToolBar(driver);
    }


}
