package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HomePageLocators {
    RemoteWebDriver chromeDriver;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean isHomePageLogoDisplayed() throws Throwable {
        return commonActions.verifyElementIsDisplayed(homePageLogo);
    }

    public MyProjectDashBoard selectOptionInMyProjectDropdown(String optionText) throws Throwable {
        commonActions.selectOptionForNoSelectTag(myProjectsDropdown, searchAProjectInputFieldInMyProjectDropdown, filteredElementInMyProjectsDropDown, optionText);
        return new MyProjectDashBoard(chromeDriver);
    }

    public void hoverAndSelectFromMenuBar(String element, String subelement) throws Throwable {
        commonActions.hoverAndSelectElemnt(projectMenuBar(element), subelement);
    }

    public IntegrationPage selectIntegrationFromMenuBar() throws Throwable {
        commonActions.click(projectMenuBar("Integrations"));
        return new IntegrationPage(chromeDriver);
    }
        public void clickFromMenubar(String element) throws Throwable {
        commonActions.click(projectMenuBar(element));
    }
    /*public void hoverOverAndClickProject(String element,String subelement) throws Throwable {

        commonActions.hoverOverAndClick(element,subelement);
        //, driver.findElement(By.xpath("//span[contains(text(),'Demo')]")));

    }

    public void selectProjectFromMenuBar(String value) throws Throwable
    {

        commonActions.click(projectNameFromMenuBar(value));
    }*/
}
