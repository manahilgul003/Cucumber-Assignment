
#Weather Shopper Test Automation
This repository contains an automated testing framework for the Weather Shopper application. The tests are written using Selenium, Cucumber, and JUnit, and they validate the shopping process based on the temperature.

#The Weather Shopper Test Automation project automates the process of navigating the Weather Shopper website, selecting products based on the current temperature, adding them to the cart, and completing the checkout process. The framework uses Selenium for browser automation, Cucumber for behavior-driven development (BDD), and JUnit for running the tests.

#Setup
#Prerequisites
Java 8 or higher
Maven
Chrome browser
Docker (for Selenium Grid)
Installation
Clone the repository

bash
Copy code
git clone https://github.com/your-username/weather-shopper-test-automation.git
cd weather-shopper-test-automation
Install dependencies

bash
Copy code
mvn clean install
Start Selenium Grid (if not already running)

bash
Copy code
docker-compose up -d
Running the Tests
Execute the tests using Maven

bash
Copy code
mvn test
View the reports

The test results will be available in the target/site/cucumber-pretty directory. Open the index.html file to view the detailed test report.

Project Structure
src/test/java/com/tau/runner/RunCucumberTests.java: Contains the main test runner class for Cucumber.
src/test/java/Parallel/WeatherTest.java: Contains the step definitions for the Cucumber tests.
src/test/resources: Directory containing the feature files for Cucumber.
pom.xml: Maven configuration file with dependencies and plugins.
