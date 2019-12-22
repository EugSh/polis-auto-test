package project.auto.test.core.searchPage;

import org.openqa.selenium.WebElement;

public class SearchCategory {
    private final WebElement element;


    public SearchCategory(WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }


}
