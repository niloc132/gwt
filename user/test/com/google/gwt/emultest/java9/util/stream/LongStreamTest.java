package com.google.gwt.emultest.java9.util.stream;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.stream.LongStream;

public class LongStreamTest extends EmulTestBase {
  public void testIterate() {
    assertEquals(
        new long[] {10, 11, 12, 13, 14},
        LongStream.iterate(0, i -> i < 15, i -> i + 1).skip(10).toArray());
  }

  public void testTakeWhile() {
    assertEquals(
        new long[] {1, 2},
        LongStream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 3).toArray()
    );
    assertEquals(0, LongStream.of(1, 2, 3, 4, 5).takeWhile(i -> i > 2).count());
  }

  public void testDropWhile() {
    assertEquals(
        new long[] {3, 4, 5},
        LongStream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 3).toArray()
    );
    assertEquals(
        new long[] {1, 2, 3, 4, 5},
        LongStream.of(1, 2, 3, 4, 5).dropWhile(i -> i > 2).toArray()
    );
  }
}
