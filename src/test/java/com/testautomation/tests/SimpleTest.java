package com.testautomation.tests;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    
    @MyTest(
        testCaseId = "SIMPLE-001",
        description = "Simple test to verify framework setup",
        author = "CI System",
        tags = {"smoke", "simple"}
    )
    @Test
    public void testFrameworkSetup() {
        LoggerUtil.info("Running simple framework test");
        Assert.assertTrue(true, "Framework should be working");
        LoggerUtil.info("Simple test completed successfully");
    }
    
    @MyTest(
        testCaseId = "SIMPLE-002",
        description = "Test basic assertion",
        author = "CI System",
        tags = {"smoke", "simple"}
    )
    @Test
    public void testBasicAssertion() {
        LoggerUtil.info("Testing basic assertion");
        String expected = "Hello";
        String actual = "Hello";
        Assert.assertEquals(actual, expected, "Strings should match");
        LoggerUtil.info("Basic assertion test completed");
    }
} 