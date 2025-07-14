package com.testautomation.core;

import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerUtil {
  private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(
        new Formatter() {
          private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

          @Override
          public String format(LogRecord record) {
            String timestamp = sdf.format(new java.util.Date(record.getMillis()));
            long threadId = record.getThreadID();
            return String.format(
                "[%s] [%s] [Thread-%d] %s%n",
                timestamp, record.getLevel(), threadId, formatMessage(record));
          }
        });
    logger.addHandler(handler);
    try {
      java.io.File reportsDir = java.nio.file.Paths.get("reports").toFile();
      if (!reportsDir.exists()) reportsDir.mkdirs();
      java.nio.file.Path logPath = java.nio.file.Paths.get("reports", "execution.log");
      java.util.logging.FileHandler fileHandler =
          new java.util.logging.FileHandler(logPath.toString(), true);
      fileHandler.setFormatter(handler.getFormatter());
      logger.addHandler(fileHandler);
    } catch (Exception e) {
      logger.warning("Failed to set up file logging: " + e.getMessage());
    }
    logger.setUseParentHandlers(false);
    logger.setLevel(Level.INFO);
  }

  public static void info(String message) {
    logger.info(message);
  }

  public static void warning(String message) {
    logger.warning(message);
  }

  public static void error(String message) {
    logger.severe(message);
  }
}
