package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class CartPage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String PLACE_ORDER_BUTTON = "placeOrderButton";
  private static final String NAME_FIELD = "nameField";
  private static final String COUNTRY_FIELD = "countryField";
  private static final String CITY_FIELD = "cityField";
  private static final String CREDIT_CARD_FIELD = "creditCardField";
  private static final String MONTH_FIELD = "monthField";
  private static final String YEAR_FIELD = "yearField";
  private static final String PURCHASE_BUTTON = "purchaseButton";
  private static final String CLOSE_BUTTON = "closeButton";

  public CartPage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/CartPage");
  }

  public void clickPlaceOrder() {
    SeleniumHelper.click(driver, locatorProvider.getBy(PLACE_ORDER_BUTTON));
  }

  public void fillOrderForm(
      String name, String country, String city, String card, String month, String year) {
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(NAME_FIELD), name);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(COUNTRY_FIELD), country);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(CITY_FIELD), city);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(CREDIT_CARD_FIELD), card);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(MONTH_FIELD), month);
    SeleniumHelper.sendKeys(driver, locatorProvider.getBy(YEAR_FIELD), year);
  }

  public void clickPurchase() {
    SeleniumHelper.click(driver, locatorProvider.getBy(PURCHASE_BUTTON));
  }

  public void closeOrderModal() {
    SeleniumHelper.click(driver, locatorProvider.getBy(CLOSE_BUTTON));
  }

  public boolean isOrderConfirmed() {
    // Example: check for order confirmation modal or message
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("orderConfirmationModal"));
  }
}
