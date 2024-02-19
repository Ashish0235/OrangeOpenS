package pageObjects;

import base.BaseTest;
import configFiles.ReadConfig;
import pageConstants.LoginPageEvents;
import utils.FetchElement;

public class LoginPage extends BaseTest implements LoginPageEvents {

    private final ReadConfig configReader;
    private final FetchElement elementFetcher;

    public LoginPage() {
        this.configReader = new ReadConfig();
        this.elementFetcher = new FetchElement();
    }

    public void login() {
        enterUsername(configReader.getUsername());
        enterPassword(configReader.getPassword());
        clickLoginButton();
    }

    private void enterUsername(String username) {
        elementFetcher.getWebElement("CSS", userNameCss).sendKeys(username);
        log.info("Entered username");
    }

    private void enterPassword(String password) {
        elementFetcher.getWebElement("CSS", passwordCss).sendKeys(password);
        log.info("Entered password");
    }

    private void clickLoginButton() {
        elementFetcher.getWebElement("XPATH", loginButtonXpath).click();
        log.info("Clicked on the login button");
    }
}
