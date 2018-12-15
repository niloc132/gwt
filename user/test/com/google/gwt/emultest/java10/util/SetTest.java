package com.google.gwt.emultest.java10.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest extends com.google.gwt.emultest.java9.util.SetTest {
  public void testCopyOf() {
    assertIsImmutableSetOf(Set.copyOf(Set.of("a", "b")), "a", "b");
    assertIsImmutableSetOf(Set.copyOf(Arrays.asList("a", "b")), "a", "b");

    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("a");
    Set<String> copy = Set.copyOf(hashSet);
    assertIsImmutableSetOf(copy, "a");

    // verify that mutating the original has no effect on the copy
    hashSet.add("c");
    assertEquals(2, copy.size());
    assertFalse(copy.contains("c"));

    hashSet.remove("a");
    assertEquals(2, copy.size());
    assertTrue(copy.contains("a"));

    // ensure that null value result in a NPE
    try {
      Set.copyOf(Arrays.asList("a", null));
      fail("Expected NullPointerException from null item in collection passed to copyOf");
    } catch (NullPointerException ignored) {
      // expected
    }

    // ensure that duplicate values result in IAE
    try {
      Set.copyOf(Arrays.asList("a", "a"));
      fail("Expected IllegalArgumentException from duplicated items in collection passed to " +
          "copyOf");
    } catch (IllegalArgumentException ignore) {
      // expected
    }
  }
}
