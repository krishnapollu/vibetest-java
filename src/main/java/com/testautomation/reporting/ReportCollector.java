package com.testautomation.reporting;

import com.testautomation.reporting.model.TestResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReportCollector {
  private static final ConcurrentMap<String, TestResult> results = new ConcurrentHashMap<>();

  public static TestResult getOrCreate(String testName) {
    return results.computeIfAbsent(testName, TestResult::new);
  }

  public static void addResult(TestResult result) {
    results.put(result.getTestName(), result);
  }

  public static List<TestResult> getAllResults() {
    return new ArrayList<>(results.values());
  }

  public static void clear() {
    results.clear();
  }
}
