package com.testautomation.reporting;

import com.testautomation.reporting.model.TestResult;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;

public class AllureReportGenerator implements ReportGenerator {
  @Override
  public void generateReport(List<TestResult> results) throws Exception {
    File resultsDir = new File("allure-results");
    if (!resultsDir.exists()) resultsDir.mkdirs();
    for (TestResult result : results) {
      String uuid = UUID.randomUUID().toString();
      File testFile = new File(resultsDir, uuid + "-result.json");
      try (FileWriter writer = new FileWriter(testFile)) {
        writer.write("{\n");
        writer.write("  \"name\": \"" + result.getTestName() + "\",\n");
        writer.write(
            "  \"status\": \""
                + (result.getStatus() != null ? result.getStatus().name().toLowerCase() : "unknown")
                + "\",\n");
        writer.write("  \"logs\": " + result.getLogs().toString() + ",\n");
        writer.write("  \"screenshots\": " + result.getScreenshots().toString() + ",\n");
        writer.write("  \"metadata\": " + result.getMetadata().toString() + "\n");
        writer.write("}\n");
      }
    }
  }
}
