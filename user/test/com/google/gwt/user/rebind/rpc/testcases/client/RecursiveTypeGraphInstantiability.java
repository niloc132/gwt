/*
 * Copyright 2025 GWT Project Authors
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
package com.google.gwt.user.rebind.rpc.testcases.client;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Test case for 10181, where it is possible to end up with a TIC with apparently no instantiable
 * subtypes.
 */
public interface RecursiveTypeGraphInstantiability {
  /**
   * Base interface, used as the root type.
   */
  interface A extends IsSerializable {
  }

  /**
   * Implements A, and references C, which also has a field of type A. This cycle apparently causes
   * A to be marked as "done" before its subtypes have been completely checked, and stops later
   * checks from taking place.
   */
  class B implements A {
    private B b;
    private C c;
  }

  /**
   * Independent serializable type, reachable from B, but references A. This causes A to be re-checked
   * while C is processed, which leads to A being marked as having no subtypes.
   */
  class C implements IsSerializable {
    private A a;
  }
}
