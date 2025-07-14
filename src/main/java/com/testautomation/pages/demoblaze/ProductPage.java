package com.testautomation.pages.demoblaze;

import com.testautomation.core.SeleniumHelper;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.WebDriver;

public class ProductPage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  private static final String ADD_TO_CART_BUTTON = "addToCartButton";
  private static final String PRODUCT_NAME = "productName";
  private static final String PRODUCT_PRICE = "productPrice";

  public ProductPage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("demoblaze/ProductPage");
  }

  public void addToCart() {
    SeleniumHelper.click(driver, locatorProvider.getBy(ADD_TO_CART_BUTTON));
  }

  public String getProductName() {
    return SeleniumHelper.getText(driver, locatorProvider.getBy(PRODUCT_NAME));
  }

  public String getProductPrice() {
    return SeleniumHelper.getText(driver, locatorProvider.getBy(PRODUCT_PRICE));
  }

  public boolean isAddToCartSuccess() {
    // Example: check for alert or cart badge update
    return SeleniumHelper.isElementPresent(driver, locatorProvider.getBy("cartBadge"));
  }
}
