# Selenium Automation Portfolio Project 🚀

This repository contains a professional-grade automated testing framework using **Java**, **Selenium WebDriver**, and **TestNG**. The project has been fully refactored from individual practice scripts into a cohesive, maintainable system following the **Page Object Model (POM)** design pattern.

## 🛠 Tech Stack

- **Language**: Java 17
- **Automation Tool**: Selenium WebDriver 4.x
- **Test Framework**: TestNG
- **Build Tool**: Maven
- **Browser Management**: WebDriverManager
- **Design Pattern**: Page Object Model (POM)

## 🏗 Project Structure

```text
src/test/java/com/example/
├── base/
│   └── BaseTest.java          # Driver setup (maximized, timeouts) & teardown
├── pages/
│   ├── BasePage.java          # Common UI actions (waits, clicks, typing)
│   ├── LoginPage.java         # POM for Window Handling & Auth
│   ├── StorePage.java         # POM for E-commerce scenarios
│   ├── PracticePage.java      # POM for Alerts & Dropdowns
│   ├── GreenKartPage.java     # POM for WebTables & Pagination
│   ├── AngularPracticePage.java # POM for Relative Locators
│   ├── BrokenLinksPage.java   # POM for HTTP API logic
│   └── ActionsAndIframePage.java # POM for Drag&Drop, Hover, iFrames
├── StoreTest.java             # E2E Store Checkout Tests
├── ChildWindowTest.java       # Multi-window interaction tests
├── RelativeLocatorsTest.java   # Selenium 4 Relative Locators showcase
├── PracticeTests.java         # Alerts & Dropdown interaction tests
├── WebTableTest.java          # Filtering, Searching & Pagination tests
├── AdvancedInteractionsTest.java # iFrames, Drag & Drop, Mouse Hover
└── BrokenLinksTest.java       # Hybrid API/UI testing for 404 links
```

## 📋 Features & Skills Showcased

- **Page Object Model**: Complete separation of test logic from UI locators.
- **Selenium 4 Features**: Implementation of **Relative Locators**.
- **Advanced UI Interactions**: Drag & Drop, Mouse Hover, and `iFrame` switching (`Actions` class).
- **Hybrid Testing (API + UI)**: Gathering links via UI and checking HTTP status codes (200 OK vs 404) via Java `HttpURLConnection` to find broken links fast.
- **Complex UI Interactions**: Handling of **Browser Windows**, **Alerts**, and **Dynamic Dropdowns**.
- **Data Tables**: Automated **Filtering** and **Pagination** logic.
- **Data-Driven Testing (DDT)**: Externalizing test data using **JSON** files and Jackson databind parser with TestNG `@DataProvider` (e.g., `storeData.json`).
- **Cross-Browser Testing**: Dynamic browser instantiation (Chrome, Firefox, Edge) configurable via `testng.xml` and `config.properties`.
- **Properties Configuration**: Centralized environment variables and timeouts extracted into `src/main/resources/config.properties`.
- **System Logging**: Integrated **Log4j2** for professional console and file logging (`logs/app.log`) of test lifecycles and Page Object actions.
- **Advanced Reporting**: Integrated **ExtentReports** with automated screenshot capture on test failures using `ITestListener`.
- **CI/CD Pipeline**: Configured **GitHub Actions** (`maven.yml`) for automated headless cross-browser test execution on every push.
- **Build Management**: Maven lifecycle configuration with `testng.xml` suite definition.

## 🚀 Getting Started

### Running Tests
To run the entire professional suite:
```bash
mvn test
```


