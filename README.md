# Weather Shopper Test Automation
This repository contains an automated testing framework for the Weather Shopper application. The tests are written using Selenium, Cucumber, and JUnit, and they validate the shopping process based on the temperature.


# Overview
The Weather Shopper Test Automation project automates the process of navigating the Weather Shopper website, selecting products based on the current temperature, adding them to the cart, and completing the checkout process. The framework uses Selenium for browser automation, Cucumber for behavior-driven development (BDD), and JUnit for running the tests.

# Setup
1. Prerequisites
2. Java 8 or higher
3. Maven
4. Chrome browser
5. Docker (for Selenium Grid)
6. Installation
The test results will be available in the target/site/cucumber-pretty directory. Open the index.html file to view the detailed test report.

# Project Structure
src/test/java/com/tau/runner/RunCucumberTests.java: Contains the main test runner class for Cucumber.
src/test/java/Parallel/WeatherTest.java: Contains the step definitions for the Cucumber tests.
src/test/resources: Directory containing the feature files for Cucumber.
pom.xml: Maven configuration file with dependencies and plugins.

