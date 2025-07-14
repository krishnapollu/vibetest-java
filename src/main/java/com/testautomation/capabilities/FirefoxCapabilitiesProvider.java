package com.testautomation.capabilities;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.testautomation.core.TestParameterManager;

public class FirefoxCapabilitiesProvider {
  public static FirefoxDriver getDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--start-maximized");
    if (TestParameterManager.getHeadless()) {
      options.addArguments("-headless");
    }
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
      options.setPlatformName("windows");
    } else if (os.contains("mac")) {
      options.setPlatformName("mac");
    } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
      options.setPlatformName("linux");
    }
    String windowSize = TestParameterManager.getWindowSize();
    if (windowSize != null && !windowSize.isEmpty()) {
      String[] parts = windowSize.split(",");
      if (parts.length == 2) {
        options.addArguments("--width=" + parts[0]);
        options.addArguments("--height=" + parts[1]);
      }
    }
    // Add any Firefox-specific options here
    return new FirefoxDriver(options);
  }
}
