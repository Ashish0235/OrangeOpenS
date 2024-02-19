package testClassess;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pageConstants.ProfileEvents;
import pageObjects.Logout_Page;

public class Logout_Test extends BaseTest implements ProfileEvents {

    Logout_Page logout = new Logout_Page();

    @Test
    public void userLogout() {
        try {
            // Open dropdown menu
            logout.clickProfileButton();
            log.info("Dropdown list opened");

            // Select "Logout" option from the dropdown
            selectLogoutOption();

            // Log success message
            log.info("User successfully logged out and landed on the Login page");
        } catch (Exception e) {
            // Log error message
        	log.error(e);
          
        }
    }
    
    @Test
    public void test() {
    	
    	System.out.println("This is just for testing");
    	
    }

    private void selectLogoutOption() {
        List<WebElement> dropdownItems = logout.getDropdownItems();
        for (WebElement option : dropdownItems) {
            String optionText = option.getText();
            if (optionText.equalsIgnoreCase(option4)) {
                // Wait for the option to be visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(option));

                // Log selection
                log.info("Dropdown option selected: " + optionText);

                // Click the option
                option.click();
                return; // Exit the loop once the option is found and clicked
            }
            
        }
        // If the option is not found, log a message
        log.error("Logout option not found in the dropdown menu");
    }
}
