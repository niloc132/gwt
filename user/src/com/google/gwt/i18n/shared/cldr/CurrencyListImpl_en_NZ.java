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

import com.google.gwt.i18n.shared.CurrencyData;
import com.google.gwt.i18n.shared.impl.CurrencyDataImpl;

import java.util.Map;;

// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA:
//  cldrVersion=21.0
//  date=$Date: 2012-01-27 12:47:35 -0500 (Fri, 27 Jan 2012) $
//  number=$Revision: 6465 $
//  type=GB

/**
 *  * Pure Java implementation of CurrencyList for locale "en_NZ".
 */
public class CurrencyListImpl_en_NZ extends CurrencyListImpl_en {
  
  @Override
  public CurrencyData getDefault() {
    return new CurrencyDataImpl("NZD", "$", 2, "$", "$");
  }
  
  @Override
  protected Map<String, CurrencyData> loadCurrencies() {
    Map<String, CurrencyData> result = super.loadCurrencies();
    result.put("GBP", new CurrencyDataImpl("GBP", "£", 2, "GB£", "£"));
    result.put("NZD", new CurrencyDataImpl("NZD", "$", 2, "$", "$"));
    result.put("USD", new CurrencyDataImpl("USD", "US$", 2, "US$", "$"));
    return result;
  }
  
  @Override
  protected Map<String, String> loadCurrencyNames() {
    Map<String, String> result = super.loadCurrencyNames();
    result.put("GBP", "British Pound Sterling");
    result.put("NZD", "New Zealand Dollar");
    result.put("USD", "US Dollar");
    return result;
  }
}
