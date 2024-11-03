/*
{
    "skills" : ["java","selenium"],
        "firstname" : "Kalai",
        "Lastname" : "Selvan",
        "email" : "kalai21.it@gmail.com",
        "id" : 97
}
*/

package RestAssuredLearning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializationExample {

    
    public void serialization()
    {
        Map<String, Object> jsonBody = new HashMap<String, Object>();

        List<String> skillsList = new ArrayList<String>();
        skillsList.add("java");
        skillsList.add("selenium");

        jsonBody.put("firstname", "Kalai");
        jsonBody.put("lastname", "Selvan");
        jsonBody.put("email", "kalai@gmail.com");
        jsonBody.put("skills", skillsList);

        System.out.println(jsonBody);
        RestAssured.baseURI = "http://localhost:3000/";
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type","application/json")
                .body(jsonBody);
        Response response = requestSpecification.request(Method.POST,"employees");
        System.out.println(response.asPrettyString());
    }
}
