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

package java.util.stream;

import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.Runnable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * See <a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/LongStream.html">
 * the official Java API doc</a> for details.
 */
public interface LongStream extends BaseStream<Long,LongStream> {

  static final class ValueConsumer implements LongConsumer {
    long value;

    @Override
    public void accept(long value) {
      this.value = value;
    }
  }

  static LongStream.Builder builder() {
    return new Builder() {
      private long[] items = new long[0];
      @Override
      public void accept(long t) {
        if (items == null) {
          throw new IllegalStateException("Builder already built");
        }
        items[items.length] = t;
      }

      @Override
      public LongStream build() {
        if (items == null) {
          throw new IllegalStateException("Builder already built");
        }
        LongStream stream = StreamSupport.longStream(Spliterators.spliterator(items, Spliterator.ORDERED), false);
        items = null;
        return stream;
      }
    };  }

  static LongStream concat(LongStream a, LongStream b) {
    return Stream.of(a, b).flatMapToLong(Function.identity());
  }

  static LongStream empty() {
    return new EmptyLongStreamSource(null);
  }

  static LongStream generate(LongSupplier s) {
    return iterate(s.getAsLong(), prev -> s.getAsLong());
  }

  static LongStream iterate(long seed, LongUnaryOperator f) {
    return StreamSupport.longStream(new Spliterators.AbstractLongSpliterator(Long.MAX_VALUE, Spliterator.ORDERED) {
      private long next = seed;

      @Override
      public boolean tryAdvance(LongConsumer action) {
        action.accept(next);
        next = f.applyAsLong(next);
        return true;
      }
    }, false);
  }

  static LongStream of(long... values) {
    return StreamSupport.longStream(Spliterators.spliterator(values, Spliterator.ORDERED), false);
  }

  static LongStream of(long t) {
    return of(new long[]{t});
  }

  static LongStream range(long startInclusive, long endExclusive) {
    return null;// TODO
  }

  static LongStream rangeClosed(long startInclusive, long endInclusive) {
    return null;// TODO
  }

  public interface Builder extends LongConsumer {
    @Override
    void accept(long t);

    default LongStream.Builder add(long t) {
      accept(t);
      return this;
    }

    LongStream build();
  }

  boolean allMatch(LongPredicate predicate);

  boolean anyMatch(LongPredicate predicate);

  DoubleStream asDoubleStream();

  OptionalDouble average();

  Stream<Long> boxed();

  <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner);

  long count();

  LongStream distinct();

  LongStream filter(LongPredicate predicate);

  OptionalLong findAny();

  OptionalLong findFirst();

  LongStream flatMap(LongFunction<? extends LongStream> mapper);

  void forEach(LongConsumer action);

  void forEachOrdered(LongConsumer action);

  PrimitiveIterator.OfLong iterator();

  LongStream limit(long maxSize);

  LongStream map(LongUnaryOperator mapper);

  DoubleStream mapToDouble(LongToDoubleFunction mapper);

  IntStream mapToInt(LongToIntFunction mapper);

  <U> Stream<U> mapToObj(LongFunction<? extends U> mapper);

  OptionalLong max();

  OptionalLong min();

  boolean noneMatch(LongPredicate predicate);

  LongStream parallel();

  LongStream peek(LongConsumer action);

  OptionalLong reduce(LongBinaryOperator op);

  long reduce(long identity, LongBinaryOperator op);

  LongStream sequential();

  LongStream skip(long n);

  LongStream sorted();

  Spliterator.OfLong spliterator();

  long sum();

  LongSummaryStatistics summaryStatistics();

  long[] toArray();

  static class EmptyLongStreamSource extends TerminatableStream implements LongStream {
    public EmptyLongStreamSource(TerminatableStream previous) {
      super(previous);
    }

    @Override
    public LongStream filter(LongPredicate predicate) {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream map(LongUnaryOperator mapper) {
      throwIfTerminated();
      return this;
    }

    @Override
    public <U> Stream<U> mapToObj(LongFunction<? extends U> mapper) {
      throwIfTerminated();
      return new Stream.EmptyStreamSource<U>(this);
    }

    @Override
    public IntStream mapToInt(LongToIntFunction mapper) {
      throwIfTerminated();
      return new IntStream.EmptyIntStreamSource(this);
    }

    @Override
    public DoubleStream mapToDouble(LongToDoubleFunction mapper) {
      throwIfTerminated();
      return new DoubleStream.EmptyDoubleStreamSource(this);
    }

    @Override
    public LongStream flatMap(LongFunction<? extends LongStream> mapper) {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream distinct() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream sorted() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream peek(LongConsumer action) {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream limit(long maxSize) {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream skip(long n) {
      throwIfTerminated();
      return this;
    }

    @Override
    public void forEach(LongConsumer action) {
      terminate();
    }

    @Override
    public void forEachOrdered(LongConsumer action) {
      terminate();
    }

    @Override
    public long[] toArray() {
      terminate();
      return new long[0];
    }

    @Override
    public long reduce(long identity, LongBinaryOperator op) {
      terminate();
      return identity;
    }

    @Override
    public OptionalLong reduce(LongBinaryOperator op) {
      terminate();
      return OptionalLong.empty();
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
      terminate();
      return supplier.get();
    }

    @Override
    public long sum() {
      terminate();
      return 0;
    }

    @Override
    public OptionalLong min() {
      terminate();
      return OptionalLong.empty();
    }

    @Override
    public OptionalLong max() {
      terminate();
      return OptionalLong.empty();
    }

    @Override
    public long count() {
      terminate();
      return 0;
    }

    @Override
    public OptionalDouble average() {
      terminate();
      return OptionalDouble.empty();
    }

    @Override
    public LongSummaryStatistics summaryStatistics() {
      terminate();
      return new LongSummaryStatistics();
    }

    @Override
    public boolean anyMatch(LongPredicate predicate) {
      terminate();
      return false;
    }

    @Override
    public boolean allMatch(LongPredicate predicate) {
      terminate();
      return true;
    }

    @Override
    public boolean noneMatch(LongPredicate predicate) {
      terminate();
      return true;
    }

    @Override
    public OptionalLong findFirst() {
      terminate();
      return OptionalLong.empty();
    }

    @Override
    public OptionalLong findAny() {
      terminate();
      return OptionalLong.empty();
    }

    @Override
    public DoubleStream asDoubleStream() {
      throwIfTerminated();
      return new DoubleStream.EmptyDoubleStreamSource(this);
    }

    @Override
    public Stream<Long> boxed() {
      throwIfTerminated();
      return new Stream.EmptyStreamSource<Long>(this);
    }

    @Override
    public LongStream sequential() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream parallel() {
      throwIfTerminated();
      return this;
    }

    @Override
    public PrimitiveIterator.OfLong iterator() {
      terminate();
      return Spliterators.iterator(spliterator());
    }

    @Override
    public Spliterator.OfLong spliterator() {
      terminate();
      return Spliterators.emptyLongSpliterator();
    }

    @Override
    public boolean isParallel() {
      throwIfTerminated();
      return false;
    }

    @Override
    public LongStream unordered() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream onClose(Runnable closeHandler) {
      throwIfTerminated();
      return this;
    }

    @Override
    public void close() {
      // TODO
    }
  }
  static final class MapToIntSpliterator extends Spliterators.AbstractIntSpliterator {
    private final LongToIntFunction map;
    private final Spliterator.OfLong original;

    public MapToIntSpliterator(LongToIntFunction map, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final IntConsumer action) {
      return original.tryAdvance((long u) -> action.accept(map.applyAsInt(u)));
    }
  }
  static final class MapToObjSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
    private final LongFunction<? extends T> map;
    private final Spliterator.OfLong original;

    public MapToObjSpliterator(LongFunction<? extends T> map, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final Consumer<? super T> action) {
      return original.tryAdvance((long u) -> action.accept(map.apply(u)));
    }
  }
  static final class MapToLongSpliterator extends Spliterators.AbstractLongSpliterator {
    private final LongUnaryOperator map;
    private final Spliterator.OfLong original;

    public MapToLongSpliterator(LongUnaryOperator map, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final LongConsumer action) {
      return original.tryAdvance((long u) -> action.accept(map.applyAsLong(u)));
    }
  }
  static final class MapToDoubleSpliterator extends Spliterators.AbstractDoubleSpliterator {
    private final LongToDoubleFunction map;
    private final Spliterator.OfLong original;

    public MapToDoubleSpliterator(LongToDoubleFunction map, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final DoubleConsumer action) {
      return original.tryAdvance((long u) -> action.accept(map.applyAsDouble(u)));
    }
  }

  static final class FilterSpliterator extends Spliterators.AbstractLongSpliterator {
    private final LongPredicate filter;
    private final Spliterator.OfLong original;

    private boolean found;

    public FilterSpliterator(LongPredicate filter, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics() & ~Spliterator.SIZED);
      this.filter = filter;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final LongConsumer action) {
      found = false;
      while (!found && original.tryAdvance((long item) -> {
        if (filter.test(item)) {
          found = true;
          action.accept(item);
        }
      })) {
        // do nothing, work is done in tryAdvance
      }

      return found;
    }
  }
  static final class SkipSpliterator extends Spliterators.AbstractLongSpliterator {
    private long skip;
    private final Spliterator.OfLong original;

    public SkipSpliterator(long skip, Spliterator.OfLong original) {
      super(original.estimateSize() - skip, original.characteristics());
      this.skip = skip;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(LongConsumer action) {
      while (--skip >= 0) {
        original.tryAdvance((long ignore) -> {});
      }
      return original.tryAdvance(action);
    }
  }
  static final class LimitSpliterator extends Spliterators.AbstractLongSpliterator {
    private final long limit;
    private final Spliterator.OfLong original;
    private int position = 0;

    public LimitSpliterator(long limit, Spliterator.OfLong original) {
      super(original.estimateSize(), original.characteristics());
      this.limit = limit;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(LongConsumer action) {
      if (limit <= position) {
        return false;
      }
      position++;
      return original.tryAdvance(action);
    }
  }

  static class LongStreamSource extends TerminatableStream implements LongStream {
    private final Spliterator.OfLong spliterator;

    public LongStreamSource(TerminatableStream previous, Spliterator.OfLong spliterator) {
      super(previous);
      this.spliterator = spliterator;
    }

    // terminals

    @Override
    public void forEach(LongConsumer action) {
      forEachOrdered(action);
    }

    @Override
    public void forEachOrdered(LongConsumer action) {
      terminate();
      spliterator.forEachRemaining(action);
    }

    @Override
    public long[] toArray() {
      terminate();
      long[] entries = new long[0];
      // this is legal in js, since the array will be backed by a JS array
      spliterator.forEachRemaining((long value) -> entries[entries.length] = value);

      return entries;
    }

    @Override
    public long reduce(long identity, LongBinaryOperator op) {
      terminate();
      ValueConsumer holder = new ValueConsumer();
      holder.value = identity;
      spliterator.forEachRemaining((long value) -> holder.accept(op.applyAsLong(holder.value, value)));
      return holder.value;
    }

    @Override
    public OptionalLong reduce(LongBinaryOperator op) {
      ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance(holder)) {
        return OptionalLong.of(reduce(holder.value, op));
      }
      return OptionalLong.empty();
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
      terminate();
      final R initial = supplier.get();
      spliterator.forEachRemaining((long value) -> accumulator.accept(initial, value));
      return initial;
    }

    @Override
    public long sum() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      spliterator.forEachRemaining((long value) -> holder.value += value);
      return holder.value;
    }

    @Override
    public OptionalLong min() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance((long value) -> holder.value = value)) {
        spliterator.forEachRemaining((long value) -> holder.value = Math.min(holder.value, value));
        return OptionalLong.of(holder.value);
      }
      return OptionalLong.empty();
    }

    @Override
    public OptionalLong max() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance((long value) -> holder.value = value)) {
        spliterator.forEachRemaining((long value) -> holder.value = Math.max(holder.value, value));
        return OptionalLong.of(holder.value);
      }
      return OptionalLong.empty();
    }

    @Override
    public long count() {
      terminate();
      long count = 0;
      while (spliterator.tryAdvance((long value) -> {})) {
        count++;
      }
      return count;
    }

    @Override
    public OptionalDouble average() {
      terminate();
      final ValueConsumer sum = new ValueConsumer();
      final ValueConsumer count = new ValueConsumer();
      final LongConsumer action = value -> {
        sum.value += value;
        count.value++;
      };
      if (spliterator.tryAdvance(action)) {
        spliterator.forEachRemaining(action);
        return OptionalDouble.of((double) sum.value / count.value);
      }
      return OptionalDouble.empty();
    }

    @Override
    public LongSummaryStatistics summaryStatistics() {
      return collect(
          LongSummaryStatistics::new,
          (s,l) -> s.accept(l),
          (s1,s2) -> s1.combine(s2)
      );
    }

    @Override
    public boolean anyMatch(LongPredicate predicate) {
      return filter(predicate).findFirst().isPresent();
    }

    @Override
    public boolean allMatch(LongPredicate predicate) {
      return !filter(item -> !predicate.test(item)).findFirst().isPresent();
    }

    @Override
    public boolean noneMatch(LongPredicate predicate) {
      return allMatch(item -> !predicate.test(item));
    }

    @Override
    public OptionalLong findFirst() {
      terminate();
      ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance(holder)) {
        return OptionalLong.of(holder.value);
      }
      return OptionalLong.empty();
    }

    @Override
    public OptionalLong findAny() {
      return findFirst();
    }

    @Override
    public PrimitiveIterator.OfLong iterator() {
      terminate();
      return Spliterators.iterator(spliterator);
    }

    @Override
    public Spliterator.OfLong spliterator() {
      terminate();
      return spliterator;
    }
    // end terminals

    // intermediates
    @Override
    public LongStream filter(LongPredicate predicate) {
      throwIfTerminated();
      return new LongStreamSource(this, new FilterSpliterator(predicate, spliterator));
    }

    @Override
    public LongStream map(LongUnaryOperator mapper) {
      throwIfTerminated();
      return new LongStream.LongStreamSource(this, new MapToLongSpliterator(mapper, spliterator));
    }

    @Override
    public <U> Stream<U> mapToObj(LongFunction<? extends U> mapper) {
      throwIfTerminated();
      return new Stream.StreamSource(this, new MapToObjSpliterator<U>(mapper, spliterator));
    }

    @Override
    public IntStream mapToInt(LongToIntFunction mapper) {
      throwIfTerminated();
      return new IntStream.IntStreamSource(this, new MapToIntSpliterator(mapper, spliterator));
    }

    @Override
    public DoubleStream mapToDouble(LongToDoubleFunction mapper) {
      throwIfTerminated();
      return new DoubleStream.DoubleStreamSource(this, new MapToDoubleSpliterator(mapper, spliterator));
    }

    @Override
    public LongStream flatMap(LongFunction<? extends LongStream> mapper) {
      throwIfTerminated();
      final Spliterator<? extends LongStream> spliteratorOfStreams = new MapToObjSpliterator<>(mapper, spliterator);
      return new LongStreamSource(this, new Spliterators.AbstractLongSpliterator(Long.MAX_VALUE, 0) {
        LongStream nextStream;
        Spliterator.OfLong next;
        @Override
        public boolean tryAdvance(LongConsumer action) {
          // look for a new spliterator
          while (advanceToNextSpliterator()) {
            // if we have one, try to read and use it
            if (next.tryAdvance(action)) {
              return true;
            } else {
              nextStream.close();
              nextStream = null;
              // failed, null it out so we can find another
              next = null;
            }
          }
          return false;
        }
        private boolean advanceToNextSpliterator() {
          while (next == null) {
            if (!spliteratorOfStreams.tryAdvance(n -> {
              if (n != null) {
                nextStream = n;
                next = n.spliterator();
              }
            })) {
              return false;
            }
          }
          return true;
        }
      });
    }

    @Override
    public LongStream distinct() {
      throwIfTerminated();
      HashSet<Long> seen = new HashSet<>();
      return filter(seen::add);
    }

    @Override
    public LongStream sorted() {
      throwIfTerminated();
      return new LongStreamSource(this, new Spliterators.AbstractLongSpliterator(spliterator.estimateSize(), spliterator.characteristics() | Spliterator.SORTED) {
        Spliterator.OfLong ordered = null;
        @Override
        public boolean tryAdvance(LongConsumer action) {
          if (ordered == null) {
            long[] list = new long[0];
            spliterator.forEachRemaining((long item) -> list[list.length] = item);
            Arrays.sort(list);
            ordered = Spliterators.spliterator(list, characteristics());
          }
          return ordered.tryAdvance(action);
        }
      });
    }

    @Override
    public LongStream peek(LongConsumer action) {
      throwIfTerminated();
      return new LongStreamSource(this, new Spliterators.AbstractLongSpliterator(spliterator.estimateSize(), spliterator.characteristics()) {
        @Override
        public boolean tryAdvance(final LongConsumer innerAction) {
          return spliterator.tryAdvance((long item) -> {
            action.accept(item);
            innerAction.accept(item);
          });
        }
      });
    }

    @Override
    public LongStream limit(long maxSize) {
      throwIfTerminated();
      return new LongStreamSource(this, new LimitSpliterator(maxSize, spliterator));
    }

    @Override
    public LongStream skip(long n) {
      throwIfTerminated();
      return new LongStreamSource(this, new SkipSpliterator(n, spliterator));
    }

    @Override
    public DoubleStream asDoubleStream() {
      return mapToDouble(x -> (double) x);
    }

    @Override
    public Stream<Long> boxed() {
      throwIfTerminated();
      return mapToObj(Long::valueOf);
    }

    @Override
    public LongStream sequential() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream parallel() {
      throwIfTerminated();
      return this;
    }

    @Override
    public boolean isParallel() {
      throwIfTerminated();
      return false;
    }

    @Override
    public LongStream unordered() {
      throwIfTerminated();
      return this;
    }

    @Override
    public LongStream onClose(Runnable closeHandler) {
      throwIfTerminated();

      return null;// TODO
    }

    @Override
    public void close() {
      // TODO
    }
  }

}
