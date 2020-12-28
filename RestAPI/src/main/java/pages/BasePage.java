package pages;

import helpers.CommonActions;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.drivers.web.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BasePage {
    protected static CommonActions commonActions;
    protected RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
        commonActions = new CommonActions(driver);
    }

    public WebElement getElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
