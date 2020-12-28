import helpers.excelUtls;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import helpers.ConsoleLog;
import pages.HomePage;
import pages.LoginPageWithChromeDriver;
import pages.MyProjectDashBoard;
import helpers.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

public class LoginAndHomepage extends BaseTest {


    LoginPageWithChromeDriver loginPageWithChromeDriver;// = new LoginPageWithChromeDriver(driver);
    HomePage homePage;//=new HomePage(driver);
    MyProjectDashBoard myProjectDashBoard;//s=new MyProjectDashBoard(driver);

    String userName = "manikgupta33@gmail.com";
    String password = "Manik@7435";
    String myFirstProjectOption = "My first Project";

    /*
     * @Test public void login() throws Throwable {
     *
     *
     * @Test public void hoverAndSelectProject() throws Throwable {
     *
     *
     * }
     */
    @Test(testName = "a", dataProviderClass = dataProviderUtils.class, dataProvider = "testdata", description = "C:\\Users\\manik.gupta\\Desktop\\user_data1.xlsx,Sheet2")
    public void a(Map<String, String> data) {
        System.out.println(data.get("lastname"));
    }

    @Test(testName = "test1", dataProviderClass = dataProviderUtils.class, dataProvider = "testdata", description = "C:\\Users\\manik.gupta\\Desktop\\user_data1.xlsx,Sheet1")
    public void data_test(Map<String, String> data) {
        System.out.println(data.get("username"));
    }


    @Test(testName = "Test2", dataProviderClass = dataProviderUtils.class, dataProvider = "testdata", description = "D:\\Test_Project\\testprojectDemo\\RestAPI\\src\\main\\resources\\element.xlsx,Sheet1")
    public void postRequestDemoTest(Map<String, String> data) throws Throwable {
        /**
         * UI test

         */
        loginPageWithChromeDriver = new LoginPageWithChromeDriver(driver);
        homePage = new HomePage(driver);
        myProjectDashBoard = new MyProjectDashBoard(driver);


        loginPageWithChromeDriver.setUserName(data.get("username"));
        loginPageWithChromeDriver.setPassword(data.get("password"));
        loginPageWithChromeDriver.clickSignInButton();
        boolean isUserLoggedIn = homePage.isHomePageLogoDisplayed();
        driver.report().step("User logged in", isUserLoggedIn);
        Assert.assertTrue(isUserLoggedIn, "Homepage logo is not displayed");
        ConsoleLog.info("Homepage logo is displayed");
        homePage.hoverAndSelectFromMenuBar(data.get("element"), data.get("subelement"));
        Thread.sleep(5000);
        //homePage.hoverAndSelectFromMenuBar("Project", "My first Project");

        /*@Test(dataProvider = "testdata")//,   description = "C:\\Users\\manik.gupta\\Desktop\\user_data1.xlsx,Sheet1")
        public  void dataproviderTest(Map<String, String> data)
        {
            data.get

        }*/

        //Thread.sleep(5000);
        /*driver.findElement(By.xpath("//div[@class='project-row']/span[contains(text(),'Demo')]")).click();
        Thread.sleep(5000);
*/
        /*homePage.hoverOverAndClickProject("Project","My First Project");
        Thread.sleep(5000);
        homePage.selectProjectFromMenuBar("My first Project");
        *///if (driver.findElement(By.xpath("//div[contains(text(),'My first Project')]")).isDisplayed())
        //  Assert.assertTrue(true);
        //else
        //  Assert.assertTrue(false);


        /**
         * API test
         */
//        String appName = "Youtube";
//        String appUrl = "https://www.youtube.com/";
//
//        RestAssured.baseURI = baseUrlApi;
//
//        // Getting request specification
//        RequestSpecification httpRequest = RestAssured.given();
//
//        // Setting the request header
//        httpRequest.header("Authorization", "iVDNC-jeL8mhP4lh3F1CjVYSQVPRk_sgGpT5cFAtbhI1");
//        httpRequest.header("Content-Type", "application/json");
//
//        // Setting the parameters for body
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("name",appName);
//        requestParams.put("description","Youtube web application");
//        requestParams.put("platform","Web");
//        requestParams.put("url",appUrl);
//
//        // Adding the body
//        httpRequest.body(requestParams);
//
//        // Sending the post request
//        Response response = httpRequest.request(Method.POST, "/v2/projects/nEP6rnMoz0qFv6WHG98VcQ/applications");
//
//        // Verifying the status code
//        System.out.println("Status code: "+response.getStatusCode());
//        boolean statusCode = response.getStatusCode()==200;
//        Assert.assertTrue(statusCode);
//        driver.report().step("Created the application in the project successfully using api with status code: " + statusCode);
//        ConsoleLog.info("API done");
//        ConsoleLog.info("Resuming UI");
//
        /**
         * Resuming UI part
         */
        // Click on My Projects dropdown
        //homePage.selectOptionInMyProjectDropdown(myFirstProjectOption);

        // myProjectDashBoard.
//
//        driver.findElement(By.xpath("//div//span[contains(text(),'Applications')]")).click();
//        Thread.sleep(3000);
//
//        boolean isRequiredAppDisplayed = driver.findElement(By.cssSelector(MessageFormat.format("div[title=''{0}'']", appName))).isEnabled();
//
//        Assert.assertTrue(isRequiredAppDisplayed);
        //ConsoleLog.info("Test completed");
        //driver.report().test("UI and API test", isRequiredAppDisplayed).submit();
        // driver.report().test("UI and API test", isUserLoggedIn).submit();
    }
}


