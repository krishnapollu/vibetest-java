package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.pages.demoblaze.LoginPage;
import com.testautomation.tests.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
  private HomePage homePage;
  private LoginPage loginPage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
  }

  @MyTest(
      testCaseId = "DBZ-002",
      description = "Verify login modal interaction with valid credentials",
      author = "Your Name",
      tags = {"smoke", "login"})
  @Test
  public void testLoginModal() {
    LoggerUtil.info("Opening login modal");
    homePage.goToLogin();
    com.testautomation.listeners.UnifiedLogListener.logStep("Opened login modal", true);
    loginPage.enterUsername("testuser");
    loginPage.enterPassword("testpass");
    loginPage.clickLogin();
    // Add assertion for login success or error as needed
  }
}
