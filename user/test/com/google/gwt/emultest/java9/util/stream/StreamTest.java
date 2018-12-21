package com.google.gwt.emultest.java9.util.stream;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.stream.Stream;

public class StreamTest extends EmulTestBase {
  public void testIterate() {
    assertEquals(
        new Integer[] {10, 11, 12, 13, 14},
        Stream.iterate(0, i -> i < 15, i -> i + 1).skip(10).toArray(Integer[]::new));
  }

  public void testOfNullable() {
    assertEquals(0, Stream.ofNullable(null).count());
    assertEquals(
        new String[] {"abc"},
        Stream.ofNullable("abc").toArray(String[]::new)
    );
  }

  public void testTakeWhile() {
    assertEquals(
        new Integer[] {1, 2},
        Stream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 3).toArray(Integer[]::new)
    );
    assertEquals(0, Stream.of(1, 2, 3, 4, 5).takeWhile(i -> i > 2).count());
  }

  public void testDropWhile() {
    assertEquals(
        new Integer[] {3, 4, 5},
        Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 3).toArray(Integer[]::new)
    );
    assertEquals(
        new Integer[] {1, 2, 3, 4, 5},
        Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i > 2).toArray(Integer[]::new)
    );
  }
}
