package com.testautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    
    @Test
    public void testFrameworkSetup() {
        System.out.println("Running simple framework test");
        Assert.assertTrue(true, "Framework should be working");
        System.out.println("Simple test completed successfully");
    }
    
    @Test
    public void testBasicAssertion() {
        System.out.println("Testing basic assertion");
        String expected = "Hello";
        String actual = "Hello";
        Assert.assertEquals(actual, expected, "Strings should match");
        System.out.println("Basic assertion test completed");
    }
    
    @Test
    public void testMathOperation() {
        System.out.println("Testing math operation");
        int result = 2 + 2;
        Assert.assertEquals(result, 4, "2 + 2 should equal 4");
        System.out.println("Math test completed successfully");
    }
} 