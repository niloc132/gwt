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
package com.google.gwt.i18n.client.cldr;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.shared.CurrencyData;

// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA:
//  cldrVersion=21.0
//  date=$Date: 2011-09-27 11:37:06 -0400 (Tue, 27 Sep 2011) $
//  number=$Revision: 6177 $
//  type=root

/**
 * JS implementation of CurrencyList for locale "pa_Arab".
 */
public class CurrencyListImpl_pa_Arab extends CurrencyListImpl_pa {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "PKR", "ر", 0, "PKRs.", "Rs"];
  }-*/;
  
  @Override
  protected JavaScriptObject loadCurrencies() {
    return overrideMap(super.loadCurrencies(), loadCurrenciesOverride());
  }
  
  @Override
  protected JavaScriptObject loadCurrencyNames() {
    return overrideMap(super.loadCurrencyNames(), loadCurrencyNamesOverride());
  }
  
  private native JavaScriptObject loadCurrenciesOverride() /*-{
    return {
      "AFN": [ "AFN", "AFN", 0, "AFN", "Af."],
      "EUR": [ "EUR", "€", 2, "€", "€"],
      "INR": [ "INR", "ر [INR]", 2, "Rs", "₹"],
      "PKR": [ "PKR", "ر", 0, "PKRs.", "Rs"],
      "XXX": [ "XXX", "XXX", 130, "XXX", "XXX"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "AFN": "AFN",
      "EUR": "يورو",
      "INR": "روپئیہ [INR]",
      "PKR": "روپئیہ",
      "XXX": "XXX",
    };
  }-*/;
}
