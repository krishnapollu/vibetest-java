package com.testautomation.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testautomation.reporting.model.TestResult;
import java.util.List;

public class ExtentReportGenerator implements ReportGenerator {
  @Override
  public void generateReport(List<TestResult> results) throws Exception {
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");
    sparkReporter
        .config()
        .setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
    sparkReporter.config().setDocumentTitle("Automation Test Report");
    sparkReporter.config().setReportName("Execution Results");
    ExtentReports extent = new ExtentReports();
    extent.attachReporter(sparkReporter);

    for (TestResult result : results) {
      ExtentTest test = extent.createTest(result.getTestName());
      if (result.getStatus() != null) {
        switch (result.getStatus()) {
          case PASSED:
            test.pass("Test Passed");
            break;
          case FAILED:
            test.fail("Test Failed");
            break;
          case SKIPPED:
            test.skip("Test Skipped");
            break;
        }
      }
      for (String log : result.getLogs()) {
        if (log.startsWith("STEP: ")) {
          String stepLog = log.substring(6);
          String[] parts = stepLog.split("\\|\\|", 2);
          String stepDesc = parts[0];
          if (parts.length > 1) {
            String screenshotPath = parts[1];
            test.info(
                stepDesc, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
          } else {
            test.info(stepDesc);
          }
        } else {
          test.info(log);
        }
      }
      for (String key : result.getMetadata().keySet()) {
        test.assignCategory(key + ": " + result.getMetadata().get(key));
      }
    }
    extent.flush();
  }
}
