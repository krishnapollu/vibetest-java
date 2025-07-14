package com.testautomation.pages.google;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.TestParameterManager;
import com.testautomation.locators.LocatorProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
  private WebDriver driver;
  private LocatorProvider locatorProvider;

  public GoogleHomePage(WebDriver driver) {
    this.driver = driver;
    this.locatorProvider = new LocatorProvider("GoogleHomePage");
  }

  public void open() {
    String url = TestParameterManager.getUrl();
    LoggerUtil.info("Opening URL: " + url);
    driver.get(url);
  }

  public void search(String query) {
    LoggerUtil.info("Searching for: " + query);
    WebElement box = driver.findElement(locatorProvider.getBy("searchBox"));
    box.clear();
    box.sendKeys(query);
    box.sendKeys(Keys.RETURN);
  }

  public boolean areSearchResultsDisplayed() {
    // Example: check for results stats or result element
    return driver.findElements(locatorProvider.getBy("searchResults")) != null
        && !driver.findElements(locatorProvider.getBy("searchResults")).isEmpty();
  }
}
