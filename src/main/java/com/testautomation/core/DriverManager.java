package com.testautomation.core;

import com.testautomation.capabilities.ChromeCapabilitiesProvider;
import com.testautomation.capabilities.EdgeCapabilitiesProvider;
import com.testautomation.capabilities.FirefoxCapabilitiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DriverManager {
  private static WebDriver driver;

  private DriverManager() {}

  public static WebDriver getDriver() {
    if (driver == null) {
      String browser = TestParameterManager.getBrowser();
      LoggerUtil.info("Setting up WebDriver for browser: " + browser);
      switch (browser.toLowerCase()) {
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          driver =
              new EventFiringDecorator(new WebDriverEventListenerImpl())
                  .decorate(FirefoxCapabilitiesProvider.getDriver());
          break;
        case "edge":
          WebDriverManager.edgedriver().setup();
          driver =
              new EventFiringDecorator(new WebDriverEventListenerImpl())
                  .decorate(EdgeCapabilitiesProvider.getDriver());
          break;
        case "chrome":
        default:
          WebDriverManager.chromedriver().setup();
          driver =
              new EventFiringDecorator(new WebDriverEventListenerImpl())
                  .decorate(ChromeCapabilitiesProvider.getDriver());
          break;
      }
      LoggerUtil.info(
          browser.substring(0, 1).toUpperCase()
              + browser.substring(1).toLowerCase()
              + " WebDriver initialized with event listener");
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      LoggerUtil.info("Quitting WebDriver");
      try {
        driver.quit();
      } catch (Exception e) {
        LoggerUtil.warning("Error quitting WebDriver: " + e.getMessage());
      } finally {
        driver = null;
        LoggerUtil.info("WebDriver quit successfully");
      }
    }
  }
}
