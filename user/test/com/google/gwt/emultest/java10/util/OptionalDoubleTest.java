package com.google.gwt.emultest.java10.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public class OptionalDoubleTest extends EmulTestBase {
  public void testOrElseThrow() {
    try {
      OptionalDouble.empty().orElseThrow();
      fail("Expected NoSuchElementException from empty Optional: orElseThrow");
    } catch (NoSuchElementException ignore) {
      // expected
    }

    double value = OptionalDouble.of(10).orElseThrow();
    assertEquals(10, value);
  }
}
