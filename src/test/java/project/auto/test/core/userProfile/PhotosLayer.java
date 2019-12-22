package project.auto.test.core.userProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.auto.test.BasePage;
import project.auto.test.core.Utils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PhotosLayer extends BasePage {
    private final By photosWidgetItemsLocator = By.xpath(".//*[contains(@data-l, 't,actions')]/li");
    private final List<PhotosWidgetItem> widgetItems;

    public PhotosLayer(WebDriver driver) {
        super(driver);
        check();
        widgetItems = Utils.wrapElements(PhotosWidgetItem::new, driver.findElements(photosWidgetItemsLocator));
    }

    @Override
    protected void check() {
        assertTrue(explicitWait(ExpectedConditions.visibilityOfAllElementsLocatedBy(photosWidgetItemsLocator),
                maxCheckTime,
                msBetweenCheck));
    }

    public PhotosLayer clickLike() {
        widgetItems.get(WidgetItems.Like.ordinal()).click();
        return this;
    }

    private enum WidgetItems {
        Comment,
        Share,
        Like
    }
}
