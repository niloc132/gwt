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
//  number=$Revision: 6546 Google $
//  type=root

/**
 * JS implementation of CurrencyList for locale "ms".
 */
public class CurrencyListImpl_ms extends CurrencyListImpl {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "MYR", "RM", 2, "RM", "RM"];
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
      "AED": [ "AED", "DH", 2, "DH", "dh"],
      "AFN": [ "AFN", "AFN", 0, "AFN", "Af."],
      "ALL": [ "ALL", "ALL", 0, "ALL", "Lek"],
      "AMD": [ "AMD", "AMD", 0, "AMD", "Dram"],
      "ANG": [ "ANG", "ANG", 2, "ANG", "ANG"],
      "AOA": [ "AOA", "AOA", 2, "AOA", "Kz"],
      "ARS": [ "ARS", "AR$", 2, "AR$", "$"],
      "AUD": [ "AUD", "AU$", 2, "AU$", "$"],
      "AWG": [ "AWG", "AWG", 2, "AWG", "Afl."],
      "AZN": [ "AZN", "AZN", 2, "AZN", "man."],
      "BAM": [ "BAM", "BAM", 2, "BAM", "KM"],
      "BBD": [ "BBD", "BBD", 2, "BBD", "$"],
      "BDT": [ "BDT", "Tk", 2, "Tk", "৳"],
      "BGN": [ "BGN", "BGN", 2, "BGN", "lev"],
      "BHD": [ "BHD", "BHD", 3, "BHD", "din"],
      "BIF": [ "BIF", "BIF", 0, "BIF", "FBu"],
      "BMD": [ "BMD", "BMD", 2, "BMD", "$"],
      "BND": [ "BND", "BND", 2, "BND", "$"],
      "BOB": [ "BOB", "BOB", 2, "BOB", "Bs"],
      "BRL": [ "BRL", "R$", 2, "R$", "R$"],
      "BSD": [ "BSD", "BSD", 2, "BSD", "$"],
      "BTN": [ "BTN", "BTN", 2, "BTN", "Nu."],
      "BWP": [ "BWP", "BWP", 2, "BWP", "P"],
      "BYR": [ "BYR", "BYR", 0, "BYR", "BYR"],
      "BZD": [ "BZD", "BZD", 2, "BZD", "$"],
      "CAD": [ "CAD", "CA$", 2, "C$", "$"],
      "CDF": [ "CDF", "CDF", 2, "CDF", "FrCD"],
      "CHF": [ "CHF", "CHF", 2, "CHF", "CHF"],
      "CLP": [ "CLP", "CL$", 0, "CL$", "$"],
      "CNY": [ "CNY", "CN¥", 2, "RMB¥", "¥"],
      "COP": [ "COP", "COL$", 0, "COL$", "$"],
      "CRC": [ "CRC", "CR₡", 0, "CR₡", "₡"],
      "CUC": [ "CUC", "CUC", 2, "CUC", "$"],
      "CUP": [ "CUP", "$MN", 2, "$MN", "$"],
      "CVE": [ "CVE", "CVE", 2, "CVE", "CVE"],
      "CZK": [ "CZK", "Kč", 2, "Kč", "Kč"],
      "DJF": [ "DJF", "Fdj", 0, "Fdj", "Fdj"],
      "DKK": [ "DKK", "kr", 2, "kr", "kr"],
      "DOP": [ "DOP", "RD$", 2, "RD$", "$"],
      "DZD": [ "DZD", "DZD", 2, "DZD", "din"],
      "EGP": [ "EGP", "LE", 2, "LE", "E£"],
      "ERN": [ "ERN", "ERN", 2, "ERN", "Nfk"],
      "ETB": [ "ETB", "ETB", 2, "ETB", "Birr"],
      "EUR": [ "EUR", "€", 2, "€", "€"],
      "FJD": [ "FJD", "FJD", 2, "FJD", "$"],
      "FKP": [ "FKP", "FKP", 2, "FKP", "£"],
      "GBP": [ "GBP", "UK£", 2, "GB£", "£"],
      "GEL": [ "GEL", "GEL", 2, "GEL", "GEL"],
      "GHS": [ "GHS", "GHS", 2, "GHS", "GHS"],
      "GIP": [ "GIP", "GIP", 2, "GIP", "£"],
      "GMD": [ "GMD", "GMD", 2, "GMD", "GMD"],
      "GNF": [ "GNF", "GNF", 0, "GNF", "FG"],
      "GTQ": [ "GTQ", "GTQ", 2, "GTQ", "Q"],
      "GYD": [ "GYD", "GYD", 0, "GYD", "$"],
      "HKD": [ "HKD", "HK$", 2, "HK$", "$"],
      "HNL": [ "HNL", "L", 2, "L", "L"],
      "HRK": [ "HRK", "HRK", 2, "HRK", "kn"],
      "HTG": [ "HTG", "HTG", 2, "HTG", "HTG"],
      "HUF": [ "HUF", "HUF", 0, "HUF", "Ft"],
      "IDR": [ "IDR", "IDR", 0, "IDR", "Rp"],
      "ILS": [ "ILS", "₪", 2, "IL₪", "₪"],
      "INR": [ "INR", "Rs.", 2, "Rs", "₹"],
      "IQD": [ "IQD", "IQD", 0, "IQD", "din"],
      "IRR": [ "IRR", "IRR", 0, "IRR", "Rial"],
      "ISK": [ "ISK", "kr", 0, "kr", "kr"],
      "JMD": [ "JMD", "JA$", 2, "JA$", "$"],
      "JOD": [ "JOD", "JOD", 3, "JOD", "din"],
      "JPY": [ "JPY", "JP¥", 0, "JP¥", "¥"],
      "KES": [ "KES", "Ksh", 2, "Ksh", "Ksh"],
      "KGS": [ "KGS", "KGS", 2, "KGS", "KGS"],
      "KHR": [ "KHR", "KHR", 2, "KHR", "Riel"],
      "KMF": [ "KMF", "KMF", 0, "KMF", "CF"],
      "KPW": [ "KPW", "KPW", 0, "KPW", "₩"],
      "KRW": [ "KRW", "₩", 0, "KR₩", "₩"],
      "KWD": [ "KWD", "KWD", 3, "KWD", "din"],
      "KYD": [ "KYD", "KYD", 2, "KYD", "$"],
      "KZT": [ "KZT", "KZT", 2, "KZT", "₸"],
      "LAK": [ "LAK", "LAK", 0, "LAK", "₭"],
      "LBP": [ "LBP", "LBP", 0, "LBP", "L£"],
      "LKR": [ "LKR", "SLRs", 2, "SLRs", "Rs"],
      "LRD": [ "LRD", "LRD", 2, "LRD", "$"],
      "LSL": [ "LSL", "LSL", 2, "LSL", "LSL"],
      "LTL": [ "LTL", "LTL", 2, "LTL", "Lt"],
      "LVL": [ "LVL", "LVL", 2, "LVL", "Ls"],
      "LYD": [ "LYD", "LYD", 3, "LYD", "din"],
      "MAD": [ "MAD", "MAD", 2, "MAD", "MAD"],
      "MDL": [ "MDL", "MDL", 2, "MDL", "MDL"],
      "MGA": [ "MGA", "MGA", 0, "MGA", "Ar"],
      "MKD": [ "MKD", "MKD", 2, "MKD", "din"],
      "MMK": [ "MMK", "MMK", 0, "MMK", "K"],
      "MNT": [ "MNT", "MN₮", 0, "MN₮", "₮"],
      "MOP": [ "MOP", "MOP", 2, "MOP", "MOP"],
      "MRO": [ "MRO", "MRO", 0, "MRO", "MRO"],
      "MUR": [ "MUR", "MUR", 0, "MUR", "Rs"],
      "MVR": [ "MVR", "MVR", 2, "MVR", "MVR"],
      "MWK": [ "MWK", "MWK", 2, "MWK", "MWK"],
      "MXN": [ "MXN", "MX$", 2, "Mex$", "$"],
      "MYR": [ "MYR", "RM", 2, "RM", "RM"],
      "NAD": [ "NAD", "NAD", 2, "NAD", "$"],
      "NGN": [ "NGN", "NGN", 2, "NGN", "₦"],
      "NIO": [ "NIO", "NIO", 2, "NIO", "C$"],
      "NOK": [ "NOK", "NOkr", 2, "NOkr", "kr"],
      "NPR": [ "NPR", "NPR", 2, "NPR", "Rs"],
      "NZD": [ "NZD", "NZ$", 2, "NZ$", "$"],
      "OMR": [ "OMR", "OMR", 3, "OMR", "Rial"],
      "PAB": [ "PAB", "B/.", 2, "B/.", "B/."],
      "PEN": [ "PEN", "S/.", 2, "S/.", "S/."],
      "PGK": [ "PGK", "PGK", 2, "PGK", "PGK"],
      "PHP": [ "PHP", "PHP", 2, "PHP", "₱"],
      "PKR": [ "PKR", "PKRs.", 0, "PKRs.", "Rs"],
      "PLN": [ "PLN", "PLN", 2, "PLN", "zł"],
      "PYG": [ "PYG", "PYG", 0, "PYG", "Gs"],
      "QAR": [ "QAR", "QAR", 2, "QAR", "Rial"],
      "RSD": [ "RSD", "RSD", 0, "RSD", "din"],
      "RUB": [ "RUB", "руб.", 2, "руб.", "руб."],
      "RWF": [ "RWF", "RWF", 0, "RWF", "RF"],
      "SAR": [ "SAR", "SR", 2, "SR", "Rial"],
      "SBD": [ "SBD", "SBD", 2, "SBD", "$"],
      "SCR": [ "SCR", "SCR", 2, "SCR", "SCR"],
      "SDG": [ "SDG", "SDG", 2, "SDG", "SDG"],
      "SEK": [ "SEK", "kr", 2, "kr", "kr"],
      "SGD": [ "SGD", "S$", 2, "S$", "$"],
      "SHP": [ "SHP", "SHP", 2, "SHP", "£"],
      "SLL": [ "SLL", "SLL", 0, "SLL", "SLL"],
      "SOS": [ "SOS", "SOS", 0, "SOS", "SOS"],
      "SRD": [ "SRD", "SRD", 2, "SRD", "$"],
      "STD": [ "STD", "STD", 0, "STD", "Db"],
      "SYP": [ "SYP", "SYP", 0, "SYP", "£"],
      "SZL": [ "SZL", "SZL", 2, "SZL", "SZL"],
      "THB": [ "THB", "฿", 2, "THB", "฿"],
      "TJS": [ "TJS", "TJS", 2, "TJS", "Som"],
      "TMT": [ "TMT", "TMT", 2, "TMT", "TMT"],
      "TND": [ "TND", "TND", 3, "TND", "din"],
      "TOP": [ "TOP", "TOP", 2, "TOP", "T$"],
      "TRY": [ "TRY", "YTL", 2, "YTL", "YTL"],
      "TTD": [ "TTD", "TTD", 2, "TTD", "$"],
      "TWD": [ "TWD", "NT$", 2, "NT$", "NT$"],
      "TZS": [ "TZS", "TZS", 0, "TZS", "TSh"],
      "UAH": [ "UAH", "UAH", 2, "UAH", "₴"],
      "UGX": [ "UGX", "UGX", 0, "UGX", "UGX"],
      "USD": [ "USD", "US$", 2, "US$", "$"],
      "UYU": [ "UYU", "UY$", 2, "UY$", "$"],
      "UZS": [ "UZS", "UZS", 0, "UZS", "soʼm"],
      "VEF": [ "VEF", "VEF", 2, "VEF", "Bs"],
      "VND": [ "VND", "₫", 24, "₫", "₫"],
      "VUV": [ "VUV", "VUV", 0, "VUV", "VUV"],
      "WST": [ "WST", "WST", 2, "WST", "WST"],
      "XAF": [ "XAF", "FCFA", 0, "FCFA", "FCFA"],
      "XCD": [ "XCD", "EC$", 2, "EC$", "$"],
      "XOF": [ "XOF", "CFA", 0, "CFA", "CFA"],
      "XPF": [ "XPF", "CFPF", 0, "CFPF", "FCFP"],
      "XXX": [ "XXX", "XXX", 130, "XXX", "XXX"],
      "YER": [ "YER", "YER", 0, "YER", "Rial"],
      "ZAR": [ "ZAR", "ZAR", 2, "ZAR", "R"],
      "ZMK": [ "ZMK", "ZMK", 0, "ZMK", "ZWK"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "AED": "Dirham Emiriah Arab Bersatu",
      "AFN": "Afghani Afghanistan",
      "ALL": "Lek Albania",
      "AMD": "Dram Armenia",
      "ANG": "Guilder Antillean Netherland",
      "AOA": "Kwanza Angola",
      "ARS": "Peso Argentina",
      "AUD": "Dolar Australia",
      "AWG": "Florin Aruba",
      "AZN": "Manat Azerbaijan",
      "BAM": "Mark Boleh Tukar Bosnia-Herzegovina",
      "BBD": "Dolar Barbados",
      "BDT": "Taka Bangladesh",
      "BGN": "Lev Bulgaria",
      "BHD": "Dinar Bahrain",
      "BIF": "Franc Burundia",
      "BMD": "Dolar Bermuda",
      "BND": "Dolar Brunei",
      "BOB": "Boliviano Bolivia",
      "BRL": "Real Brazil",
      "BSD": "Dolar Bahamas",
      "BTN": "Ngultrum Bhutan",
      "BWP": "Pula Botswana",
      "BYR": "Ruble Belarus",
      "BZD": "Dolar Belize",
      "CAD": "Dolar Kanada",
      "CDF": "Franc Congo",
      "CHF": "Franc Switzerland",
      "CLP": "Peso Chile",
      "CNY": "Yuan Cina",
      "COP": "Peso Colombia",
      "CRC": "Colón Costa Rica",
      "CUC": "Peso Boleh Tukar Cuba",
      "CUP": "Peso Cuba",
      "CVE": "Escudo Tanjung Verde",
      "CZK": "Koruna Republik Czech",
      "DJF": "Franc Djibouti",
      "DKK": "Krone Denmark",
      "DOP": "Peso Dominican",
      "DZD": "Dinar Algeria",
      "EGP": "Paun Mesir",
      "ERN": "Nakfa Eritrea",
      "ETB": "Birr Ethiopia",
      "EUR": "Euro",
      "FJD": "Dolar Fiji",
      "FKP": "Paun Kepulauan Falkland",
      "GBP": "Paun Sterling British",
      "GEL": "Lari Georgia",
      "GHS": "Cedi Ghana",
      "GIP": "Paun Gibraltar",
      "GMD": "Dalasi Gambia",
      "GNF": "Franc Guinea",
      "GTQ": "Quetzal Guatemala",
      "GYD": "Dolar Guyana",
      "HKD": "Dolar Hong Kong",
      "HNL": "Lempira Honduras",
      "HRK": "Kuna Croatia",
      "HTG": "Gourde Haiti",
      "HUF": "Forint Hungary",
      "IDR": "Rupiah Indonesia",
      "ILS": "Sheqel Baru Israel",
      "INR": "Rupee India",
      "IQD": "Dinar Iraq",
      "IRR": "Rial Iran",
      "ISK": "Króna Iceland",
      "JMD": "Dolar Jamaica",
      "JOD": "Dinar Jordan",
      "JPY": "Yen Jepun",
      "KES": "Syiling Kenya",
      "KGS": "Som Kyrgystani",
      "KHR": "Riel Kemboja",
      "KMF": "Franc Comoria",
      "KPW": "Won Korea Utara",
      "KRW": "Won Korea Selatan",
      "KWD": "Dinar Kuwait",
      "KYD": "Dolar Kepulauan Cayman",
      "KZT": "Tenge Kazakhstan",
      "LAK": "Kip Laos",
      "LBP": "Paun Lubnan",
      "LKR": "Rupee Sri Lanka",
      "LRD": "Dolar Liberia",
      "LSL": "Loti Lesotho",
      "LTL": "Litas Lithuania",
      "LVL": "Lats Latvia",
      "LYD": "Dinar Libya",
      "MAD": "Dirham Maghribi",
      "MDL": "Leu Moldova",
      "MGA": "Ariary Malagasy",
      "MKD": "Denar Macedonia",
      "MMK": "Kyat Myanma",
      "MNT": "Tugrik Mongolia",
      "MOP": "Pataca Macau",
      "MRO": "Ouguiya Mauritania",
      "MUR": "Rupee Mauritia",
      "MVR": "Rufiyaa Maldives",
      "MWK": "Kwacha Malawi",
      "MXN": "Peso Mexico",
      "MYR": "Ringgit Malaysia",
      "NAD": "Dolar Namibia",
      "NGN": "Naira Nigeria",
      "NIO": "Córdoba Nicaragua",
      "NOK": "Krone Norway",
      "NPR": "Rupee Nepal",
      "NZD": "Dolar New Zealand",
      "OMR": "Rial Oman",
      "PAB": "Balboa Panama",
      "PEN": "Nuevo Sol Peru",
      "PGK": "Kina Papua New Guinea",
      "PHP": "Peso Filipina",
      "PKR": "Rupee Pakistan",
      "PLN": "Zloty Poland",
      "PYG": "Guarani Paraguay",
      "QAR": "Rial Qatar",
      "RSD": "Dinar Serbia",
      "RUB": "Ruble Rusia",
      "RWF": "Franc Rwanda",
      "SAR": "Riyal Saudi",
      "SBD": "Dolar Kepulauan Solomon",
      "SCR": "Rupee Seychelles",
      "SDG": "Paun Sudan",
      "SEK": "Krona Sweden",
      "SGD": "Dolar Singapura",
      "SHP": "Paun Saint Helena",
      "SLL": "Leone Sierra Leone",
      "SOS": "Syiling Somali",
      "SRD": "Dolar Surinam",
      "STD": "São Tomé dan Príncipe Dobra",
      "SYP": "Paun Syria",
      "SZL": "Lilangeni Swazi",
      "THB": "Baht Thai",
      "TJS": "Somoni Tajikistan",
      "TMT": "Manat Turkmenistan",
      "TND": "Dinar Tunisia",
      "TOP": "Tongan Paʻanga",
      "TRY": "Lira Turki",
      "TTD": "Dolar Trinidad dan Tobago",
      "TWD": "Dolar Taiwan Baru",
      "TZS": "Syiling Tanzania",
      "UAH": "Hryvnia Ukraine",
      "UGX": "Syiling Uganda",
      "USD": "Dolar AS",
      "UYU": "Peso Uruguay",
      "UZS": "Som Uzbekistan",
      "VEF": "Bolívar Venezuela",
      "VND": "Dong Vietnam",
      "VUV": "Vatu Vanuatu",
      "WST": "Tala Samoa",
      "XAF": "Franc CFA BEAC",
      "XCD": "Dolar Caribbean Timur",
      "XOF": "Franc CFA BCEAO",
      "XPF": "Franc CFP",
      "XXX": "Mata Wang Tidak Diketahui",
      "YER": "Rial Yaman",
      "ZAR": "Rand Afrika Selatan",
      "ZMK": "Kwacha Zambia",
    };
  }-*/;
}
