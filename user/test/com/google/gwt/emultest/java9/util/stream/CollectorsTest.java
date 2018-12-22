package com.google.gwt.emultest.java9.util.stream;

import com.google.gwt.emultest.java.util.EmulTestBase;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

import static com.google.gwt.emultest.java8.util.stream.CollectorsTest.applyItems;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.toList;

public class CollectorsTest extends EmulTestBase {

  public void testFlatMapping() {
    // since applyItems tests the same inputs multiple times, we need fresh stream instances as they can't be reused
    Collector<Collection<String>, ?, List<String>> flatMapping = flatMapping(Collection::stream,
        toList());
    applyItems(Arrays.asList("a", "b"), flatMapping, Collections.singletonList("a"),
        Collections.singletonList("b"));
    applyItems(Arrays.asList("c", "d"), flatMapping, Collections.emptyList(), Arrays.asList("c", "d"));
  }

  public void testFiltering() {
    Collector<String, ?, List<String>> filtering = filtering(s -> s.equals("a"), toList());
    applyItems(Collections.singletonList("a"), filtering, "a", "b");
    applyItems(Collections.emptyList(), filtering, "c", "d");
    applyItems(Arrays.asList("a", "a"), filtering, "a", "a");
  }
}
