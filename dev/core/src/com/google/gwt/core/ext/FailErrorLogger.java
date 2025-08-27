package com.google.gwt.core.ext;

/**
 * A TreeLogger which throws an assertion failure if any error is logged. Intended for use in
 * tests, to fail fast when an error occurs.
 */
public class FailErrorLogger extends TreeLogger {
  @Override
  public TreeLogger branch(Type type, String msg, Throwable caught,
                           HelpInfo helpInfo) {
    if (type == TreeLogger.ERROR) {
      throw new AssertionError(msg, caught);
    }
    return this;
  }

  @Override
  public boolean isLoggable(Type type) {
    return true;
  }

  @Override
  public void log(Type type, String msg, Throwable caught, HelpInfo helpInfo) {
    if (type == TreeLogger.ERROR) {
      throw new AssertionError(msg, caught);
    }
  }
}
