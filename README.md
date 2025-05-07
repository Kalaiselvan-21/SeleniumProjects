# Selenium Test Automation Framework

A comprehensive test automation framework built with Selenium WebDriver, TestNG, and REST Assured for both UI and API testing.

## Project Structure

```
SeleniumProjects/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/           # Base test classes
│   │   │   ├── pages/          # Page Object Model classes
│   │   │   ├── utils/          # Utility classes
│   │   │   ├── DataProviderandParameters/  # Data-driven testing examples
│   │   │   ├── LoginDemoFramework/         # Login functionality tests
│   │   │   └── SeleniumTests/              # Basic Selenium test examples
│   │   └── resources/
│   │       ├── config.properties  # Configuration properties
│   │       └── log4j2.xml         # Logging configuration
│   └── test/
│       ├── java/
│       │   ├── tests/           # UI test classes
│       │   ├── api/             # API test classes
│       │   ├── RestAssuredLearning/  # REST API examples
│       │   └── pojoConcepts/    # POJO classes for API testing
│       └── resources/           # Test resources
├── logs/                        # Log files
├── screenshots/                 # Test failure screenshots
├── test-output/                 # TestNG reports
├── testng.xml                   # TestNG configuration
└── pom.xml                      # Maven configuration
```

## Features

- Page Object Model design pattern
- Data-driven testing with TestNG DataProvider
- Parallel test execution
- API testing with REST Assured
- Logging with Log4j2
- Screenshot capture on test failure
- Configuration management
- Cross-browser testing support

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven
- Chrome/Firefox/Safari browser

### Running Tests

To run all tests:

```bash
mvn clean test
```

To run specific test suite:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

## Configuration

Edit `src/main/resources/config.properties` to configure:

- Base URLs
- Browser settings
- Test data paths

## Best Practices Implemented

- Explicit waits instead of Thread.sleep()
- Proper exception handling
- Centralized WebDriver management
- Separation of test data from test logic
- Proper cleanup of resources
- Logging instead of System.out.println()
- Assertions for API responses

## Contributors

- Kalai

## License

This project is licensed under the MIT License.
