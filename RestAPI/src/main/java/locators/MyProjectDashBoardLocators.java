package locators;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MyProjectDashBoardLocators extends BasePage {

    public MyProjectDashBoardLocators(RemoteWebDriver driver){
        super(driver);
    }

    protected static String applicationNameXpath = "//div//span[contains(text(),''{0}'')]";

    @FindBy(xpath = "//div//span[contains(text(),'Applications')]")
    protected WebElement applicationsLink;

    @FindBy(css = "div.content-items-wrapper")
    protected WebElement contentItemWrapper;
}
