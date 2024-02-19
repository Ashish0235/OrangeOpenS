package testClassess;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageConstants.LoginPageEvents;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        
        // Assert that the user has successfully landed on the dashboard page
        Assert.assertTrue(LoginPageEvents.dashboardXpath.length() > 0, "User failed to navigate to the dashboard page");
        logger.info("User successfully logged in and landed on the dashboard page");
    }
}
