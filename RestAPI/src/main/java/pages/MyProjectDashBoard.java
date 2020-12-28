package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.MyProjectDashBoardLocators;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.MessageFormat;

public class MyProjectDashBoard extends MyProjectDashBoardLocators {
    RemoteWebDriver chromeDriver;
    public MyProjectDashBoard(RemoteWebDriver driver){
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public void clickApplicationLink() throws Throwable {
        commonActions.click(applicationsLink);
    }

    public boolean isLinkDisplayedOnApplicationSection(String text) throws Throwable {
        if(commonActions.verifyElementIsDisplayed(contentItemWrapper)){
            String locator = MessageFormat.format(applicationNameXpath, text);
            return commonActions.verifyElementIsDisplayed(getElementByXpath(locator));
        }
        else
            return false;
    }
}
