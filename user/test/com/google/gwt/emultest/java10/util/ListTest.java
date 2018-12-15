package com.google.gwt.emultest.java10.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest extends com.google.gwt.emultest.java9.util.ListTest {
  public void testCopyOf() {
    assertIsImmutableListOf(List.copyOf(List.of("a", "b")), "a", "b");
    assertIsImmutableListOf(List.copyOf(Arrays.asList("a", "b")), "a", "b");

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("a");
    arrayList.add("b");
    List<String> copy = List.copyOf(arrayList);
    assertIsImmutableListOf(copy, "a", "b");

    // verify that mutating the original doesn't affect the copy
    arrayList.add("c");
    assertEquals(2, copy.size());
    assertFalse(copy.contains("c"));

    arrayList.remove(0);
    assertEquals(2, copy.size());
    assertTrue(copy.contains("a"));

    // ensure that null values in the collection result in a NPE
    try {
      List.copyOf(Arrays.asList("a", null));
      fail("Expected NullPointerException passing copy a collection with a null value");
    } catch (NullPointerException ignore) {
      // expected
    }

  }
}
