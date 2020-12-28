package helpers;

import helper.ConsoleLog;
import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    RemoteWebDriver driver;
    WebDriverWait wait;
    private static Integer timeOut = 20;
    Select s;
    public CommonActions(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
    }

    public void verifyIsElementVisible(WebElement element) throws Throwable {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println( new Throwable()
                    .getStackTrace()[2]
                    .getMethodName());

        } catch (ElementNotVisibleException e) {
            ConsoleLog.info("Element" + element + "is not visible");
            throw e.getCause();
        }
    }

    public void typeKeys(WebElement element, String input) throws Throwable {
        verifyIsElementVisible(element);
        ConsoleLog.info(element + "is displayed");
        try{
            element.sendKeys(input);
        }
        catch (Exception e){
            ConsoleLog.info("Couldn't perform type action with element: " + element);
            throw e.getCause();
        }

    }

    public void click(WebElement element) throws Throwable {
        verifyIsElementVisible(element);
        ConsoleLog.info(element + "is displayed");
        try{
            element.click();
        }
        catch (Exception e){
            ConsoleLog.info("Couldn't perform type action with element: " + element);
            throw e.getCause();
        }
    }

    public void selectOptionForNoSelectTag(WebElement dropDownElement, WebElement textFieldElement, WebElement filteredElement, String optionText) throws Throwable {
        click(dropDownElement);
        typeKeys(textFieldElement, optionText);
        click(filteredElement);
    }

    public boolean verifyElementIsDisplayed(WebElement element) throws Throwable {
        verifyIsElementVisible(element);
        return element.isDisplayed();
    }

    public void hoverAndSelectElemnt(WebElement element, String subelement) throws Throwable {
        verifyIsElementVisible(element);
        ConsoleLog.info(element + "is displayed");
        try {
            (new Actions(this.driver)).moveToElement(element).build().perform();
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='project-row']/span[contains(text(),'" + subelement + "')]"))).click();
            //Thread.sleep(5000);
            //System.out.println("Waiting in hover and select");
            //driver.findElement(By.xpath("//div[@class='project-row']/span[contains(text(),"+element+")]")).click();
            //Thread.sleep(5000000);
            //  driver.findElement(By.xpath("//span[contains(text(),"+subelement+")]")).click();

        } catch (Exception e) {
            System.out.println("Error in hover and select element");
            throw e;
        }

    }


    /*public void hoverOverAndClick(String element,String subelement) throws Throwable
            {
                //HomePageLocators h=new HomePageLocators(driver);
                verifyIsElementVisible(element);
                ConsoleLog.info(element + "is displayed");
                try {

            //wait.until(ExpectedConditions.visibilityOf(element));

            (new Actions(this.driver)).moveToElement(element).build().perform();
                    //WebDriverWait wait = new WebDriverWait(driver, 15);
                   // Thread.sleep(5000);
                    //WebElement element1=driver.findElement(By.xpath("//span[contains(text(),"+s+")]"));
                    //verifyIsElementVisible(element1);
                    //element1.click();
                    //Thread.sleep(5000);
                    //Thread.sleep(5000);

                    //driver.findElement(By.xpath("//*[@id='project-expanded-side-bar']/div[3]/div[2]/div/div/span")).click();
                    //System.out.println("Executed");


                } catch (Exception e)
                {
                    System.out.println(e.getCause());
                                ConsoleLog.info("Hover over element did not work as expected." + element);
                    throw e;
        }*/
}

