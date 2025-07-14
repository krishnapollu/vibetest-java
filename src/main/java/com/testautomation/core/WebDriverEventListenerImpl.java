package com.testautomation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverEventListenerImpl implements WebDriverListener {
  @Override
  public void beforeClick(WebElement element) {
    LoggerUtil.info("Before clicking element: " + describeElement(element));
  }

  @Override
  public void afterClick(WebElement element) {
    LoggerUtil.info("After clicking element: " + describeElement(element));
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    LoggerUtil.info(
        "Before sending keys '"
            + String.join("", keysToSend)
            + "' to element: "
            + describeElement(element));
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    LoggerUtil.info(
        "After sending keys '"
            + String.join("", keysToSend)
            + "' to element: "
            + describeElement(element));
  }

  @Override
  public void beforeGet(WebDriver driver, String url) {
    LoggerUtil.info("Before navigating to: " + url);
  }

  @Override
  public void afterGet(WebDriver driver, String url) {
    LoggerUtil.info("After navigating to: " + url);
  }

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    LoggerUtil.info("Before finding element: " + locator);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    LoggerUtil.info("After finding element: " + locator);
  }

  @Override
  public void beforeQuit(WebDriver driver) {
    LoggerUtil.info("Before quitting WebDriver");
  }

  @Override
  public void afterQuit(WebDriver driver) {
    LoggerUtil.info("After quitting WebDriver");
  }

  private String describeElement(WebElement element) {
    try {
      String tag = element.getTagName();
      String text = element.getText();
      return String.format("<%s> with text '%s'", tag, text);
    } catch (Exception e) {
      return "[Unknown element]";
    }
  }
}
