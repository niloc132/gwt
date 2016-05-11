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

import java.lang.Double;
import java.lang.Override;
import java.lang.Runnable;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/**
 * See <a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/DoubleStream.html">
 * the official Java API doc</a> for details.
 */
public interface DoubleStream extends BaseStream<Double,DoubleStream> {

  static final class ValueConsumer implements DoubleConsumer {
    double value;

    @Override
    public void accept(double value) {
      this.value = value;
    }
  }

  static DoubleStream.Builder builder() {
    return new Builder() {
      private double[] items = new double[0];
      @Override
      public void accept(double t) {
        if (items == null) {
          throw new IllegalStateException("Builder already built");
        }
        items[items.length] = t;
      }

      @Override
      public DoubleStream build() {
        if (items == null) {
          throw new IllegalStateException("Builder already built");
        }
        DoubleStream stream = StreamSupport.doubleStream(Spliterators.spliterator(items, Spliterator.ORDERED), false);
        items = null;
        return stream;
      }
    };
  }

  static DoubleStream concat(DoubleStream a, DoubleStream b) {
    return Stream.of(a, b).flatMapToDouble(Function.identity());
  }

  static DoubleStream empty() {
    return new EmptyDoubleStreamSource(null);
  }

  static DoubleStream generate(DoubleSupplier s) {
    return iterate(s.getAsDouble(), prev -> s.getAsDouble());
  }

  static DoubleStream iterate(double seed, DoubleUnaryOperator f) {
    return StreamSupport.doubleStream(new Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, Spliterator.ORDERED) {
      private double next = seed;

      @Override
      public boolean tryAdvance(DoubleConsumer action) {
        action.accept(next);
        next = f.applyAsDouble(next);
        return true;
      }
    }, false);
  }

  static DoubleStream of(double... values) {
    return StreamSupport.doubleStream(Spliterators.spliterator(values, Spliterator.ORDERED), false);
  }

  static DoubleStream of(double t) {
    return of(new double[]{t});
  }

  public interface Builder extends DoubleConsumer {
    @Override
    void accept(double t);

    default DoubleStream.Builder add(double t) {
      accept(t);
      return this;
    }

    DoubleStream build();
  }

  boolean allMatch(DoublePredicate predicate);

  boolean anyMatch(DoublePredicate predicate);

  OptionalDouble average();

  Stream<Double> boxed();

  <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R,R> combiner);

  long count();

  DoubleStream distinct();

  DoubleStream filter(DoublePredicate predicate);

  OptionalDouble findAny();

  OptionalDouble findFirst();

  DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper);

  void forEach(DoubleConsumer action);

  void forEachOrdered(DoubleConsumer action);

  PrimitiveIterator.OfDouble iterator();

  DoubleStream limit(long maxSize);

  DoubleStream map(DoubleUnaryOperator mapper);

  IntStream mapToInt(DoubleToIntFunction mapper);

  LongStream mapToLong(DoubleToLongFunction mapper);

  <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper);

  OptionalDouble max();

  OptionalDouble min();

  boolean noneMatch(DoublePredicate predicate);

  DoubleStream parallel();

  DoubleStream peek(DoubleConsumer action);

  OptionalDouble reduce(DoubleBinaryOperator op);

  double reduce(double identity, DoubleBinaryOperator op);

  DoubleStream sequential();

  DoubleStream skip(long n);

  DoubleStream sorted();

  Spliterator.OfDouble spliterator();

  double sum();

  DoubleSummaryStatistics summaryStatistics();

  double[] toArray();

  static class EmptyDoubleStreamSource extends TerminatableStream implements DoubleStream {
    public EmptyDoubleStreamSource(TerminatableStream previous) {
      super(previous);
    }

    @Override
    public DoubleStream filter(DoublePredicate predicate) {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream map(DoubleUnaryOperator mapper) {
      throwIfTerminated();
      return this;
    }

    @Override
    public <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper) {
      throwIfTerminated();
      return new Stream.EmptyStreamSource<U>(this);
    }

    @Override
    public IntStream mapToInt(DoubleToIntFunction mapper) {
      throwIfTerminated();
      return new IntStream.EmptyIntStreamSource(this);
    }

    @Override
    public LongStream mapToLong(DoubleToLongFunction mapper) {
      throwIfTerminated();
      return new LongStream.EmptyLongStreamSource(this);
    }

    @Override
    public DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream distinct() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream sorted() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream peek(DoubleConsumer action) {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream limit(long maxSize) {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream skip(long n) {
      throwIfTerminated();
      return this;
    }

    @Override
    public void forEach(DoubleConsumer action) {
      terminate();
      // do nothing
    }

    @Override
    public void forEachOrdered(DoubleConsumer action) {
      terminate();
      // do nothing
    }

    @Override
    public double[] toArray() {
      terminate();
      return new double[0];
    }

    @Override
    public double reduce(double identity, DoubleBinaryOperator op) {
      terminate();
      return identity;
    }

    @Override
    public OptionalDouble reduce(DoubleBinaryOperator op) {
      terminate();
      return OptionalDouble.empty();
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
      terminate();
      return supplier.get();
    }

    @Override
    public double sum() {
      terminate();
      return 0;
    }

    @Override
    public OptionalDouble min() {
      terminate();
      return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble max() {
      terminate();
      return OptionalDouble.empty();
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
    public DoubleSummaryStatistics summaryStatistics() {
      terminate();
      return new DoubleSummaryStatistics();
    }

    @Override
    public boolean anyMatch(DoublePredicate predicate) {
      terminate();
      return false;
    }

    @Override
    public boolean allMatch(DoublePredicate predicate) {
      terminate();
      return true;
    }

    @Override
    public boolean noneMatch(DoublePredicate predicate) {
      terminate();
      return true;
    }

    @Override
    public OptionalDouble findFirst() {
      terminate();
      return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble findAny() {
      terminate();
      return OptionalDouble.empty();
    }

    @Override
    public Stream<Double> boxed() {
      throwIfTerminated();
      return Stream.empty();
    }

    @Override
    public DoubleStream sequential() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream parallel() {
      throwIfTerminated();
      return this;
    }

    @Override
    public PrimitiveIterator.OfDouble iterator() {
      terminate();
      return Spliterators.iterator(Spliterators.emptyDoubleSpliterator());
    }

    @Override
    public Spliterator.OfDouble spliterator() {
      terminate();
      return Spliterators.emptyDoubleSpliterator();
    }

    @Override
    public boolean isParallel() {
      throwIfTerminated();
      return false;
    }

    @Override
    public DoubleStream unordered() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream onClose(Runnable closeHandler) {
      throwIfTerminated();
      return this;
    }

    @Override
    public void close() {
      //TODO?
    }
  }


  static final class MapToIntSpliterator extends Spliterators.AbstractIntSpliterator {
    private final DoubleToIntFunction map;
    private final Spliterator.OfDouble original;

    public MapToIntSpliterator(DoubleToIntFunction map, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final IntConsumer action) {
      return original.tryAdvance((double u) -> action.accept(map.applyAsInt(u)));
    }
  }
  static final class MapToObjSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
    private final DoubleFunction<? extends T> map;
    private final Spliterator.OfDouble original;

    public MapToObjSpliterator(DoubleFunction<? extends T> map, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final Consumer<? super T> action) {
      return original.tryAdvance((double u) -> action.accept(map.apply(u)));
    }
  }
  static final class MapToLongSpliterator extends Spliterators.AbstractLongSpliterator {
    private final DoubleToLongFunction map;
    private final Spliterator.OfDouble original;

    public MapToLongSpliterator(DoubleToLongFunction map, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final LongConsumer action) {
      return original.tryAdvance((double u) -> action.accept(map.applyAsLong(u)));
    }
  }
  static final class MapToDoubleSpliterator extends Spliterators.AbstractDoubleSpliterator {
    private final DoubleUnaryOperator map;
    private final Spliterator.OfDouble original;

    public MapToDoubleSpliterator(DoubleUnaryOperator map, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics());
      this.map = map;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final DoubleConsumer action) {
      return original.tryAdvance((double u) -> action.accept(map.applyAsDouble(u)));
    }
  }

  static final class FilterSpliterator extends Spliterators.AbstractDoubleSpliterator {
    private final DoublePredicate filter;
    private final Spliterator.OfDouble original;

    private boolean found;

    public FilterSpliterator(DoublePredicate filter, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics() & ~Spliterator.SIZED);
      this.filter = filter;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(final DoubleConsumer action) {
      found = false;
      while (!found && original.tryAdvance((double item) -> {
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
  static final class SkipSpliterator extends Spliterators.AbstractDoubleSpliterator {
    private long skip;
    private final Spliterator.OfDouble original;

    public SkipSpliterator(long skip, Spliterator.OfDouble original) {
      super(original.estimateSize() - skip, original.characteristics());
      this.skip = skip;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(DoubleConsumer action) {
      while (--skip >= 0) {
        original.tryAdvance((double ignore) -> {});
      }
      return original.tryAdvance(action);
    }
  }
  static final class LimitSpliterator extends Spliterators.AbstractDoubleSpliterator {
    private final long limit;
    private final Spliterator.OfDouble original;
    private int position = 0;

    public LimitSpliterator(long limit, Spliterator.OfDouble original) {
      super(original.estimateSize(), original.characteristics());
      this.limit = limit;
      this.original = original;
    }

    @Override
    public boolean tryAdvance(DoubleConsumer action) {
      if (limit <= position) {
        return false;
      }
      position++;
      return original.tryAdvance(action);
    }
  }

  static class DoubleStreamSource extends TerminatableStream implements DoubleStream {
    private final Spliterator.OfDouble spliterator;

    public DoubleStreamSource(TerminatableStream previous, Spliterator.OfDouble spliterator) {
      super(previous);
      this.spliterator = spliterator;
    }

    // terminals

    @Override
    public void forEach(DoubleConsumer action) {
      forEachOrdered(action);
    }

    @Override
    public void forEachOrdered(DoubleConsumer action) {
      terminate();
      spliterator.forEachRemaining(action);
    }

    @Override
    public double[] toArray() {
      terminate();
      double[] entries = new double[0];
      // this is legal in js, since the array will be backed by a JS array
      spliterator.forEachRemaining((double value) -> entries[entries.length] = value);

      return entries;
    }

    @Override
    public double reduce(double identity, DoubleBinaryOperator op) {
      terminate();
      ValueConsumer holder = new ValueConsumer();
      holder.value = identity;
      spliterator.forEachRemaining((double value) -> holder.accept(op.applyAsDouble(holder.value, value)));
      return holder.value;
    }

    @Override
    public OptionalDouble reduce(DoubleBinaryOperator op) {
      ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance(holder)) {
        return OptionalDouble.of(reduce(holder.value, op));
      }
      return OptionalDouble.empty();
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
      terminate();
      final R initial = supplier.get();
      spliterator.forEachRemaining((double value) -> accumulator.accept(initial, value));
      return initial;
    }

    @Override
    public double sum() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      spliterator.forEachRemaining((double value) -> holder.value += value);
      return holder.value;
    }

    @Override
    public OptionalDouble min() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance((double value) -> holder.value = value)) {
        spliterator.forEachRemaining((double value) -> holder.value = Math.min(holder.value, value));
        return OptionalDouble.of(holder.value);
      }
      return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble max() {
      terminate();
      final ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance((double value) -> holder.value = value)) {
        spliterator.forEachRemaining((double value) -> holder.value = Math.max(holder.value, value));
        return OptionalDouble.of(holder.value);
      }
      return OptionalDouble.empty();
    }

    @Override
    public long count() {
      terminate();
      long count = 0;
      while (spliterator.tryAdvance((double value) -> {})) {
        count++;
      }
      return count;
    }

    @Override
    public OptionalDouble average() {
      terminate();
      final ValueConsumer sum = new ValueConsumer();
      final ValueConsumer count = new ValueConsumer();
      final DoubleConsumer action = value -> {
        sum.value += value;
        count.value++;
      };
      if (spliterator.tryAdvance(action)) {
        spliterator.forEachRemaining(action);
        return OptionalDouble.of(sum.value / count.value);
      }
      return OptionalDouble.empty();
    }

    @Override
    public DoubleSummaryStatistics summaryStatistics() {
      return collect(
          DoubleSummaryStatistics::new,
          (s,d) -> s.accept(d),
          (s1,s2) -> s1.combine(s2)
      );
    }

    @Override
    public boolean anyMatch(DoublePredicate predicate) {
      return filter(predicate).findFirst().isPresent();
    }

    @Override
    public boolean allMatch(DoublePredicate predicate) {
      return !filter(item -> !predicate.test(item)).findFirst().isPresent();
    }

    @Override
    public boolean noneMatch(DoublePredicate predicate) {
      return allMatch(item -> !predicate.test(item));
    }

    @Override
    public OptionalDouble findFirst() {
      terminate();
      ValueConsumer holder = new ValueConsumer();
      if (spliterator.tryAdvance(holder)) {
        return OptionalDouble.of(holder.value);
      }
      return OptionalDouble.empty();
    }

    @Override
    public OptionalDouble findAny() {
      return findFirst();
    }

    @Override
    public PrimitiveIterator.OfDouble iterator() {
      terminate();
      return Spliterators.iterator(spliterator);
    }

    @Override
    public Spliterator.OfDouble spliterator() {
      terminate();
      return spliterator;
    }

    // end terminals

    // intermediates

    @Override
    public DoubleStream filter(DoublePredicate predicate) {
      throwIfTerminated();
      return new DoubleStreamSource(this, new FilterSpliterator(predicate, spliterator));
    }

    @Override
    public DoubleStream map(DoubleUnaryOperator mapper) {
      throwIfTerminated();
      return new DoubleStreamSource(this, new MapToDoubleSpliterator(mapper, spliterator));
    }

    @Override
    public <U> Stream<U> mapToObj(DoubleFunction<? extends U> mapper) {
      throwIfTerminated();
      return new Stream.StreamSource(this, new MapToObjSpliterator<U>(mapper, spliterator));
    }

    @Override
    public IntStream mapToInt(DoubleToIntFunction mapper) {
      throwIfTerminated();
      return new IntStream.IntStreamSource(this, new MapToIntSpliterator(mapper, spliterator));
    }

    @Override
    public LongStream mapToLong(DoubleToLongFunction mapper) {
      throwIfTerminated();
      return new LongStream.LongStreamSource(this, new MapToLongSpliterator(mapper, spliterator));
    }

    @Override
    public DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {
      throwIfTerminated();
      throwIfTerminated();
      final Spliterator<? extends DoubleStream> spliteratorOfStreams = new MapToObjSpliterator<DoubleStream>(mapper, spliterator);
      return new DoubleStreamSource(this, new Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 0) {
        DoubleStream nextStream;
        Spliterator.OfDouble next;
        @Override
        public boolean tryAdvance(DoubleConsumer action) {
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
    public DoubleStream distinct() {
      throwIfTerminated();
      HashSet<Double> seen = new HashSet<>();
      return filter(seen::add);
    }

    @Override
    public DoubleStream sorted() {
      throwIfTerminated();
      return new DoubleStreamSource(this, new Spliterators.AbstractDoubleSpliterator(spliterator.estimateSize(), spliterator.characteristics() | Spliterator.SORTED) {
        Spliterator.OfDouble ordered = null;
        @Override
        public boolean tryAdvance(DoubleConsumer action) {
          if (ordered == null) {
            double[] list = new double[0];
            spliterator.forEachRemaining((double item) -> list[list.length] = item);
            Arrays.sort(list);
            ordered = Spliterators.spliterator(list, characteristics());
          }
          return ordered.tryAdvance(action);
        }
      });
    }

    @Override
    public DoubleStream peek(DoubleConsumer action) {
      throwIfTerminated();
      return new DoubleStreamSource(this, new Spliterators.AbstractDoubleSpliterator(spliterator.estimateSize(), spliterator.characteristics()) {
        @Override
        public boolean tryAdvance(final DoubleConsumer innerAction) {
          return spliterator.tryAdvance((double item) -> {
            action.accept(item);
            innerAction.accept(item);
          });
        }
      });
    }

    @Override
    public DoubleStream limit(long maxSize) {
      throwIfTerminated();
      return new DoubleStreamSource(this, new LimitSpliterator(maxSize, spliterator));
    }

    @Override
    public DoubleStream skip(long n) {
      throwIfTerminated();
      return new DoubleStreamSource(this, new SkipSpliterator(n, spliterator));
    }

    @Override
    public Stream<Double> boxed() {
      throwIfTerminated();
      return mapToObj(Double::valueOf);
    }

    @Override
    public DoubleStream sequential() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream parallel() {
      throwIfTerminated();
      return this;
    }

    @Override
    public boolean isParallel() {
      throwIfTerminated();
      return false;
    }

    @Override
    public DoubleStream unordered() {
      throwIfTerminated();
      return this;
    }

    @Override
    public DoubleStream onClose(Runnable closeHandler) {
      throwIfTerminated();

      return null;//TODO
    }

    @Override
    public void close() {
      //TODO
    }
  }
}
