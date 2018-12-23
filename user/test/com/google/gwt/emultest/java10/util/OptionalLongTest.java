package com.google.gwt.emultest.java10.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.NoSuchElementException;
import java.util.OptionalLong;

public class OptionalLongTest extends EmulTestBase {
  public void testOrElseThrow() {
    try {
      OptionalLong.empty().orElseThrow();
      fail("Expected NoSuchElementException from empty Optional: orElseThrow");
    } catch (NoSuchElementException ignore) {
      // expected
    }

    long value = OptionalLong.of(10).orElseThrow();
    assertEquals(10, value);
  }
}
