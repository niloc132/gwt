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
 * JS implementation of CurrencyList for locale "af".
 */
public class CurrencyListImpl_af extends CurrencyListImpl {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "ZAR", "R", 2, "ZAR", "R"];
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
      "GHC": [ "GHC", "GHC", 130, "GHC", "GHC"],
      "GHS": [ "GHS", "GHS", 2, "GHS", "GHS"],
      "GIP": [ "GIP", "GIP", 2, "GIP", "£"],
      "GMD": [ "GMD", "GMD", 2, "GMD", "GMD"],
      "GNF": [ "GNF", "GNF", 0, "GNF", "FG"],
      "GNS": [ "GNS", "GNS", 130, "GNS", "GNS"],
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
      "ITL": [ "ITL", "ITL", 128, "ITL", "ITL"],
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
      "MZM": [ "MZM", "MZM", 130, "MZM", "MZM"],
      "MZN": [ "MZN", "MZN", 2, "MZN", "MTn"],
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
      "SDP": [ "SDP", "SDP", 130, "SDP", "SDP"],
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
      "TRL": [ "TRL", "TRL", 128, "TRL", "TRL"],
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
      "ZAR": [ "ZAR", "R", 2, "ZAR", "R"],
      "ZMK": [ "ZMK", "ZMK", 0, "ZMK", "ZWK"],
      "ZWD": [ "ZWD", "ZWD", 128, "ZWD", "ZWD"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "AED": "Verenigde Arabiese Emirate dirham",
      "AFN": "Afgaanse afgani",
      "ALL": "Albanese lek",
      "AMD": "Armeense dram",
      "ANG": "Nederlands-Antilliaanse gulde",
      "AOA": "Angolese kwanza",
      "ARS": "Argentynse peso",
      "AUD": "Australiese dollar",
      "AWG": "Arubaanse floryn",
      "AZN": "Azerbeidjaanse manat",
      "BAM": "Bosnië en Herzegowina omskakelbare marka",
      "BBD": "Barbados-dollar",
      "BDT": "Bangladesjiese taka",
      "BGN": "Bulgaarse lev",
      "BHD": "Bahrainse dinar",
      "BIF": "Burundiese frank",
      "BMD": "Bermuda-dollar",
      "BND": "Broeneise dollar",
      "BOB": "Boliviaanse boliviano",
      "BRL": "Brasiliaanse real",
      "BSD": "Bahamiaanse dollar",
      "BTN": "Bhoetanese ngoeltroem",
      "BWP": "Botswana pula",
      "BYR": "Belo-Russiese roebel",
      "BZD": "Beliziese dollar",
      "CAD": "Kanadese dollar",
      "CDF": "Kongolese frank",
      "CHF": "Switserse frank",
      "CLP": "Chileense peso",
      "CNY": "Sjinese joean renminbi",
      "COP": "Colombiaanse peso",
      "CRC": "Costa Ricaanse colón",
      "CUC": "Kubaanse omskakelbare peso",
      "CUP": "Kubaanse peso",
      "CVE": "Kaap Verdiese escudo",
      "CZK": "Tsjeggiese kroon",
      "DJF": "Djiboeti frank",
      "DKK": "Deense kroon",
      "DOP": "Dominikaanse peso",
      "DZD": "Algeriese dinar",
      "EGP": "Egiptiese pond",
      "ERN": "Eritrese nakfa",
      "ETB": "Etiopiese birr",
      "EUR": "Euro",
      "FJD": "Fidjiaanse dollar",
      "FKP": "Falkland-eilande pond",
      "GBP": "Britse pond",
      "GEL": "Georgiese lari",
      "GHC": "Ghanese cedi (1979-2007)",
      "GHS": "Ghanese cedi",
      "GIP": "Gibraltarese pond",
      "GMD": "Gambiese dalasi",
      "GNF": "Guinese frank",
      "GNS": "Guinese syli",
      "GTQ": "Guatemalaanse quetzal",
      "GYD": "Guyanese dollar",
      "HKD": "Hong Kong dollar",
      "HNL": "Hondurese lempira",
      "HRK": "Kroatiese kuna",
      "HTG": "Haïtiaanse gourde",
      "HUF": "Hongaarse forint",
      "IDR": "Indonesiese roepia",
      "ILS": "Israeliese nuwe sikkel",
      "INR": "Indiese rupee",
      "IQD": "Irakse dinar",
      "IRR": "Iranse rial",
      "ISK": "Yslandse kroon",
      "ITL": "Italiaanse lier",
      "JMD": "Jamaikaanse dollar",
      "JOD": "Jordaniese dinar",
      "JPY": "Japannese jen",
      "KES": "Keniaanse sjieling",
      "KGS": "Kirgisiese som",
      "KHR": "Kambodjaanse riel",
      "KMF": "Comoriese frank",
      "KPW": "Noord-Koreaanse won",
      "KRW": "Suid-Koreaanse won",
      "KWD": "Koeweitse dinar",
      "KYD": "Cayman-eilande dollar",
      "KZT": "Kazakse tenge",
      "LAK": "Laosiaanse kip",
      "LBP": "Lebanese pond",
      "LKR": "Sri Lankaanse roepee",
      "LRD": "Liberiese dollar",
      "LSL": "Lesotho loti",
      "LTL": "Litause litas",
      "LVL": "Lettiese lats",
      "LYD": "Libiese dinar",
      "MAD": "Marokkaanse dirham",
      "MDL": "Moldowiese leu",
      "MGA": "Malgassiese ariary",
      "MKD": "Macedoniese denar",
      "MMK": "Myanma Kyat",
      "MNT": "Mongoolse toegrik",
      "MOP": "Macaose pataca",
      "MRO": "Mauritaniese ouguiya",
      "MUR": "Mauritiaanse rupee",
      "MVR": "Malediviese rufia",
      "MWK": "Malawiese kwacha",
      "MXN": "Meksikaanse peso",
      "MYR": "Maleisiese ringgit",
      "MZM": "Mosambiekse metical (1980-2006)",
      "MZN": "Mosambiekse metical",
      "NAD": "Namibiese dollar",
      "NGN": "Nigeriese naira",
      "NIO": "Nicaraguaanse córdoba",
      "NOK": "Noorse kroon",
      "NPR": "Nepalese roepee",
      "NZD": "Nieu-Seeland dollar",
      "OMR": "Omaanse rial",
      "PAB": "Panamese balboa",
      "PEN": "Peruaanse nuwe sol",
      "PGK": "Papoease kina",
      "PHP": "Filippynse peso",
      "PKR": "Pakistanse roepee",
      "PLN": "Poolse zloty",
      "PYG": "Paraguaanse guarani",
      "QAR": "Katarese rial",
      "RSD": "Serbiese dinar",
      "RUB": "Russiese roebel",
      "RWF": "Rwandiese frank",
      "SAR": "Saoedi-Arabiese riyal",
      "SBD": "Salomons-eilande dollar",
      "SCR": "Seychellese rupee",
      "SDG": "Soedannese pond",
      "SDP": "Soedannese pond (1957-1998)",
      "SEK": "Sweedse kroon",
      "SGD": "Singapoer-dollar",
      "SHP": "Sint Helena pond",
      "SLL": "Sierra Leonese leone",
      "SOS": "Somaliese sjieling",
      "SRD": "Surinaamse dollar",
      "STD": "São Tomé en Príncipe dobra",
      "SYP": "Siriese pond",
      "SZL": "Swazilandse lilangeni",
      "THB": "Thaise baht",
      "TJS": "Tadjikse roebel",
      "TMT": "Toerkmeense manat",
      "TND": "Tunisiese dinar",
      "TOP": "Tongaanse pa'anga",
      "TRL": "Turkse lier (1922-2005)",
      "TRY": "Turkse lier",
      "TTD": "Trinidad en Tobago dollar",
      "TWD": "Nuwe Taiwanese dollar",
      "TZS": "Tanzaniese sjieling",
      "UAH": "Oekraïnse hriwna",
      "UGX": "Ugandese sjieling",
      "USD": "Amerikaanse dollar",
      "UYU": "Uruguaanse peso",
      "UZS": "Oezbekiese som",
      "VEF": "Venezolaanse bolivar",
      "VND": "Viëtnamese dong",
      "VUV": "Vanuatu vatu",
      "WST": "Samoaanse tala",
      "XAF": "CFA frank BEAC",
      "XCD": "Oos-Karibbiese dollar",
      "XOF": "CFA frank BCEAO",
      "XPF": "CFP-frank",
      "XXX": "Onbekende geldeenheid",
      "YER": "Jemenitiese rial",
      "ZAR": "Suid-Afrikaanse rand",
      "ZMK": "Zambiese kwacha",
      "ZWD": "Zimbabwiese dollar",
    };
  }-*/;
}
