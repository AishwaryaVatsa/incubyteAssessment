# incubyteAssessment

#**Project Overview**

This project is a demonstration of Behavior-Driven Development (BDD) using Cucumber and Selenium for automated web testing. The tests are written in Gherkin language and implemented using Java to validate functionality on the Magento e-commerce platform.


#**Features**

Automates user interactions with the Magento website.
Includes scenarios for:
User registration.
User login.
Navigation and validation of pages.
Uses Page Object Model (POM) for clean and maintainable code.

#**Tech Stack**

Language: Java
Testing Framework: Cucumber (BDD)
Browser Automation: Selenium WebDriver
Build Tool: Maven
IDE: IntelliJ IDEA
Dependency Management: Maven


#**Structure**

src/main/java
|-- com.test.incubyte.pages        # Page classes for POM
|-- com.test.incubyte.utils        # Utility classes for reusable methods

src/test/java
|-- com.test.incubyte.stepdefs     # Step Definitions for feature files
|-- com.test.incubyte.runners      # Test runner classes

src/test/resources
|-- features                       # Feature files
|-- config.properties              # Configuration file for environment variables


#**Setup Instructions**

Prerequisites
Install Java JDK (8 or above).
Install Maven.
Install a modern browser (e.g., Chrome) and its corresponding WebDriver.
Install an IDE like IntelliJ IDEA.


#**Installation**

Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/your-cucumber-project.git
Navigate to the project directory:
bash
Copy code
cd your-cucumber-project
Install dependencies:
bash
Copy code
mvn clean install


#**Execution**

Running Tests
Run tests using the Maven command:
bash
Copy code
mvn test
Or execute the TestRunner class from the IDE.


#**Reporting**

Reports are generated in the target/cucumber-reports directory after test execution.
Customize reports using @CucumberOptions.
