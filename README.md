A robust automation framework for web applications, built using Selenium WebDriver, Cucumber, and TestNG. This framework follows the Page Object Model (POM) with PageFactory for scalable, maintainable, and readable test automation.

Features:
Page Object Model: Separation of test logic and page objects for easy maintenance.
PageFactory: Efficient initialization and management of web elements using @FindBy annotation.
Cucumber BDD: Write test scenarios in natural language for better collaboration between QA and non-QA stakeholders.
TestNG Integration: Advanced test configuration, reporting, and parallel execution support.
WebDriverManager: Automatic download and management of browser drivers.
Support for Headless Execution: Chrome headless execution for CI/CD environments.
Reusable Components: Abstract components and utilities for common functionality.
Screenshot Generation: Captures screenshots on test failures for easier debugging.

Framework Structure:
src/main/java/com/enterprise/

TestComponents/: Base test setup, driver initialization, utilities

stepDefinitions/: Cucumber step definitions

pageObjects/: Page classes following POM + PageFactory

src/test/java/cucumber/: Feature files written in Gherkin syntax

testng.xml: TestNG suite configuration
