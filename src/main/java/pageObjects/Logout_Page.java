package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageConstants.ProfileEvents;
import utils.FetchElement;

public class Logout_Page extends BaseTest implements ProfileEvents {
	
	FetchElement logOut = new FetchElement();

	public void selectLogout() {
		
		List<WebElement> list = logOut.getWebElements("XPATH", listOfDropdownItems);
		if (list.size() != 0) {
			System.out.println("List of items" +list.size());
		}
	}
}
