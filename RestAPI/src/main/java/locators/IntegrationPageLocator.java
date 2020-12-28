package locators;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class IntegrationPageLocator extends BasePage
{
        public IntegrationPageLocator(RemoteWebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//div[contains(text(),'Display token')]")
    protected WebElement dispayToken;

    @FindBy(xpath="//div[@class='sdk-explain-code-item tp-text-ellipsis ng-binding ng-scope']")
    protected  WebElement devolperTokenText;

    @FindBy(xpath="//div[contains(text(),'Get a developer token')]")
    protected WebElement integrationPage;
}
