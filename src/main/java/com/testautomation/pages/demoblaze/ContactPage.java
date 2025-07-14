package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class ContactPage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String CONTACT_EMAIL_FIELD = "contactEmailField";
  private static final String CONTACT_NAME_FIELD = "contactNameField";
  private static final String MESSAGE_FIELD = "messageField";
  private static final String SEND_MESSAGE_BUTTON = "sendMessageButton";
  private static final String CLOSE_BUTTON = "closeButton";

  public ContactPage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/ContactPage");
  }

  public void fillContactForm(String email, String name, String message) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(CONTACT_EMAIL_FIELD), email);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(CONTACT_NAME_FIELD), name);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(MESSAGE_FIELD), message);
  }

  public void sendMessage() {
    SeleniumHelper.click(driver, locatorProvider.getBy(SEND_MESSAGE_BUTTON));
  }

  public void closeContactModal() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CLOSE_BUTTON));
  }

  public boolean isMessageSent() {
    // Example: check for message sent confirmation
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("contactSuccessMessage"));
  }
}
