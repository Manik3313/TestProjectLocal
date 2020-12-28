

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class API_Testing
{
    public static void get()
    {
        String s = given()
                .baseUri("https://api.testproject.io")
                .header("Authorization", "LQtBI3QYKo7fY0Xi07WsTKGqdjd-FhTmvdgc7y0O4h81")

                .when()
                .get("/v2/projects/5k19yA-XfkGI8q6e_MHbew/applications")
                .then()
                .extract()
                .response()
                .asString();
        //System.out.println(s);
        JsonPath data=new JsonPath(s);

        String id=data.getString("id");
       // System.out.println(id);
        if (id.contains("z6mjJhiysE6BojXgZ4MD-w"))
            System.out.println("Get success");

    }

    public static  void main(String args[])
    {

        given()
                .baseUri("https://api.testproject.io")
                .header("Authorization", "LQtBI3QYKo7fY0Xi07WsTKGqdjd-FhTmvdgc7y0O4h81")
                .body("{\n" +
                        "  \"name\": \"Google\",\n" +
                        "  \"description\": \"Google\",\n" +
                        "  \"url\": \"https://www.google.com/images\",\n" +
                        "}")
                .when()
                .put("/v2/projects/5k19yA-XfkGI8q6e_MHbew/applications/wuVnJnkeeUmmlrlCnZEMvw")
                .then()
                .statusCode(200)
                .log()
                .all();
        get();
           }
}
