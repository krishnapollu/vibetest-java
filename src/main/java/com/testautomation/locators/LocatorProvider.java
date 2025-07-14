package com.testautomation.locators;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.openqa.selenium.By;

public class LocatorProvider {
  private static final Map<String, Properties> cache = new ConcurrentHashMap<>();
  private final Properties locators;

  public LocatorProvider(String pageName) {
    this.locators = cache.computeIfAbsent(pageName, LocatorProvider::loadProperties);
  }

  public By getBy(String elementName) {
    String locator = locators.getProperty(elementName);
    if (locator == null) {
      throw new IllegalArgumentException("Locator not found for element: " + elementName);
    }
    String[] parts = locator.split(":", 2);
    if (parts.length != 2) {
      throw new IllegalArgumentException("Invalid locator format for element: " + elementName);
    }
    String type = parts[0].trim();
    String value = parts[1].trim();
    switch (type.toLowerCase()) {
      case "id":
        return By.id(value);
      case "name":
        return By.name(value);
      case "css":
        return By.cssSelector(value);
      case "xpath":
        return By.xpath(value);
      case "class":
        return By.className(value);
      case "tag":
        return By.tagName(value);
      case "linktext":
        return By.linkText(value);
      case "partiallinktext":
        return By.partialLinkText(value);
      default:
        throw new IllegalArgumentException("Unknown locator type: " + type);
    }
  }

  private static Properties loadProperties(String pageName) {
    Properties props = new Properties();
    // Always use forward slashes for resource loading
    String path = "/locators/" + pageName + ".properties";
    try (InputStream is = LocatorProvider.class.getResourceAsStream(path)) {
      if (is == null) {
        throw new RuntimeException("Locator properties file not found: " + path);
      }
      props.load(is);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load locator properties: " + path, e);
    }
    return props;
  }
}
