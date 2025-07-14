package com.testautomation.reporting;

import com.testautomation.reporting.model.TestResult;
import java.util.List;

public interface ReportGenerator {
  void generateReport(List<TestResult> results) throws Exception;
}
