package com.google.gwt.emultest.java9.util;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class OptionalDoubleTest extends EmulTestBase {
  public void testIfPresentOrElse() {
    int[] called = {0};
    OptionalDouble.of(10.0).ifPresentOrElse(value -> {
      assertEquals(10.0, value);
      called[0]++;
    }, () -> {
      fail("should not call empty action");
    });
    assertEquals(1, called[0]);
    called[0] = 0;
    OptionalDouble.empty().ifPresentOrElse(ignore -> {
      fail("Should not call present action");
    }, () -> called[0]++);

  }

  public void testStream() {
    assertEquals(0, OptionalDouble.empty().stream().count());
    assertEquals(1, OptionalDouble.of(10.0).stream().count());

    assertEquals(
        new double[] {10.0, 100.0, 1000.0},
        Stream.of(
            OptionalDouble.of(10.0),
            OptionalDouble.empty(),
            OptionalDouble.of(100.0),
            OptionalDouble.of(1000.0)
        ).flatMapToDouble(OptionalDouble::stream).toArray()
    );

  }
}
