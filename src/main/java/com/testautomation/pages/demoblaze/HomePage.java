package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class HomePage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String LOGIN_BUTTON = "loginButton";
  private static final String SIGNUP_BUTTON = "signupButton";
  private static final String CART_BUTTON = "cartButton";
  private static final String CONTACT_BUTTON = "contactButton";
  private static final String PHONES_CATEGORY = "phonesCategory";
  private static final String LAPTOPS_CATEGORY = "laptopsCategory";
  private static final String MONITORS_CATEGORY = "monitorsCategory";
  private static final String FIRST_PRODUCT = "firstProduct";

  public HomePage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/HomePage");
  }

  public void goToLogin() {
    SeleniumHelper.click(driver, locatorProvider.getBy(LOGIN_BUTTON));
  }

  public void goToSignUp() {
    SeleniumHelper.click(driver, locatorProvider.getBy(SIGNUP_BUTTON));
  }

  public void goToCart() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CART_BUTTON));
  }

  public void goToContact() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CONTACT_BUTTON));
  }

  public void selectPhonesCategory() {
    SeleniumHelper.click(driver, locatorProvider.getBy(PHONES_CATEGORY));
  }

  public void selectLaptopsCategory() {
    SeleniumHelper.click(driver, locatorProvider.getBy(LAPTOPS_CATEGORY));
  }

  public void selectMonitorsCategory() {
    SeleniumHelper.click(driver, locatorProvider.getBy(MONITORS_CATEGORY));
  }

  public void selectFirstProduct() {
    SeleniumHelper.click(driver, locatorProvider.getBy(FIRST_PRODUCT));
  }

  public boolean isLoginButtonPresent() {
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy(LOGIN_BUTTON));
  }

  public boolean isSignUpButtonPresent() {
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy(SIGNUP_BUTTON));
  }

  public boolean isCartButtonPresent() {
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy(CART_BUTTON));
  }

  public boolean isFirstProductPresent() {
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy(FIRST_PRODUCT));
  }
}
