package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String USERNAME_FIELD = "usernameField";
  private static final String PASSWORD_FIELD = "passwordField";
  private static final String SIGNUP_MODAL_BUTTON = "signupModalButton";
  private static final String CLOSE_BUTTON = "closeButton";

  public SignUpPage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/SignUpPage");
  }

  public void enterUsername(String username) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(USERNAME_FIELD), username);
  }

  public void enterPassword(String password) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(PASSWORD_FIELD), password);
  }

  public void clickSignUp() {
    SeleniumHelper.click(driver, locatorProvider.getBy(SIGNUP_MODAL_BUTTON));
  }

  public void close() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CLOSE_BUTTON));
  }

  public boolean isSignUpSuccess() {
    // Example: check for signup success message or modal close
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("signupSuccessMessage"));
  }

  public boolean isSignUpErrorDisplayed() {
    // Example: check for error message presence
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("signupErrorMessage"));
  }
}
