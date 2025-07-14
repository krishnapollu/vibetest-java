# VibeTest - Selenium TestNG Automation Framework

**Built 100% with CursorAI (powered by OpenAI GPT-4)**

---

## 🚀 Overview

VibeTest is a professional, cross-platform Selenium TestNG automation framework designed for modern web application testing. Built with best practices, advanced logging, comprehensive reporting, and AI-assisted development.

## ✨ Key Features

- **Cross-platform compatibility** (Windows, macOS, Linux)
- **Modular architecture** with clear separation of concerns
- **Professional logging** with step-level detail and screenshots
- **Advanced ExtentReports integration** with step-level screenshot display
- **Custom `@MyTest` annotation** for comprehensive test metadata
- **Unified logging and reporting** with optimized TestNG listeners
- **Externalized locators and test data** for maintainability
- **Automatic screenshot capture** on failure and on-demand
- **Thread-safe step logging** with optional screenshots
- **Multiple browser support** (Chrome, Firefox, Edge)
- **Clean, maintainable code structure**

## 🏗️ Architecture

```
src/
├── main/java/com/testautomation/
│   ├── capabilities/          # Browser capability providers
│   ├── core/                  # Core framework components
│   ├── locators/              # Externalized locators
│   └── pages/                 # Page Object Model classes
└── test/java/com/testautomation/
    ├── listeners/             # TestNG listeners
    ├── tests/                 # Test classes
    └── data/                  # Test data files
```

## 🛠️ Technology Stack

- **Java 17**
- **Selenium WebDriver 4.x**
- **TestNG 7.x**
- **ExtentReports 5.x**
- **Maven 3.x**
- **ChromeDriver, GeckoDriver, EdgeDriver**

## 📦 Prerequisites

- Java 17 or higher
- Maven 3.6+
- Chrome, Firefox, and/or Edge browsers
- Git

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd vibe-coding
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Run Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=GoogleSearchTest

# Run with specific browser
mvn test -Dbrowser=chrome
```

## 📝 Test Structure

### Custom @MyTest Annotation
```java
@MyTest(
    testCaseId = "TC-001",
    description = "Verify user can search for products",
    author = "Test Engineer",
    tags = {"smoke", "search"}
)
@Test
public void testProductSearch() {
    // Test implementation
}
```

### Page Object Model
```java
public class HomePage {
    @FindBy(id = "search-input")
    private WebElement searchInput;
    
    public void searchProduct(String product) {
        searchInput.sendKeys(product);
        searchInput.submit();
    }
}
```

## 🔧 Configuration

### Browser Configuration
Supported browsers: `chrome`, `firefox`, `edge`

Set via system property: `-Dbrowser=chrome`

### Test Data
Externalized test data in `src/test/resources/data/`

### Locators
Externalized locators in `src/main/resources/locators/`

## 📊 Reporting

### ExtentReports Features
- **Step-level screenshots** integrated with test steps
- **Comprehensive test metadata** from `@MyTest` annotation
- **Cross-platform path handling** for reliable screenshot display
- **Professional test execution logs**
- **Failure analysis and debugging information**

### Report Location
Reports are generated in: `target/extent-reports/`

## 🎯 Test Examples

### Google Search Test
```java
@MyTest(
    testCaseId = "GOOG-001",
    description = "Verify Google search for 'Selenium' displays relevant results",
    author = "Test Automation Team",
    tags = {"smoke", "google", "search"}
)
@Test
public void testGoogleSearch() {
    LoggerUtil.info("Starting Google search test");
    
    GoogleHomePage googlePage = new GoogleHomePage();
    googlePage.navigateTo();
    googlePage.search("Selenium");
    
    Assert.assertTrue(googlePage.getSearchResults().size() > 0);
}
```

### DemoBlaze E-commerce Tests
- **HomePage Test**: Navigation and product selection
- **Login Test**: User authentication
- **SignUp Test**: New user registration
- **Product Test**: Product details and cart operations
- **Cart Test**: Order placement
- **Contact Test**: Contact form submission

## 🔍 Logging and Debugging

### Step-Level Logging
```java
LoggerUtil.info("Step: Navigate to homepage");
LoggerUtil.info("Step: Enter search term || screenshot: search_entered.png");
```

### Screenshot Integration
- Automatic screenshots on test failure
- On-demand screenshots with step logging
- Cross-platform path handling for reliable display

## 🏃‍♂️ Running Tests

### Command Line Options
```bash
# Run all tests
mvn test

# Run specific package
mvn test -Dtest=com.testautomation.tests.google.*

# Run with specific browser
mvn test -Dbrowser=firefox

# Run with parallel execution
mvn test -Dparallel=true

# Run with custom test data
mvn test -DtestData=production
```

### TestNG XML Configuration
```xml
<suite name="VibeTest Suite">
    <test name="Google Tests">
        <classes>
            <class name="com.testautomation.tests.google.GoogleSearchTest"/>
        </classes>
    </test>
</suite>
```

## 🧹 Code Quality

### Import Organization
```bash
# Organize imports
mvn spotless:apply
```

### Code Style
```bash
# Check code style
mvn checkstyle:check
```

## 🔧 Framework Components

### Core Classes
- **DriverManager**: WebDriver lifecycle management
- **LoggerUtil**: Professional logging utilities
- **SeleniumHelper**: Common Selenium operations
- **MyTestLogger**: Custom annotation metadata logging

### Listeners
- **UnifiedLogListener**: Comprehensive test lifecycle logging
- **ParameterInitializerListener**: Test parameter management
- **ReportSuiteListener**: ExtentReports integration

### Capability Providers
- **ChromeCapabilitiesProvider**: Chrome browser configuration
- **FirefoxCapabilitiesProvider**: Firefox browser configuration
- **EdgeCapabilitiesProvider**: Edge browser configuration

## 🐛 Troubleshooting

### Common Issues
1. **Screenshots not displaying**: Ensure reports are served via HTTP
2. **Browser compatibility**: Update WebDriver versions
3. **Path issues**: Framework uses cross-platform path handling

### Debug Mode
```bash
mvn test -Ddebug=true
```

## 📈 Best Practices

1. **Use `@MyTest` annotation** for comprehensive test metadata
2. **Implement Page Object Model** for maintainable tests
3. **Externalize locators and test data** for flexibility
4. **Use step-level logging** for better debugging
5. **Follow naming conventions** for consistency
6. **Keep tests independent** and self-contained

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Follow coding standards
4. Add comprehensive tests
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🙏 Acknowledgments

- Built with **Cursor AI** for intelligent code generation
- Powered by **OpenAI GPT-4** for advanced development assistance
- Inspired by modern test automation best practices

---

**VibeTest** - Where testing meets innovation! 🚀 
