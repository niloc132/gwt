/*
 * Copyright 2013 Google Inc.
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
package com.google.gwt.i18n.shared.cldr;

import com.google.gwt.i18n.shared.impl.VariantSelectorBase;
// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA

/**
 * Plural rule implementation for locales:
 *   gv
 */
public class PluralRuleImpl_gv extends VariantSelectorBase {
  
  public PluralRuleImpl_gv() {
    super(new VariantForm[] {
      VariantForm.ONE,
    });
  };
  
  @Override
  public String getFormDescription(VariantForm form) {
    switch (form) {
      case ONE:
        return "n mod 10 in 1..2 or n mod 20 is 0";
      default:
        return "anything else";
    }
  }
  
  @Override
  public VariantForm select(double n) {
    double n10 = n % 10;
    double n20 = n % 20;
    if (((n - (long) n == 0.0) && (n10 >= 1 && n10 <= 2)) || (n20 == 0)) {
      return VariantForm.ONE;
    }
    return VariantForm.OTHER;
  }
}
