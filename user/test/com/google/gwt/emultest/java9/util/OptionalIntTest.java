package com.google.gwt.emultest.java9.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalIntTest extends EmulTestBase {
  public void testIfPresentOrElse() {
    int[] called = {0};
    OptionalInt.of(10).ifPresentOrElse(value -> {
      assertEquals(10.0, value);
      called[0]++;
    }, () -> {
      fail("should not call empty action");
    });
    assertEquals(1, called[0]);
    called[0] = 0;
    OptionalInt.empty().ifPresentOrElse(ignore -> {
      fail("Should not call present action");
    }, () -> called[0]++);

  }

  public void testStream() {
    assertEquals(0, OptionalInt.empty().stream().count());
    assertEquals(1, OptionalInt.of(10).stream().count());

    assertEquals(
        new int[] {10, 100, 1000},
        Stream.of(
            OptionalInt.of(10),
            OptionalInt.empty(),
            OptionalInt.of(100),
            OptionalInt.of(1000)
        ).flatMapToInt(OptionalInt::stream).toArray()
    );

  }
}
