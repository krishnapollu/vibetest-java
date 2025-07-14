package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.demoblaze.ContactPage;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.tests.common.BaseTest;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends BaseTest {
  private HomePage homePage;
  private ContactPage contactPage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
    contactPage = new ContactPage(driver);
  }

  @DataProvider(name = "contactData")
  public Object[][] contactData() throws IOException {
    Properties props = new Properties();
    // Always use forward slashes for resource loading
    props.load(getClass().getClassLoader().getResourceAsStream("testdata/contact.properties"));
    return new Object[][] {
      {props.getProperty("email"), props.getProperty("name"), props.getProperty("message")}
    };
  }

  @MyTest(
      testCaseId = "DBZ-006",
      description = "Verify sending a message via the contact form",
      author = "Your Name",
      tags = {"contact", "form"})
  @Test(dataProvider = "contactData")
  public void testSendMessage(String email, String name, String message) {
    LoggerUtil.info("Opening contact modal");
    homePage.goToContact();
    contactPage.fillContactForm(email, name, message);
    contactPage.sendMessage();
    // Add assertion for message sent confirmation as needed
  }
}
