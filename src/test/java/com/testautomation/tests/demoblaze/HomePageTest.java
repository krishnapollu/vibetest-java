package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.listeners.UnifiedLogListener;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.tests.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
  private HomePage homePage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
  }

  @MyTest(
      testCaseId = "DBZ-001",
      description = "Verify navigation to Login, Sign Up, Cart, and product selection on HomePage",
      author = "Your Name",
      tags = {"smoke", "navigation"})
  @Test
  public void testNavigation() {
    Assert.assertTrue(homePage.isLoginButtonPresent(), "Login button should be present");
    Assert.assertTrue(homePage.isSignUpButtonPresent(), "Sign Up button should be present");
    Assert.assertTrue(homePage.isCartButtonPresent(), "Cart button should be present");
    Assert.assertTrue(homePage.isFirstProductPresent(), "At least one product should be present");
    LoggerUtil.info("Testing navigation to Login");
    UnifiedLogListener.logStep("Testing navigation to Login", true);
    homePage.goToLogin();
    LoggerUtil.info("Testing navigation to Sign Up");
    homePage.goToSignUp();
    LoggerUtil.info("Testing navigation to Cart");
    homePage.goToCart();
    LoggerUtil.info("Testing selecting first product");
    UnifiedLogListener.logStep("Testing selecting first product", true);
    homePage.selectFirstProduct();
  }
}
