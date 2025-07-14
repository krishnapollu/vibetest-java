package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String USERNAME_FIELD = "usernameField";
  private static final String PASSWORD_FIELD = "passwordField";
  private static final String LOGIN_MODAL_BUTTON = "loginModalButton";
  private static final String CLOSE_BUTTON = "closeButton";

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/LoginPage");
  }

  public void enterUsername(String username) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(USERNAME_FIELD), username);
  }

  public void enterPassword(String password) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(PASSWORD_FIELD), password);
  }

  public void clickLogin() {
    SeleniumHelper.click(driver, locatorProvider.getBy(LOGIN_MODAL_BUTTON));
  }

  public void close() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CLOSE_BUTTON));
  }

  public boolean isLoginSuccess() {
    // Example: check for logout button or user profile presence
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("logoutButton"));
  }

  public boolean isLoginErrorDisplayed() {
    // Example: check for error message presence
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("loginErrorMessage"));
  }
}
