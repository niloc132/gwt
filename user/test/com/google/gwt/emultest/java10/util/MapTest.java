package com.google.gwt.emultest.java10.util;

import java.util.HashMap;
import java.util.Map;

public class MapTest extends com.google.gwt.emultest.java9.util.MapTest {
  public void testCopyOf() {
    assertIsImmutableMapOf(Map.copyOf(Map.of("a", 1)), "a");

    HashMap<String, Integer> hashMap = new HashMap<>();
    hashMap.put("a", 1);
    Map<String, Integer> copy = Map.copyOf(hashMap);
    assertIsImmutableMapOf(copy, "a");

    // verify that mutating the original has no effect on the copy
    hashMap.put("b", 2);
    assertFalse(copy.containsKey("b"));
    assertEquals(1, copy.size());

    hashMap.put("a", 5);
    assertEquals(1, (int) copy.get("a"));


    // ensure that null values result in a NPE
    HashMap<String, Integer> mapWithNullKey = new HashMap<>();
    mapWithNullKey.put(null, 1);
    try {
      Map.copyOf(mapWithNullKey);
      fail("expected NullPointerException from copyOf with a null key");
    } catch (NullPointerException ignored) {
      // expected
    }

    HashMap<String, Integer> mapWithNullValue = new HashMap<>();
    mapWithNullValue.put("key", null);
    try {
      Map.copyOf(mapWithNullValue);
      fail("expected NullPointerException from copyOf with a null value");
    } catch (NullPointerException ignored) {
      // expected
    }
  }
}
