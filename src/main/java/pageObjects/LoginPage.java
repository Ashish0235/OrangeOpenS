package pageObjects;

import base.BaseTest;
import configFiles.ReadConfig;
import pageConstants.LoginPageEvents;
import utils.FetchElement;

public class LoginPage extends BaseTest implements LoginPageEvents {

	ReadConfig prop = new ReadConfig();
	FetchElement ele = new FetchElement();

	public void loginpageTest() {

		ele.getWebElement("CSS", userName).sendKeys(prop.getUsername());
		ele.getWebElement("CSS", password).sendKeys(prop.getPassword());
		ele.getWebElement("XPATH", loginButton).click();

	}

}
