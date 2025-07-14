package com.testautomation.listeners;

import java.util.Map;

import org.testng.IClassListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testautomation.core.DriverManager;
import com.testautomation.core.MyTestLogger;
import com.testautomation.core.LoggerUtil;
import com.testautomation.core.SeleniumHelper;
import com.testautomation.core.TestParameterManager;
import com.testautomation.reporting.ReportCollector;
import com.testautomation.reporting.model.TestResult;

public class UnifiedLogListener
    implements ISuiteListener, ITestListener, IClassListener, IInvokedMethodListener {
  private static final String SEP =
      "\n==============================" + "==============================";
  private static final ThreadLocal<String> currentTestName = new ThreadLocal<>();

  public static void setCurrentTestName(String testName) {
    currentTestName.set(testName);
  }

  public static String getCurrentTestName() {
    return currentTestName.get();
  }

  public static void clearCurrentTestName() {
    currentTestName.remove();
  }

  // Suite
  @Override
  public void onStart(ISuite suite) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("SUITE START: " + suite.getName());
    logParameters(suite.getXmlSuite().getAllParameters());
    LoggerUtil.info(SEP);
  }

  @Override
  public void onFinish(ISuite suite) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("SUITE END:   " + suite.getName());
    LoggerUtil.info(SEP);
  }

  // Test (XmlTest)
  @Override
  public void onStart(ITestContext context) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("TEST START:  " + context.getName());
    logParameters(context.getCurrentXmlTest().getAllParameters());
    LoggerUtil.info(SEP);
  }

  @Override
  public void onFinish(ITestContext context) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("TEST END:    " + context.getName());
    LoggerUtil.info(SEP);
  }

  // Class
  @Override
  public void onBeforeClass(ITestClass testClass) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("CLASS START: " + testClass.getName());
    LoggerUtil.info(SEP);
  }

  @Override
  public void onAfterClass(ITestClass testClass) {
    LoggerUtil.info(SEP);
    LoggerUtil.info("CLASS END:   " + testClass.getName());
    LoggerUtil.info(SEP);
  }

  // Method
  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.isTestMethod()) {
      setCurrentTestName(testResult.getName());
      LoggerUtil.info(SEP);
      LoggerUtil.info("METHOD START: " + testResult.getMethod().getMethodName());
      logParameters(TestParameterManager.getAllParameters());
      LoggerUtil.info(SEP);
    }
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.isTestMethod()) {
              // Log MyTest annotation values
        MyTestLogger.logTestMetadata(method.getTestMethod().getConstructorOrMethod().getMethod());
      TestResult result = ReportCollector.getOrCreate(testResult.getName());
      Throwable throwable = testResult.getThrowable();
      if (throwable == null && testResult.getStatus() == ITestResult.SUCCESS) {
        LoggerUtil.info("Assertion passed in test: " + testResult.getName());
        result.setStatus(TestResult.Status.PASSED);
      } else if (throwable != null) {
        LoggerUtil.error(
            "Assertion failed in test: "
                + testResult.getName()
                + ". Reason: "
                + throwable.getMessage());
        result.setStatus(TestResult.Status.FAILED);
        result.addLog("Assertion failed: " + throwable.getMessage());
        // Take screenshot on failure
        String screenshotPath =
            SeleniumHelper.takeScreenshot(DriverManager.getDriver(), testResult.getName());
        if (screenshotPath != null) {
          LoggerUtil.info("Screenshot saved at: " + screenshotPath);
          result.addScreenshot(screenshotPath);
        }
      } else if (testResult.getStatus() == ITestResult.SKIP) {
        result.setStatus(TestResult.Status.SKIPPED);
      }
      // Add logs and metadata
      result.addLog("Test method: " + testResult.getName());
      result.addMetadata("class", testResult.getTestClass().getName());
      result.addMetadata("method", testResult.getName());
      // Add all test parameters to metadata
      for (Map.Entry<String, String> entry : TestParameterManager.getAllParameters().entrySet()) {
        result.addMetadata("param_" + entry.getKey(), entry.getValue());
      }
      LoggerUtil.info(SEP);
      LoggerUtil.info("METHOD END:   " + testResult.getMethod().getMethodName());
      LoggerUtil.info("RESULT:       " + getStatusString(testResult));
      logParameters(TestParameterManager.getAllParameters());
      LoggerUtil.info(SEP);
    }
  }

  // Step logging (static for use in tests)
  public static void logStep(String step) {
    logStep(step, false);
  }

  public static void logStep(String step, boolean takeScreenshot) {
    String testName = getCurrentTestName();
    if (testName != null) {
      TestResult result = ReportCollector.getOrCreate(testName);
      if (takeScreenshot) {
        String screenshotPath =
            SeleniumHelper.takeScreenshot(DriverManager.getDriver(), testName + "_step");
        if (screenshotPath != null) {
          result.addLog("STEP: " + step + "||" + screenshotPath);
          LoggerUtil.info("Step screenshot saved at: " + screenshotPath);
        } else {
          result.addLog("STEP: " + step);
        }
      } else {
        result.addLog("STEP: " + step);
      }
    }
  }

  // ITestListener (for completeness, not strictly needed)
  @Override
  public void onTestStart(ITestResult result) {}

  @Override
  public void onTestSuccess(ITestResult result) {}

  @Override
  public void onTestFailure(ITestResult result) {}

  @Override
  public void onTestSkipped(ITestResult result) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {}

  // Utility
  private void logParameters(Map<String, String> params) {
    if (params == null || params.isEmpty()) {
      LoggerUtil.info("Parameters: (none)");
      return;
    }
    LoggerUtil.info("Parameters:");
    for (Map.Entry<String, String> entry : params.entrySet()) {
      LoggerUtil.info("  - " + entry.getKey() + " = " + entry.getValue());
    }
  }

  private String getStatusString(ITestResult result) {
    switch (result.getStatus()) {
      case ITestResult.SUCCESS:
        return "PASS";
      case ITestResult.FAILURE:
        return "FAIL";
      case ITestResult.SKIP:
        return "SKIP";
      default:
        return "UNKNOWN";
    }
  }
}
