package com.testautomation.tests.google;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.google.GoogleHomePage;
import com.testautomation.tests.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {
  private GoogleHomePage googleHomePage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    googleHomePage = new GoogleHomePage(driver);
  }

  @MyTest(
      testCaseId = "GOOG-001",
      description = "Verify Google search for 'Selenium' displays relevant results",
      author = "Your Name",
      tags = {"smoke", "google", "search"})
  @Test
  public void testGoogleSearch() {
    googleHomePage.open();
    googleHomePage.search("Selenium");
    LoggerUtil.info("Asserting that the page title contains 'Selenium'");
    Assert.assertTrue(driver.getTitle().contains("Selenium"), "Title should contain 'Selenium'");
  }
}
