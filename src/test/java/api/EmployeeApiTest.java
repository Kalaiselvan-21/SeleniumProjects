package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigManager;

import java.io.File;

/**
 * Test class for Employee API endpoints
 */
public class EmployeeApiTest extends BaseApiTest {
    
    @Test
    public void testGetEmployees() {
        logger.info("Testing GET employees endpoint");
        
        Response response = RestAssured.given(requestSpec)
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .extract().response();
        
        logger.info("Response status code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }
    
    @Test
    public void testCreateEmployee() {
        logger.info("Testing POST employee endpoint");
        
        // Create JSON payload
        JSONObject employeeJson = new JSONObject();
        employeeJson.put("firstname", "John");
        employeeJson.put("lastname", "Doe");
        employeeJson.put("age", 30);
        employeeJson.put("email", "john.doe@example.com");
        employeeJson.put("isVerified", true);
        
        Response response = RestAssured.given(requestSpec)
                .body(employeeJson.toString())
                .when()
                .post("/employees")
                .then()
                .statusCode(201)
                .extract().response();
        
        logger.info("Response status code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201");
    }
    
    @Test
    public void testCreateEmployeeFromFile() {
        logger.info("Testing POST employee from file");
        
        // Get JSON file path from config
        String jsonFilePath = ConfigManager.getProperty("json.testdata.path");
        File jsonFile = new File(jsonFilePath);
        
        Response response = RestAssured.given(requestSpec)
                .body(jsonFile)
                .when()
                .post("/Student")
                .then()
                .extract().response();
        
        logger.info("Response: " + response.asPrettyString());
        Assert.assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300, 
                "Expected successful status code");
    }
}
