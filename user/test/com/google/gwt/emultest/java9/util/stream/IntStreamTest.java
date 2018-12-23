package com.google.gwt.emultest.java9.util.stream;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.stream.IntStream;

public class IntStreamTest extends EmulTestBase {
  public void testIterate() {
    assertEquals(
        new int[] {10, 11, 12, 13, 14},
        IntStream.iterate(0, i -> i < 15, i -> i + 1).skip(10).toArray());
  }

  public void testTakeWhile() {
    assertEquals(
        new int[] {1, 2},
        IntStream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 3).toArray()
    );
    assertEquals(0, IntStream.of(1, 2, 3, 4, 5).takeWhile(i -> i > 2).count());
  }

  public void testDropWhile() {
    assertEquals(
        new int[] {3, 4, 5},
        IntStream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 3).toArray()
    );
    assertEquals(
        new int[] {1, 2, 3, 4, 5},
        IntStream.of(1, 2, 3, 4, 5).dropWhile(i -> i > 2).toArray()
    );
  }
}
