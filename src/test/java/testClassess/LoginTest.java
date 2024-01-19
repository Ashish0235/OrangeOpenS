package testClassess;

import org.testng.annotations.Test;

import config.ReadConfig;
import pageObjectClasses.LoginPage;


public class LoginTest extends BaseClass {

	@Test

	public void login() throws InterruptedException {
		
		log.info("---------Login Test started----------");
		LoginPage login = new LoginPage(driver);
		login.userName(ReadConfig.property.getProperty("username"));
		log.info("Entered username");
		login.passWord(ReadConfig.property.getProperty("password"));
		log.info("Entered password");
		login.loginButton();
		log.info("Login successful");
		log.info("---------Login Test Ended----------");
		

	}

}
