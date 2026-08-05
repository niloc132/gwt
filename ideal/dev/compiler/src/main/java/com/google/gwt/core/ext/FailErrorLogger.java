/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
