import helper.ConsoleLog;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Practice_RestAssured
{

    public static void main(String args[]) {
        String appName = "Youtube";
        String appUrl = "https://www.youtube.com/";

        RestAssured.baseURI = "https://the-internet.herokuapp.com";//"http://thetestingworldapi.com/Help";

        // Getting request specification
        RequestSpecification httpRequest = RestAssured.given();

        // Setting the request header
       // httpRequest.header("Authorization", "LQtBI3QYKo7fY0Xi07WsTKGqdjd-FhTmvdgc7y0O4h81");
        httpRequest.header("Content-Type", "application/json");

        // Setting the parameters for body

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "tomsmith");
        requestParams.put("password", "SuperSecretPassword");

        /*requestParams.put("id", "1");
        requestParams.put("first_name", "Manik");
        requestParams.put("last_name", "Gupta");
        requestParams.put("date_of_birth", "13March1991");
*/
        // Adding the body
        httpRequest.body(requestParams.toJSONString());
        // Sending the post request
        Response response =httpRequest.post("/login");
        //Response response = httpRequest.request(Method.POST, "/index.php/auth/validateCredential");

        // Verifying the status code
        ConsoleLog.info("Status code: " + response.getStatusCode());
        boolean statusCode = response.getStatusCode() == 200;
        //System.out.println(response.getHeader("data"));
        if(statusCode)
            System.out.println("Success");
        else
            System.out.println("Unsuccess");

        /*Assert.assertTrue(statusCode);
        //driver.report().step("Created the application in the project successfully using api with status code: " + statusCode);
        ConsoleLog.info("API done");
        ConsoleLog.info("Resuming UI");*/
    }
}