package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.IntegrationPageLocator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class IntegrationPage extends IntegrationPageLocator
{
    RemoteWebDriver chromeDriver;
    public IntegrationPage(RemoteWebDriver driver)
    {
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean isIntegrationPageDisplayed() throws Throwable
    {
        return commonActions.verifyElementIsDisplayed(integrationPage);
    }

    public String getSdkToken() throws Throwable
    {
        commonActions.verifyIsElementVisible(dispayToken);
        commonActions.click(dispayToken);
        Thread.sleep(5000);
        return devolperTokenText.getText();
    }



}
