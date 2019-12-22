package project.auto.test.core.groupPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.auto.test.Element;
import project.auto.test.core.Utils;

public class GroupCard extends Element {
    private final WebElement element;
    private final By relativeTitleLocator = By.xpath(".//a[contains(@data-l, 't,visit')]");
    private final String title;

    /**
     * Обертка на карточками групп.
     *
     * @param driver  {@link WebDriver}
     * @param element {@link WebElement}
     */
    public GroupCard(WebDriver driver, WebElement element) {
        super(driver);
        this.element = element;
        this.title = Utils.getInnerText(element, relativeTitleLocator);
    }

    public String getTitle() {
        return title;
    }

    /**
     * Метод, в котором нажимается на карточку группы и возващается страницу профиля группы.
     *
     * @return {@link GroupProfilePage} возвращает страницу профиля группы
     */
    public GroupProfilePage clickGroupProfile() {
        element.click();
        return new GroupProfilePage(driver);
    }
}
