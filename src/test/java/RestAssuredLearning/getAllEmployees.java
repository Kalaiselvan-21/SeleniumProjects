package RestAssuredLearning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class getAllEmployees {


    public void getEmployees()
    {
        RestAssured.baseURI = "http://localhost:3000/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET,"employees");

        System.out.println(response.asPrettyString());
        System.out.println(response.statusLine());

    }

    public void createEmployee()
    {
        RestAssured.baseURI = "http://localhost:3000/";

        RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json").body("{\n" +
                "    \"firstname\": \"Kayal\",\n" +
                "\"lastname\": \"S\",\n" +
                "    \"age\": 4,\n" +
                "    \"email\": \"kayal@gmail.com\",\n" +
                "    \"isVerified\": true\n" +
                "}");
        requestSpecification.request(Method.POST,"employees");

    }

    public void updateEmployee()
    {
        RestAssured.baseURI="http://localhost:3000/employees";

        RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json").body("{\n" +
                "  \"id\": \"b512\",\n" +
                "  \"employees\": [\n" +
                "    {\n" +
                "      \"firstname\": \"Balu\",\n" +
                "      \"lastname\": \"S\",\n" +
                "      \"age\": 30,\n" +
                "      \"email\": \"Balu@gmail.com\",\n" +
                "      \"isVerified\": true\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        requestSpecification.request(Method.PUT,"b512");
    }

    @Test
    public void createFromFile()
    {
        File jsonpath = new File("/Users/kalai/Documents/postData.json");
        RestAssured.baseURI="http://localhost:3000/Student";
        RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json").body(jsonpath);
        Response response = requestSpecification.request(Method.POST);

        System.out.println(response.asPrettyString());

    }

}
