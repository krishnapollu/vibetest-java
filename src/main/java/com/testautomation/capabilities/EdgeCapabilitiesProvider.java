package com.testautomation.capabilities;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import com.testautomation.core.TestParameterManager;

public class EdgeCapabilitiesProvider {
  public static EdgeDriver getDriver() {
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized");
    if (TestParameterManager.getHeadless()) {
      options.addArguments("--headless=new");
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
      options.addArguments("--window-size=" + windowSize.replace(",", ","));
    }
    // Add any Edge-specific options here
    return new EdgeDriver(options);
  }
}
