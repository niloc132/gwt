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
//  date=$Date: 2011-05-02 02:05:34 -0400 (Mon, 02 May 2011) $
//  number=$Revision: 5798 $
//  type=LK

/**
 *  * Pure Java implementation of CurrencyList for locale "ta_LK".
 */
public class CurrencyListImpl_ta_LK extends CurrencyListImpl_ta {
  
  @Override
  public CurrencyData getDefault() {
    return new CurrencyDataImpl("LKR", "Rs.", 2, "SLRs", "Rs");
  }
  
  @Override
  protected Map<String, CurrencyData> loadCurrencies() {
    Map<String, CurrencyData> result = super.loadCurrencies();
    result.put("LKR", new CurrencyDataImpl("LKR", "Rs.", 2, "SLRs", "Rs"));
    return result;
  }
  
  @Override
  protected Map<String, String> loadCurrencyNames() {
    Map<String, String> result = super.loadCurrencyNames();
    result.put("LKR", "இலங்கை ரூபாய்");
    return result;
  }
}
