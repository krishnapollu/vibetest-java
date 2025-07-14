package com.testautomation.listeners;

import com.testautomation.core.TestParameterManager;
import java.util.HashMap;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ParameterInitializerListener implements ITestListener {
  @Override
  public void onStart(ITestContext context) {
    Map<String, String> params = new HashMap<>();
    for (String paramName : context.getCurrentXmlTest().getAllParameters().keySet()) {
      params.put(paramName, context.getCurrentXmlTest().getParameter(paramName));
    }
    TestParameterManager.initialize(params);
  }

  // Other ITestListener methods can be left empty
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

  @Override
  public void onFinish(ITestContext context) {}
}
