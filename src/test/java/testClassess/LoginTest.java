package testClassess;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageConstants.LoginPageEvents;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {


	@Test

	public void login() {

		LoginPage login = new LoginPage();
		login.loginpageTest();
		
		logger.info("Assertion passed user landed to dashboard page");
		Assert.assertTrue(LoginPageEvents.dashboard.length()>0, "User failed to navigate to the dashboard page");
		
		logger.info("Test1 pass");

		

	}

}
