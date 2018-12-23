package com.google.gwt.emultest.java9.util.stream;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.stream.DoubleStream;

public class DoubleStreamTest extends EmulTestBase {
  public void testIterate() {
    assertEquals(
        new double[] {10, 11, 12, 13, 14},
        DoubleStream.iterate(0, i -> i < 15, i -> i + 1).skip(10).toArray());
  }

  public void testTakeWhile() {
    assertEquals(
        new double[] {1, 2},
        DoubleStream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 3).toArray()
    );
    assertEquals(0, DoubleStream.of(1, 2, 3, 4, 5).takeWhile(i -> i > 2).count());
  }

  public void testDropWhile() {
    assertEquals(
        new double[] {3, 4, 5},
        DoubleStream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 3).toArray()
    );
    assertEquals(
        new double[] {1, 2, 3, 4, 5},
        DoubleStream.of(1, 2, 3, 4, 5).dropWhile(i -> i > 2).toArray()
    );
  }
}
