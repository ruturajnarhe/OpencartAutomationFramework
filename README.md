# OpenCart Automation Framework

## Overview

This project is a **Hybrid Test Automation Framework** developed for the OpenCart e-commerce application using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**.

The framework is designed to automate functional and regression test scenarios while following industry-standard automation practices such as reusable page classes, externalized test data, reporting, logging, and cross-browser execution.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Apache POI (Excel)
* Extent Reports
* Log4j2
* Git & GitHub

---

## Framework Features

* Hybrid Automation Framework
* Page Object Model (POM)
* Data-Driven Testing using Excel
* Cross Browser Testing
* Explicit Waits
* Utility Classes
* Extent HTML Reports
* Screenshot Capture on Failure
* Log4j2 Logging
* Configurable Browser and URL using `config.properties`
* TestNG XML Suite Execution
* Maven Dependency Management

---

## Project Structure

```
OpenCartAutomationFramework
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── pageObjects
│   │   │   ├── testCases
│   │   │   ├── testBase
│   │   │   └── utilities
│   │   └── resources
│
├── reports
├── screenshots
├── testData
├── testng.xml
├── pom.xml
└── README.md
```

---

## Prerequisites

Before running the project, ensure the following software is installed:

* Java 17 or above
* Eclipse IDE / IntelliJ IDEA
* Maven
* Google Chrome
* Git

---

## Clone the Repository

```bash
git clone https://github.com/ruturajnarhe/OpencartAutomationFramework.git
```

Open the project in your IDE.

---

## Install Dependencies

If using Maven:

```bash
mvn clean install
```

or

```bash
mvn test
```

---

## Configure the Framework

Update the `config.properties` file according to your environment.

Example:

```
appURL=https://tutorialsninja.com/demo/
browser=chrome
email=test@gmail.com
password=test123
```

---

## Execute Test Cases

### Run using TestNG

Right-click the required TestNG XML file and select:

```
Run As → TestNG Suite
```

### Run using Maven

```
mvn test
```

---

## Framework Components

### Base Class

* Driver Initialization
* Browser Launch
* Configuration Loading
* Screenshot Capture
* Common Setup and Teardown

### Page Objects

Each web page is implemented as a separate Java class containing:

* Web Element Locators
* Page Actions

### Utilities

* Excel Utility
* Data Providers
* Extent Report Manager
* Logging Utility

---

## Reports

After execution, Extent Reports are generated inside the reports directory.

The report contains:

* Passed Test Cases
* Failed Test Cases
* Skipped Test Cases
* Execution Time
* Screenshots for Failed Tests

---

## Logging

Log4j2 is used to generate execution logs, making debugging easier.

---

## Test Scenarios Automated

* User Registration
* Login
* Search Product
* Product Comparison
* Add to Cart
* Logout

---

## Design Patterns Used

* Page Object Model (POM)
* Hybrid Framework
* Data-Driven Testing

---

## Future Enhancements

* Jenkins CI/CD Integration
* Docker Support
* Parallel Execution
* Selenium Grid Execution
* GitHub Actions Workflow
* Allure Reporting

---

## Author

**Ruturaj Narhe**

GitHub: https://github.com/ruturajnarhe

---

## License

This project is created for learning, demonstration, and interview preparation purposes.

