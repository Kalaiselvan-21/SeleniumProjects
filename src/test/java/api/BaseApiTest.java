package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import utils.ConfigManager;

/**
 * Base class for API tests
 */
public class BaseApiTest {
    protected static final Logger logger = LogManager.getLogger(BaseApiTest.class);
    protected RequestSpecification requestSpec;
    
    @BeforeClass
    public void setUp() {
        // Get base URL from config
        String baseUrl = ConfigManager.getProperty("api.baseurl", "http://localhost:3000");
        
        logger.info("Setting up API test with base URL: " + baseUrl);
        
        // Set up request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .build();
        
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
