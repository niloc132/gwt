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

import com.google.gwt.core.client.GwtScriptOnly;
import com.google.gwt.i18n.shared.CurrencyList;
import com.google.gwt.i18n.shared.DateTimeFormatInfo;
import com.google.gwt.i18n.shared.LocalizedNames;
import com.google.gwt.i18n.shared.VariantSelector;

// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA:
//  cldrVersion=21.0
//  date=$Date: 2012-02-07 13:32:35 -0500 (Tue, 07 Feb 2012) $
//  number=$Revision: 6546 $
//  type=root

/**
 * Locale information for the "rwk" locale.

 */
@GwtScriptOnly
public class LocaleInfoImpl_rwk extends LocaleInfoImpl {
  
  @Override
  public String getLocaleName() {
    return "rwk";
  }
  
  @Override
  protected CurrencyList createCurrencyList() {
    return new com.google.gwt.i18n.client.cldr.CurrencyListImpl_rwk();
  }
  
  @Override
  protected DateTimeFormatInfo createDateTimeFormatInfo() {
    return new com.google.gwt.i18n.shared.cldr.DateTimeFormatInfoImpl_rwk();
  }
  
  @Override
  protected LocalizedNames createLocalizedNames() {
    return new com.google.gwt.i18n.client.cldr.LocalizedNamesImpl_rwk();
  }
  
  @Override
  protected VariantSelector createPluralRule() {
    return new com.google.gwt.i18n.shared.cldr.PluralRuleImpl_bda8dd4b();
  }
}
