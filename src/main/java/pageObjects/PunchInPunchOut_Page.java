package pageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import pageConstants.PunchInPunchOut;
import utils.FetchElement;

public class PunchInPunchOut_Page extends BaseTest implements PunchInPunchOut {

	FetchElement loginOut = new FetchElement();

	public String punchInOutforCheck() {

		String timeForInOut = loginOut.getWebElement("XPATH", punchInOutTime).getText();
		log.info("Current time is " + timeForInOut);
		return timeForInOut;

	}

	public boolean clockButton() {

		loginOut.getWebElement("XPATH", watchButton).click();
		log.info("clock button visible and clicked");
		return true;

	}

	public void notedetails() {

		WebElement noteForPunch = loginOut.getWebElement("XPATH", note);
		noteForPunch.sendKeys("This is just for check");
		log.info("Note info pasted in the note field");
	}

	public void Button() throws InterruptedException {

		WebElement inOut = loginOut.getWebElement("XPATH", button);
		Assert.assertTrue(inOut.isEnabled());
		Thread.sleep(1000);
		inOut.click();
		log.info("Assert passed:- Button visible and clickable");

	}

}
