package locators;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageLocators extends BasePage {

    public LoginPageLocators(RemoteWebDriver driver){
        super(driver);
    }
    @FindBy(id = "username")
    protected WebElement userName;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "tp-sign-in")
    protected WebElement signInButton;
}
