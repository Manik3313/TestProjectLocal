import helpers.ConsoleLog;
import helpers.dataProviderUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IntegrationPage;
import pages.LoginPageWithChromeDriver;
import static io.restassured.RestAssured.*;

import java.util.Map;

public class IntegrationTest extends BaseTest
{
    HomePage homePage;
    IntegrationPage integrationPage;
    @Test(testName = "Test2", dataProviderClass = dataProviderUtils.class, dataProvider = "testdata", description = "C:\\Users\\91998\\Desktop\\Framework\\testprojectDemo\\RestAPI\\src\\main\\resources\\data.xlsx,Sheet1")
        public void  IntegrationToken(Map<String, String> data) throws Throwable
    {
            LoginPageWithChromeDriver loginPageWithChromeDriver = new LoginPageWithChromeDriver(driver);
            loginPageWithChromeDriver.setUserName(data.get("username"));
            loginPageWithChromeDriver.setPassword(data.get("password"));
            homePage=loginPageWithChromeDriver.clickSignInButton();
            System.out.println(driver.getCurrentUrl());

            boolean isUserLoggedIn = homePage.isHomePageLogoDisplayed();
            driver.report().step("User logged in", isUserLoggedIn);
            Assert.assertTrue(isUserLoggedIn, "Homepage logo is not displayed");
            ConsoleLog.info("Homepage logo is displayed");
            integrationPage = homePage.selectIntegrationFromMenuBar();
            //IntegrationPage integrationPage=new IntegrationPage(driver);
            boolean isIntegrationPageDisplayed=integrationPage.isIntegrationPageDisplayed();
            driver.report().step("Integration page is displayed", isUserLoggedIn);
            Assert.assertTrue(isUserLoggedIn, "IntegrationPage is not displayed");
            Thread.sleep(5000);
            ConsoleLog.info("Integrationpage is displayed");
            System.out.println(integrationPage.getSdkToken());

        homePage.hoverAndSelectFromMenuBar("Project","Demo");
        Thread.sleep(5000);

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","Google1");
        requestParams.put("description","Youtube web application");
        requestParams.put("platform","Web");
        requestParams.put("url","httpos://www.google.com");

        given()
                .baseUri("https://api.testproject.io/v2/projects/5k19yA-XfkGI8q6e_MHbew/applications")
                .header("Authorization","LQtBI3QYKo7fY0Xi07WsTKGqdjd-FhTmvdgc7y0O4h81")
                .header("Content-Type", "application/json")
               // .body(requestParams)//"{\"name\":\"manik123\",\"platform\":\"Web\",\"url\":\"https://facebook.com\"}\n" +
                       // "        ")
                 .body(requestParams)
                .when()
                .post()
                .then()
                //.statusCode(200)
                .log().all();



    }
   /* @Test
    public void test2() throws Throwable
    {
    }
*/
}

