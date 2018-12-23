package com.google.gwt.emultest.java10.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.NoSuchElementException;
import java.util.OptionalInt;

public class OptionalIntTest extends EmulTestBase {
  public void testOrElseThrow() {
    try {
      OptionalInt.empty().orElseThrow();
      fail("Expected NoSuchElementException from empty Optional: orElseThrow");
    } catch (NoSuchElementException ignore) {
      // expected
    }

    int value = OptionalInt.of(10).orElseThrow();
    assertEquals(10, value);
  }
}
