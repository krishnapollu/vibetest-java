package com.testautomation.listeners;

import com.testautomation.reporting.AllureReportGenerator;
import com.testautomation.reporting.ExtentReportGenerator;
import com.testautomation.reporting.ReportCollector;
import com.testautomation.reporting.ReportGenerator;
import com.testautomation.reporting.model.TestResult;
import java.util.ArrayList;
import java.util.List;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ReportSuiteListener implements ISuiteListener {
  @Override
  public void onStart(ISuite suite) {}

  @Override
  public void onFinish(ISuite suite) {
    String reportType = suite.getXmlSuite().getParameter("reportType");
    if (reportType == null) reportType = "extent";
    List<TestResult> results = ReportCollector.getAllResults();
    List<ReportGenerator> generators = new ArrayList<>();
    if (reportType.contains("extent")) generators.add(new ExtentReportGenerator());
    if (reportType.contains("allure")) generators.add(new AllureReportGenerator());
    for (ReportGenerator generator : generators) {
      try {
        generator.generateReport(results);
      } catch (Exception e) {
        System.err.println("Failed to generate report: " + e.getMessage());
      }
    }
  }
}
