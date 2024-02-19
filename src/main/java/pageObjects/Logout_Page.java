package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageConstants.ProfileEvents;
import utils.FetchElement;

public class Logout_Page extends BaseTest implements ProfileEvents {

    private final FetchElement fetchElement;

    public Logout_Page() {
        this.fetchElement = new FetchElement();
    }

    public void clickProfileButton() {
        WebElement profileButton = fetchElement.getWebElement("XPATH", profileButtonXpath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(profileButton)).click();
        log.info("Clicked on the profile button");
    }

    public List<WebElement> getDropdownItems() {
        List<WebElement> dropdownItems = fetchElement.getWebElements("XPATH", dropdownItemsXpath);
        log.info("Retrieved " + dropdownItems.size() + " dropdown items");
        return dropdownItems;
    }

    public void clickAboutCloseButton() {
        WebElement aboutCloseButton = fetchElement.getWebElement("XPATH", aboutCloseButtonXpath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(aboutCloseButton)).click();
        log.info("Clicked on the About close button");
    }
}
