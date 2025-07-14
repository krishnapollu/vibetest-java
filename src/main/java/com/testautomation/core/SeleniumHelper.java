package com.testautomation.core;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
  private static final int DEFAULT_TIMEOUT = 10;

  public static WebElement getElement(WebDriver driver, By locator) {
    LoggerUtil.info("Getting element: " + locator);
    return waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
  }

  public static void click(WebDriver driver, By locator) {
    LoggerUtil.info("Clicking element: " + locator);
    waitForElementVisible(driver, locator, DEFAULT_TIMEOUT).click();
  }

  public static void sendKeys(WebDriver driver, By locator, String text) {
    LoggerUtil.info("Sending keys to element: " + locator + ", text: " + text);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    element.clear();
    element.sendKeys(text);
  }

  public static String getText(WebDriver driver, By locator) {
    LoggerUtil.info("Getting text from element: " + locator);
    return waitForElementVisible(driver, locator, DEFAULT_TIMEOUT).getText();
  }

  public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutSeconds) {
    LoggerUtil.info("Waiting for element to be visible: " + locator);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static boolean isElementPresent(WebDriver driver, By locator) {
    LoggerUtil.info("Checking if element is present: " + locator);
    try {
      driver.findElement(locator);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
    LoggerUtil.info("Selecting by visible text '" + visibleText + "' from element: " + locator);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    Select select = new Select(element);
    select.selectByVisibleText(visibleText);
  }

  public static String getAttribute(WebDriver driver, By locator, String attribute) {
    LoggerUtil.info("Getting attribute '" + attribute + "' from element: " + locator);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    return element.getAttribute(attribute);
  }

  public static WebElement waitForElementClickable(
      WebDriver driver, By locator, int timeoutSeconds) {
    LoggerUtil.info("Waiting for element to be clickable: " + locator);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static boolean waitForElementInvisible(WebDriver driver, By locator, int timeoutSeconds) {
    LoggerUtil.info("Waiting for element to be invisible: " + locator);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static void scrollToElement(WebDriver driver, By locator) {
    LoggerUtil.info("Scrolling to element: " + locator);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public static void selectByIndex(WebDriver driver, By locator, int index) {
    LoggerUtil.info("Selecting by index '" + index + "' from element: " + locator);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    Select select = new Select(element);
    select.selectByIndex(index);
  }

  public static void selectByValue(WebDriver driver, By locator, String value) {
    LoggerUtil.info("Selecting by value '" + value + "' from element: " + locator);
    WebElement element = waitForElementVisible(driver, locator, DEFAULT_TIMEOUT);
    Select select = new Select(element);
    select.selectByValue(value);
  }

  public static String takeScreenshot(WebDriver driver, String testName) {
    try {
      String dir =
          java.nio.file.Paths.get(System.getProperty("user.dir"), "reports", "screenshots")
              .toString();
      java.io.File destDir = new java.io.File(dir);
      if (!destDir.exists()) destDir.mkdirs();
      String timestamp =
          new java.text.SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new java.util.Date());
      String fileName = testName + "_" + timestamp + ".png";
      String filePath = java.nio.file.Paths.get(dir, fileName).toString();
      java.io.File srcFile =
          ((org.openqa.selenium.TakesScreenshot) driver)
              .getScreenshotAs(org.openqa.selenium.OutputType.FILE);
      java.nio.file.Files.copy(
          srcFile.toPath(),
          java.nio.file.Paths.get(filePath),
          java.nio.file.StandardCopyOption.REPLACE_EXISTING);
      // Return relative path for ExtentReports (always use forward slash for HTML)
      return "screenshots/" + fileName;
    } catch (Exception e) {
      LoggerUtil.error("Failed to take screenshot: " + e.getMessage());
      return null;
    }
  }

  public static void cleanScreenshotsFolder() {
    String dir =
        java.nio.file.Paths.get(System.getProperty("user.dir"), "reports", "screenshots")
            .toString();
    java.io.File folder = new java.io.File(dir);
    if (folder.exists() && folder.isDirectory()) {
      for (java.io.File file : folder.listFiles()) {
        if (file.isFile()) file.delete();
      }
    }
  }

  
}
