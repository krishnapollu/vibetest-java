package com.testautomation.reporting.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResult {
  public enum Status {
    PASSED,
    FAILED,
    SKIPPED
  }

  private String testName;
  private Status status;
  private List<String> logs = new ArrayList<>();
  private List<String> screenshots = new ArrayList<>();
  private Map<String, String> metadata = new HashMap<>();

  public TestResult(String testName) {
    this.testName = testName;
  }

  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<String> getLogs() {
    return logs;
  }

  public void addLog(String log) {
    this.logs.add(log);
  }

  public List<String> getScreenshots() {
    return screenshots;
  }

  public void addScreenshot(String screenshot) {
    this.screenshots.add(screenshot);
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void addMetadata(String key, String value) {
    this.metadata.put(key, value);
  }
}
