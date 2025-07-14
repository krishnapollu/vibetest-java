package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.pages.demoblaze.SignUpPage;
import com.testautomation.tests.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
  private HomePage homePage;
  private SignUpPage signUpPage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
    signUpPage = new SignUpPage(driver);
  }

  @MyTest(
      testCaseId = "DBZ-003",
      description = "Verify signup modal interaction with new user",
      author = "Your Name",
      tags = {"smoke", "signup"})
  @Test
  public void testSignUpModal() {
    LoggerUtil.info("Opening signup modal");
    homePage.goToSignUp();
    signUpPage.enterUsername("testuser");
    signUpPage.enterPassword("testpass");
    signUpPage.clickSignUp();
    // Add assertion for signup success or error as needed
  }
}
