package com.testautomation.tests.common;

import com.testautomation.core.DriverManager;
import com.testautomation.core.LoggerUtil;
import com.testautomation.core.SeleniumHelper;
import com.testautomation.core.TestParameterManager;
import com.testautomation.listeners.ParameterInitializerListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ParameterInitializerListener.class})
public abstract class BaseTest {
  protected WebDriver driver;

  @BeforeClass
  public void setUpClass() {
    if (getClass().equals(BaseTest.class)) {
      SeleniumHelper.cleanScreenshotsFolder();
    }
    driver = DriverManager.getDriver();
    driver.get(TestParameterManager.getUrl());
    LoggerUtil.info("WebDriver initialized in BaseTest (per class)");
  }

  @AfterClass
  public void tearDownClass() {
    LoggerUtil.info("Quitting WebDriver in BaseTest (per class)");
    DriverManager.quitDriver();
  }
}
