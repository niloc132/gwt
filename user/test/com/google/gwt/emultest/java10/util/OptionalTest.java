package com.google.gwt.emultest.java10.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest extends EmulTestBase {
  public void testOrElseThrow() {
    try {
      Optional.empty().orElseThrow();
      fail("Expected NoSuchElementException from empty Optional: orElseThrow");
    } catch (NoSuchElementException ignore) {
      // expected
    }

    String value = Optional.of("value").orElseThrow();
    assertEquals("value", value);
  }
}
