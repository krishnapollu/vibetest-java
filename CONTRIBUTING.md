# Contributing to VibeTest

Thank you for your interest in contributing to VibeTest! This document provides guidelines and information for contributors.

## 🤝 How to Contribute

### 1. Fork and Clone

1. Fork the repository on GitHub
2. Clone your fork locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/vibetest-java.git
   cd vibetest-java
   ```

### 2. Create a Feature Branch

```bash
git checkout -b feature/your-feature-name
# or
git checkout -b bugfix/your-bug-fix
```

### 3. Make Your Changes

- Follow the coding standards outlined below
- Add tests for new functionality
- Update documentation as needed
- Use the `@MyTest` annotation for all test methods

### 4. Test Your Changes

```bash
# Run all tests
mvn clean test

# Run specific test
mvn test -Dtest=YourTestClass

# Check code style
mvn checkstyle:check

# Organize imports
mvn spotless:apply
```

### 5. Commit Your Changes

Use conventional commit messages:

```bash
git commit -m "feat: add new test for login functionality"
git commit -m "fix: resolve screenshot path issue on Windows"
git commit -m "docs: update README with new features"
```

### 6. Push and Create Pull Request

```bash
git push origin feature/your-feature-name
```

Then create a Pull Request on GitHub.

## 📋 Pull Request Guidelines

### Before Submitting

- [ ] Code compiles without errors
- [ ] All tests pass
- [ ] Code follows style guidelines
- [ ] Documentation is updated
- [ ] New tests are added for new features
- [ ] Screenshots are included for UI changes

### PR Title Format

```
type(scope): brief description

Examples:
feat(test): add new Google search test
fix(core): resolve WebDriver initialization issue
docs(readme): update installation instructions
```

### PR Description Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Code refactoring
- [ ] Performance improvement

## Testing
- [ ] Unit tests pass
- [ ] Integration tests pass
- [ ] Cross-browser testing completed
- [ ] Cross-platform testing completed

## Screenshots (if applicable)
Add screenshots for UI changes

## Checklist
- [ ] My code follows the style guidelines
- [ ] I have performed a self-review
- [ ] I have commented my code where necessary
- [ ] I have made corresponding changes to documentation
- [ ] My changes generate no new warnings
```

## 🎨 Coding Standards

### Java Code Style

- Use Java 17 features appropriately
- Follow Java naming conventions
- Use meaningful variable and method names
- Add Javadoc comments for public methods
- Keep methods small and focused

### Test Code Standards

- Use descriptive test method names
- Follow the `@MyTest` annotation pattern:
  ```java
  @MyTest(
      testCaseId = "TC-001",
      description = "Clear description of what the test does",
      author = "Your Name",
      tags = {"smoke", "regression"}
  )
  @Test
  public void testDescriptiveMethodName() {
      // Test implementation
  }
  ```

### Page Object Model

- Keep page objects focused on single pages
- Use meaningful locator names
- Implement proper encapsulation
- Add helper methods for common actions

### Logging

- Use `LoggerUtil.info()` for step logging
- Include screenshots with step logs: `"Step: action || screenshot: filename.png"`
- Log important test events and assertions

## 🧪 Testing Guidelines

### Test Structure

1. **Setup**: Initialize test data and WebDriver
2. **Action**: Perform the test steps
3. **Verification**: Assert expected outcomes
4. **Cleanup**: Reset state if needed

### Test Data

- Externalize test data in `src/test/resources/data/`
- Use meaningful data file names
- Keep test data minimal and focused

### Locators

- Externalize locators in `src/main/resources/locators/`
- Use descriptive locator names
- Prefer stable locators (ID, name) over fragile ones (XPath)

## 🔧 Development Setup

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### IDE Configuration

#### IntelliJ IDEA
- Import as Maven project
- Set Java 17 as project SDK
- Enable annotation processing
- Configure Checkstyle plugin

#### Eclipse
- Import as Maven project
- Set Java 17 as JRE
- Install Checkstyle plugin
- Configure formatter settings

#### VS Code
- Install Java Extension Pack
- Install Maven for Java extension
- Configure Java 17 runtime

### Local Testing

```bash
# Run all tests
mvn clean test

# Run specific browser
mvn test -Dbrowser=chrome

# Run with headless mode
mvn test -Dheadless=true

# Run specific test class
mvn test -Dtest=GoogleSearchTest

# Run specific test method
mvn test -Dtest=GoogleSearchTest#testGoogleSearch
```

## 🐛 Bug Reports

### Before Reporting

1. Check existing issues
2. Try to reproduce the issue
3. Test on different browsers/platforms
4. Check the logs for errors

### Bug Report Template

```markdown
## Bug Description
Clear description of the issue

## Steps to Reproduce
1. Step 1
2. Step 2
3. Step 3

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Environment
- OS: [Windows/macOS/Linux]
- Browser: [Chrome/Firefox/Edge]
- Java Version: [e.g., 17.0.2]
- Maven Version: [e.g., 3.9.0]

## Screenshots/Logs
Add relevant screenshots or log files

## Additional Context
Any other relevant information
```

## 💡 Feature Requests

### Before Requesting

1. Check if the feature already exists
2. Consider if it aligns with project goals
3. Think about implementation complexity

### Feature Request Template

```markdown
## Feature Description
Clear description of the requested feature

## Use Case
Why this feature is needed

## Proposed Implementation
How you think it should be implemented

## Alternatives Considered
Other approaches you've considered

## Additional Context
Any other relevant information
```

## 📚 Documentation

### Updating Documentation

- Keep README.md up to date
- Update code comments when changing functionality
- Add examples for new features
- Update contributing guidelines as needed

### Documentation Standards

- Use clear, concise language
- Include code examples
- Add screenshots for UI changes
- Keep formatting consistent

## 🏆 Recognition

Contributors will be recognized in:

- GitHub contributors list
- Release notes
- Project documentation
- Community acknowledgments

## 📞 Getting Help

- Create an issue for bugs or feature requests
- Join discussions in GitHub issues
- Review existing documentation
- Check the Actions tab for CI/CD status

## 📄 License

By contributing to VibeTest, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing to VibeTest! 🚀 