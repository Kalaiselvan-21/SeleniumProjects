package RestAssuredLearning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigManager;

import java.io.File;

public class getAllEmployees {
    private static final Logger logger = LogManager.getLogger(getAllEmployees.class);
    private String baseUrl;
    
    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.getProperty("api.baseurl", "http://localhost:3000");
        logger.info("API base URL: {}", baseUrl);
    }

    @Test
    public void getEmployees() {
        logger.info("Testing GET employees endpoint");
        
        RestAssured.baseURI = baseUrl;
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET, "employees");

        logger.info("Response: {}", response.asPrettyString());
        logger.info("Status: {}", response.statusLine());
        
        // Add assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    @Test
    public void createEmployee() {
        logger.info("Testing POST employee endpoint");
        
        RestAssured.baseURI = baseUrl;

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstname\": \"Kayal\",\n" +
                        "    \"lastname\": \"S\",\n" +
                        "    \"age\": 4,\n" +
                        "    \"email\": \"kayal@gmail.com\",\n" +
                        "    \"isVerified\": true\n" +
                        "}");
        
        Response response = requestSpecification.request(Method.POST, "employees");
        
        // Add assertions
        Assert.assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300, 
                "Expected successful status code");
    }

    @Test
    public void updateEmployee() {
        logger.info("Testing PUT employee endpoint");
        
        RestAssured.baseURI = baseUrl + "/employees";

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\n" +
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

        Response response = requestSpecification.request(Method.PUT, "b512");
        
        // Add assertions
        Assert.assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300, 
                "Expected successful status code");
    }

    @Test
    public void createFromFile() {
        logger.info("Testing POST from file endpoint");
        
        String jsonFilePath = ConfigManager.getProperty("json.testdata.path", "/Users/kalai/Documents/postData.json");
        File jsonpath = new File(jsonFilePath);
        
        RestAssured.baseURI = baseUrl + "/Student";
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonpath);
                
        Response response = requestSpecification.request(Method.POST);

        logger.info("Response: {}", response.asPrettyString());
        
        // Add assertions
        Assert.assertTrue(response.getStatusCode() >= 200 && response.getStatusCode() < 300, 
                "Expected successful status code");
    }
}
