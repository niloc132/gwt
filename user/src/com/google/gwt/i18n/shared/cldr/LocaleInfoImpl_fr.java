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

import com.google.gwt.i18n.shared.CurrencyList;
import com.google.gwt.i18n.shared.DateTimeFormatInfo;
import com.google.gwt.i18n.shared.ListPatterns;
import com.google.gwt.i18n.shared.LocaleDisplayNames;
import com.google.gwt.i18n.shared.LocalizedNames;
import com.google.gwt.i18n.shared.NumberConstants;
import com.google.gwt.i18n.shared.VariantSelector;

// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA:
//  cldrVersion=21.0
//  date=$Date: 2012-02-07 13:32:35 -0500 (Tue, 07 Feb 2012) $
//  number=$Revision: 6546 Google $
//  type=root

/**
 * Locale information for the "fr" locale.

 */
public class LocaleInfoImpl_fr extends LocaleInfoImpl {
  
  @Override
  public String getLocaleName() {
    return "fr";
  }
  
  @Override
  protected CurrencyList createCurrencyList() {
    return new com.google.gwt.i18n.shared.cldr.CurrencyListImpl_fr();
  }
  
  @Override
  protected DateTimeFormatInfo createDateTimeFormatInfo() {
    return new com.google.gwt.i18n.shared.cldr.DateTimeFormatInfoImpl_fr();
  }
  
  @Override
  protected ListPatterns createListPatterns() {
    return new com.google.gwt.i18n.shared.cldr.ListPatternsImpl_fr();
  }
  
  @Override
  protected LocaleDisplayNames createLocaleDisplayNames() {
    return new com.google.gwt.i18n.shared.cldr.LocaleDisplayNamesImpl_fr();
  }
  
  @Override
  protected LocalizedNames createLocalizedNames() {
    return new com.google.gwt.i18n.shared.cldr.LocalizedNamesImpl_fr();
  }
  
  @Override
  protected NumberConstants createNumberConstants() {
    return new com.google.gwt.i18n.shared.cldr.NumberConstantsImpl_fr();
  }
  
  @Override
  protected VariantSelector createOrdinalRule() {
    return new com.google.gwt.i18n.shared.cldr.OrdinalRuleImpl_bda8dd4b();
  }
  
  @Override
  protected VariantSelector createPluralRule() {
    return new com.google.gwt.i18n.shared.cldr.PluralRuleImpl_0d1c6a03();
  }
}
