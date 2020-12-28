import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredDemoGetTest {

    @Test
    public void getWeatherDetails() throws ParseException {
        RestAssured.baseURI = "https://api.testproject.io";

        RequestSpecification httpRequest = RestAssured.given();
        Header header = new Header("Authorization", "iVDNC-jeL8mhP4lh3F1CjVYSQVPRk_sgGpT5cFAtbhI1");
        httpRequest.header(header);
        Response response = httpRequest.request(Method.GET, "v2/agents?_start=0&_limit=10");

        String responseBody = response.getBody().prettyPrint();
        JSONParser jsonParser = new JSONParser();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(responseBody);
        Object aliasName = ((JSONObject) jsonArray.get(0)).get("alias");
        boolean isAliasNameCorrect = aliasName.equals("Pulkit's Agent") || aliasName.equals("TX windows agent");

        Assert.assertTrue(isAliasNameCorrect);
    }
}
