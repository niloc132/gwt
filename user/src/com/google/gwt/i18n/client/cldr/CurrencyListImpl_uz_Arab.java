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
//  date=$Date: 2012-02-07 13:32:35 -0500 (Tue, 07 Feb 2012) $
//  number=$Revision: 6546 $
//  type=root

/**
 * JS implementation of CurrencyList for locale "uz_Arab".
 */
public class CurrencyListImpl_uz_Arab extends CurrencyListImpl_uz {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "AFN", "؋", 0, "؋", "Af."];
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
      "AFN": [ "AFN", "؋", 0, "؋", "Af."],
      "BRL": [ "BRL", "R$", 2, "R$", "R$"],
      "CNY": [ "CNY", "CN¥", 2, "RMB¥", "¥"],
      "EUR": [ "EUR", "€", 2, "€", "€"],
      "GBP": [ "GBP", "UK£", 2, "GB£", "£"],
      "INR": [ "INR", "Rs.", 2, "Rs", "₹"],
      "JPY": [ "JPY", "JP¥", 0, "JP¥", "¥"],
      "RUB": [ "RUB", "руб.", 2, "руб.", "руб."],
      "USD": [ "USD", "US$", 2, "US$", "$"],
      "UZS": [ "UZS", "UZS", 0, "UZS", "soʼm"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "AFN": "افغانی",
      "BRL": "BRL",
      "CNY": "CNY",
      "EUR": "EUR",
      "GBP": "GBP",
      "INR": "INR",
      "JPY": "JPY",
      "RUB": "RUB",
      "USD": "USD",
      "UZS": "UZS",
    };
  }-*/;
}
