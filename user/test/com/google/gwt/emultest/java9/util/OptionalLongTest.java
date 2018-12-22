package com.google.gwt.emultest.java9.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.OptionalLong;
import java.util.stream.Stream;

public class OptionalLongTest extends EmulTestBase {
  public void testIfPresentOrElse() {
    int[] called = {0};
    OptionalLong.of(10).ifPresentOrElse(value -> {
      assertEquals(10.0, value);
      called[0]++;
    }, () -> {
      fail("should not call empty action");
    });
    assertEquals(1, called[0]);
    called[0] = 0;
    OptionalLong.empty().ifPresentOrElse(ignore -> {
      fail("Should not call present action");
    }, () -> called[0]++);

  }

  public void testStream() {
    assertEquals(0, OptionalLong.empty().stream().count());
    assertEquals(1, OptionalLong.of(10).stream().count());

    assertEquals(
        new long[] {10, 100, 1000},
        Stream.of(
            OptionalLong.of(10),
            OptionalLong.empty(),
            OptionalLong.of(100),
            OptionalLong.of(1000)
        ).flatMapToLong(OptionalLong::stream).toArray()
    );

  }
}
