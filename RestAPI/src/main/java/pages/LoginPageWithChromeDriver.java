package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageWithChromeDriver extends LoginPageLocators {
    RemoteWebDriver chromeDriver;

    public LoginPageWithChromeDriver(RemoteWebDriver driver) {
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public LoginPageWithChromeDriver setUserName(String userNameText) throws Throwable {
        commonActions.typeKeys(userName, userNameText);
        return this;
    }

    public LoginPageWithChromeDriver setPassword(String passwordText) throws Throwable {
        commonActions.typeKeys(password, passwordText);
        return this;
    }

    public HomePage clickSignInButton() throws Throwable {
        commonActions.click(signInButton);
        return new HomePage(chromeDriver);
    }

    public HomePage login(String userName, String password) throws Throwable {
        return setUserName(userName).setPassword(password).clickSignInButton();
    }
}
