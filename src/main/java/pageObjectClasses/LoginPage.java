package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


	WebDriver driver;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Username']")
	WebElement usernameTxt;
	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordTxt;
	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement logInButton;

	public void userName(String Email) {

		usernameTxt.sendKeys(Email);		
	}

	public void passWord(String Password) {

		passwordTxt.sendKeys(Password);		
	}

	public void loginButton(){

		logInButton.click();

	}

}
