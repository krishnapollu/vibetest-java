package com.testautomation.core;

import java.util.HashMap;
import java.util.Map;

public class TestParameterManager {
  private static final Map<String, String> parameters = new HashMap<>();

  public static void initialize(Map<String, String> params) {
    parameters.clear();
    parameters.putAll(params);
  }

  public static String getParameter(String name) {
    return parameters.get(name);
  }

  public static String getBrowser() {
    return parameters.getOrDefault("browser", "chrome");
  }

  public static String getUrl() {
    return parameters.getOrDefault("url", "https://www.google.com");
  }

  public static boolean getHeadless() {
    return Boolean.parseBoolean(parameters.getOrDefault("headless", "false"));
  }

  public static String getWindowSize() {
    return parameters.getOrDefault("windowSize", "1920,1080");
  }

  public static Map<String, String> getAllParameters() {
    return new HashMap<>(parameters);
  }
}
