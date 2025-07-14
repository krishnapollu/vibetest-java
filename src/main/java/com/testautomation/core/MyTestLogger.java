package com.testautomation.core;

import java.lang.reflect.Method;

public class MyTestLogger {
  public static void logTestMetadata(Method method) {
    if (method.isAnnotationPresent(MyTest.class)) {
      MyTest annotation = method.getAnnotation(MyTest.class);
      LoggerUtil.info("[MyTest] TestCaseId: " + annotation.testCaseId());
      LoggerUtil.info("[MyTest] Description: " + annotation.description());
      LoggerUtil.info("[MyTest] Author: " + annotation.author());
      if (annotation.tags().length > 0) {
        LoggerUtil.info("[MyTest] Tags: " + String.join(", ", annotation.tags()));
      }
    }
  }
} 