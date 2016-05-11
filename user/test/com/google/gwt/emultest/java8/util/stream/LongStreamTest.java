/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.emultest.java8.util.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Tests {@link LongStream}.
 */
public class LongStreamTest extends StreamTestBase {

  public void testEmptyStream() {
    LongStream empty = LongStream.empty();
    assertEquals(0, empty.count());
    try {
      empty.count();
      fail("second terminal operation should have thrown IllegalStateEx");
    } catch (IllegalStateException expected) {
      // expected
    }

    assertEquals(0, LongStream.empty().limit(2).toArray().length);
    assertEquals(0L, LongStream.empty().count());
    assertEquals(0L, LongStream.empty().limit(2).count());

    assertFalse(LongStream.empty().findFirst().isPresent());
    assertFalse(LongStream.empty().findAny().isPresent());
    assertFalse(LongStream.empty().max().isPresent());
    assertFalse(LongStream.empty().min().isPresent());
    assertTrue(LongStream.empty().noneMatch(item -> true));
    assertTrue(LongStream.empty().allMatch(item -> true));
    assertFalse(LongStream.empty().anyMatch(item -> true));
    assertEquals(new long[0], LongStream.empty().toArray());
  }

  public void testStreamOfOne() {
    Supplier<LongStream> one = () -> LongStream.of(1);
    assertEquals(new long[]{1l}, one.get().toArray());
    assertEquals(1L, one.get().count());
    assertEquals(1, one.get().findFirst().getAsLong());
    assertEquals(1, one.get().findAny().getAsLong());
  }

  public void testBuilder() {
    LongStream s = LongStream.builder()
        .add(1l)
        .add(3l)
        .add(2l)
        .build();

    assertEquals(
        new long[] {1l, 3l, 2l},
        s.toArray()
    );

    LongStream.Builder builder = LongStream.builder();
    LongStream built = builder.build();
    assertEquals(0l, built.count());
    try {
      builder.build();
      fail("build() after build() should fail");
    } catch (IllegalStateException expected) {
      // expected
    }
    try {
      builder.add(10l);
      fail("add() after build() should fail");
    } catch (IllegalStateException expected) {
      // expected
    }
  }

  public void testGenerate() {
    // infinite, but if you limit it is already too short to skip much
    assertEquals(new long[0], LongStream.generate(makeGenerator()).limit(4).skip(5).toArray());

    assertEquals(new long[]{10l, 11l, 12l, 13l, 14l}, LongStream.generate(makeGenerator()).skip(10).limit(5).toArray());
  }

  private LongSupplier makeGenerator() {
    return new LongSupplier() {
      long next = 0l;

      @Override
      public long getAsLong() {
        return next++;
      }
    };
  }

  public void testRange() {
    assertEquals(new long[] {1l, 2l, 3l, 4l}, LongStream.range(1, 5).toArray());
    assertEquals(new long[] {-1l, 0l, 1l, 2l, 3l, 4l}, LongStream.range(-1, 5).toArray());
    assertEquals(new long[] {}, LongStream.range(1, -5).toArray());
    assertEquals(new long[] {}, LongStream.range(-1, -5).toArray());
  }

  public void testRangeClosed() {
    assertEquals(new long[] {1l, 2l, 3l, 4l, 5l}, LongStream.rangeClosed(1, 5).toArray());
    assertEquals(new long[] {-1l, 0l, 1l, 2l, 3l, 4l, 5l}, LongStream.rangeClosed(-1, 5).toArray());
    assertEquals(new long[] {}, LongStream.rangeClosed(1, -5).toArray());
    assertEquals(new long[] {}, LongStream.rangeClosed(-1, -5).toArray());
  }

  public void testToArray() {
    assertEquals(new long[0], LongStream.of().toArray());
    assertEquals(new long[] {1l}, LongStream.of(1l).toArray());
    assertEquals(new long[] {3l, 2l, 0l}, LongStream.of(3l,2l,0l).toArray());
  }

  public void testReduce() {
    long reduced = LongStream.of(1l, 2l, 4l).reduce(0, Long::sum);
    assertEquals(7, reduced);

    reduced = LongStream.of().reduce(0, Long::sum);
    assertEquals(0l, reduced);

    OptionalLong maybe = LongStream.of(1l, 4l, 8l).reduce(Long::sum);
    assertTrue(maybe.isPresent());
    assertEquals(13l, maybe.getAsLong());
    maybe = LongStream.of().reduce(Long::sum);
    assertFalse(maybe.isPresent());
  }

  public void testFilter() {
    // unconsumed stream never runs filter
    boolean[] data = {false};
    LongStream.of(1l, 2l, 3l).filter(i -> data[0] |= true);
    assertFalse(data[0]);

    // one result
    assertEquals(
        new long[] {1l},
        LongStream.of(1l, 2l, 3l, 4l, 3l).filter(a -> a == 1).toArray()
    );
    // zero results
    assertEquals(
        new long[0],
        LongStream.of(1l, 2l, 3l, 4l, 3l).filter(a -> false).toArray()
    );
    // two results
    assertEquals(
        new long[] {2l, 4l},
        LongStream.of(1l, 2l, 3l, 4l, 3l).filter(a -> a % 2 == 0).toArray()
    );
    // all
    assertEquals(
        new long[] {1l, 2l, 3l, 4l, 3l},
        LongStream.of(1l, 2l, 3l, 4l, 3l).filter(a -> true).toArray()
    );
  }

  public void testMap() {
    // unconsumed stream never runs map
    int[] data = {0};
    LongStream.of(1l, 2l, 3l).map(i -> data[0]++);
    assertEquals(0, data[0]);

    assertEquals(
        new long[] {2l, 4l, 6l},
        LongStream.of(1l, 2l, 3l).map(i -> i * 2).toArray()
    );
  }

  public void testPeek() {
    // unconsumed stream never peeks
    boolean[] data = {false};
    LongStream.of(1l, 2l, 3l).peek(i -> data[0] |= true);
    assertFalse(data[0]);

    // make sure we saw it all in order
    long[] items = new long[] {1l, 2l, 3l};
    List<Long> peeked = new ArrayList<>();
    LongStream.of(items).peek(item -> peeked.add(item)).forEach(item -> {
      // do nothing, just run
    });
    assertEquals(items.length, peeked.size());
    for (int i = 0; i < items.length; i++) {
      assertEquals(items[i], (long) peeked.get(i));
    }
  }

  // same impl, no parallel in browser
  public void testFindFirstOrAny() {
    OptionalLong any = LongStream.of(1l, 2l).findAny();
    assertTrue(any.isPresent());
    assertEquals(1l, any.getAsLong());
  }

  public void testAnyMatch() {
    // all
    assertTrue(LongStream.of(1l, 2l).anyMatch(s -> true));

    // some
    assertTrue(LongStream.of(1l, 2l).anyMatch(s -> s == 1l));

    // none
    assertFalse(LongStream.of(1l, 2l).anyMatch(s -> false));
  }

  public void testAllMatch() {
    // all
    assertTrue(LongStream.of(1l, 2l).allMatch(s -> true));

    // some
    assertFalse(LongStream.of(1l, 2l).allMatch(s -> s == 1l));

    // none
    assertFalse(LongStream.of(1l, 2l).allMatch(s -> false));
  }

  public void testNoneMatch() {
    // all
    assertFalse(LongStream.of(1l, 2l).noneMatch(s -> true));

    // some
    assertFalse(LongStream.of(1l, 2l).noneMatch(s -> s == 1l));

    // none
    assertTrue(LongStream.of(1l, 2l).noneMatch(s -> false));
  }

  public void testFlatMap() {
    assertEquals(0l, LongStream.empty().flatMap(value -> LongStream.of(1l)).count());
    assertEquals(0l, LongStream.of(1l).flatMap(value -> LongStream.empty()).count());
    assertEquals(0l, LongStream.of(1l).flatMap(value -> LongStream.of()).count());
    assertEquals(0l, LongStream.of().flatMap(value -> LongStream.of(1l)).count());
    assertEquals(1l, LongStream.of(1l).flatMap(value -> LongStream.of(1l)).count());

    LongStream values = LongStream.of(1l, 2l, 3l);

    assertEquals(
        new long[] {1l, 2l, 2l, 4l, 3l, 6l},
        values.flatMap(i -> LongStream.of(i, i * 2)).toArray()
    );
  }

  public void testMapToOthers() {
    Supplier<LongStream> s = () -> LongStream.of(1, 2, 10);

    assertEquals(
        new String[] {"1", "2", "10"},
        s.get().mapToObj(String::valueOf).toArray(String[]::new)
    );

    assertEquals(
        new int[] {1, 2, 10},
        s.get().mapToInt(i -> (int) i).toArray()
    );

    assertEquals(
        new double[] {1d, 2d, 10d},
        s.get().mapToDouble(i -> (double) i).toArray()
    );
  }

  public void testDistinct() {
    long[] distinct = LongStream.of(1l, 2l, 3l, 2l).distinct().toArray();
    assertEquals(3, distinct.length);
    assertEquals(1l + 2l + 3l, distinct[0] + distinct[1] + distinct[2]);
  }

  public void testSorted() {
    long[] sorted = LongStream.of(3l, 1l, 2l).sorted().toArray();
    assertEquals(new long[] {1l, 2l, 3l}, sorted);
  }

  public void testMinMax() {
    Supplier<LongStream> stream = () -> LongStream.of(2l, 3l, 4l, 1l);

    assertEquals(1l, stream.get().min().orElse(0));
    assertEquals(4l, stream.get().max().orElse(0));

    assertFalse(stream.get().filter(a -> false).max().isPresent());
    assertFalse(stream.get().filter(a -> false).min().isPresent());
  }

  public void testCountLimitSkip() {
    Supplier<LongStream> stream = () -> LongStream.of(1l, 2l, 3l, 4l);

    assertEquals(4l, stream.get().count());

    assertEquals(4l, stream.get().limit(4).count());
    assertEquals(4l, stream.get().limit(5).count());
    assertEquals(3l, stream.get().limit(3).count());

    assertEquals(3l, stream.get().skip(1).limit(3).count());

    assertEquals(2l, stream.get().limit(3).skip(1).count());

    assertEquals(1l, stream.get().skip(3).count());

    assertEquals(new long[] {3l, 4l}, stream.get().skip(2).limit(3).toArray());
    assertEquals(new long[] {3l}, stream.get().skip(2).limit(1).toArray());

    assertEquals(new long[] {4l}, stream.get().skip(3).toArray());
    assertEquals(new long[] {}, stream.get().skip(5).toArray());

    assertEquals(new long[] {1l, 2l}, stream.get().limit(2).toArray());

    assertEquals(new long[] {2l}, stream.get().limit(2).skip(1).toArray());
  }

  public void testBoxed() {
    Supplier<LongStream> stream = () -> LongStream.of(1l, 2l);
    Stream<Long> expected = stream.get().mapToObj(Long::valueOf);
    assertEquals(expected.toArray(), stream.get().boxed().toArray());
  }

  public void testAsOtherPrimitive() {
    Supplier<LongStream> stream = () -> LongStream.of(1l, 2l);
    DoubleStream expectedDoubleStream = stream.get().boxed().mapToDouble(i -> i.doubleValue());
    DoubleStream actualDoubleStream = stream.get().asDoubleStream();
    assertEquals(expectedDoubleStream.toArray(), actualDoubleStream.toArray());
  }

  public void testSummaryStats() {
    Supplier<LongStream> stream = () -> LongStream.of(1l, 2l, 3l);
    LongSummaryStatistics summaryStats = stream.get().summaryStatistics();
    assertEquals(3l, summaryStats.getCount());
    assertEquals(1l, summaryStats.getMin());
    assertEquals(2l, summaryStats.getAverage(), 0d);
    assertEquals(3l, summaryStats.getMax());
    assertEquals(6l, summaryStats.getSum());

    summaryStats.accept(6l);
    assertEquals(4l, summaryStats.getCount());
    assertEquals(1l, summaryStats.getMin());
    assertEquals(3l, summaryStats.getAverage(), 0d);
    assertEquals(6l, summaryStats.getMax());
    assertEquals(12l, summaryStats.getSum());

    LongSummaryStatistics combinedSumStats = stream.get().summaryStatistics();
    combinedSumStats.combine(LongStream.of(4l, 5l, 6l, 0l).summaryStatistics());
    assertEquals(7l, combinedSumStats.getCount());
    assertEquals(0l, combinedSumStats.getMin());
    assertEquals(3l, combinedSumStats.getAverage(), 0d);
    assertEquals(6l, combinedSumStats.getMax());
    assertEquals(21l, combinedSumStats.getSum());
  }

  public void testAverage() {
    assertFalse(LongStream.empty().average().isPresent());
    assertEquals(2.0d, LongStream.of(1l, 2l, 3l).average().getAsDouble(), 0d);
    assertEquals(0d, LongStream.of(1l, 2l, -3l).average().getAsDouble(), 0d);
    assertEquals(-2.0d, LongStream.of(-1l, -2l, -3l).average().getAsDouble(), 0d);
  }

  public void testSum() {
    assertEquals(6l, LongStream.of(1l, 2l, 3l).sum());
    assertEquals(0l, LongStream.of(1l, 2l, -3l).sum());
    assertEquals(-6l, LongStream.of(-1l, -2l, -3l).sum());
  }

  public void testCollect() {
    String val = LongStream.of(1l, 2l, 3l, 4l, 5l).collect(StringBuilder::new, 
        (s1, s2) -> s1.append(s2), 
        (s1, s2) -> s1.append(s2)).toString();

    assertEquals("12345", val);
  }

  public void testForEach() {
    List<Long> vals = new ArrayList<Long>();
    LongStream.of(1l, 2l, 3l, 4l, 5l).forEach(i -> vals.add(i));
    assertEquals(5, vals.size());
    assertEquals(new Long[] {1l, 2l, 3l, 4l, 5l}, vals.toArray(new Long[vals.size()]));
  }

  public void testIterator() {
    List<Long> vals = new ArrayList<Long>();
    Iterator<Long> iterator = LongStream.of(1l, 2l, 3l, 4l, 5l).iterator();
    while (iterator.hasNext()) {
      vals.add(iterator.next());
    }
    assertEquals(5, vals.size());
    assertEquals(new Long[] {1l, 2l, 3l, 4l, 5l}, vals.toArray(new Long[vals.size()]));
  }

  public void testSpliterator() {
    Spliterator<Long> spliterator = LongStream.of(1l, 2l, 3l, 4l, 5l).spliterator();
    assertEquals(5, spliterator.estimateSize());
    assertEquals(5, spliterator.getExactSizeIfKnown());
    
    List<Long> vals = new ArrayList<Long>();
    while(spliterator.tryAdvance(i -> vals.add(i)));
    
    assertEquals(5, vals.size());
    assertEquals(new Long[] {1l, 2l, 3l, 4l, 5l}, vals.toArray(new Long[vals.size()]));
  }
}
