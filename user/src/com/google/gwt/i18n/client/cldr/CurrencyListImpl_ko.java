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
//  type=ko

/**
 * JS implementation of CurrencyList for locale "ko".
 */
public class CurrencyListImpl_ko extends CurrencyListImpl {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "KRW", "₩", 0, "KR₩", "₩"];
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
      "ADP": [ "ADP", "ADP", 128, "ADP", "ADP"],
      "AED": [ "AED", "DH", 2, "DH", "dh"],
      "AFA": [ "AFA", "AFA", 130, "AFA", "AFA"],
      "AFN": [ "AFN", "AFN", 0, "AFN", "Af."],
      "ALL": [ "ALL", "ALL", 0, "ALL", "Lek"],
      "AMD": [ "AMD", "AMD", 0, "AMD", "Dram"],
      "ANG": [ "ANG", "ANG", 2, "ANG", "ANG"],
      "AOA": [ "AOA", "AOA", 2, "AOA", "Kz"],
      "AOK": [ "AOK", "AOK", 130, "AOK", "AOK"],
      "AON": [ "AON", "AON", 130, "AON", "AON"],
      "ARA": [ "ARA", "ARA", 130, "ARA", "ARA"],
      "ARP": [ "ARP", "ARP", 130, "ARP", "ARP"],
      "ARS": [ "ARS", "AR$", 2, "AR$", "$"],
      "ATS": [ "ATS", "ATS", 130, "ATS", "ATS"],
      "AUD": [ "AUD", "AU$", 2, "AU$", "$"],
      "AWG": [ "AWG", "AWG", 2, "AWG", "Afl."],
      "AZM": [ "AZM", "AZM", 130, "AZM", "AZM"],
      "AZN": [ "AZN", "AZN", 2, "AZN", "man."],
      "BAD": [ "BAD", "BAD", 130, "BAD", "BAD"],
      "BAM": [ "BAM", "BAM", 2, "BAM", "KM"],
      "BBD": [ "BBD", "BBD", 2, "BBD", "$"],
      "BDT": [ "BDT", "Tk", 2, "Tk", "৳"],
      "BEC": [ "BEC", "BEC", 130, "BEC", "BEC"],
      "BEF": [ "BEF", "BEF", 130, "BEF", "BEF"],
      "BEL": [ "BEL", "BEL", 130, "BEL", "BEL"],
      "BGL": [ "BGL", "BGL", 130, "BGL", "BGL"],
      "BGN": [ "BGN", "BGN", 2, "BGN", "lev"],
      "BHD": [ "BHD", "BHD", 3, "BHD", "din"],
      "BIF": [ "BIF", "BIF", 0, "BIF", "FBu"],
      "BMD": [ "BMD", "BMD", 2, "BMD", "$"],
      "BND": [ "BND", "BND", 2, "BND", "$"],
      "BOB": [ "BOB", "BOB", 2, "BOB", "Bs"],
      "BOP": [ "BOP", "BOP", 130, "BOP", "BOP"],
      "BOV": [ "BOV", "BOV", 130, "BOV", "BOV"],
      "BRB": [ "BRB", "BRB", 130, "BRB", "BRB"],
      "BRC": [ "BRC", "BRC", 130, "BRC", "BRC"],
      "BRE": [ "BRE", "BRE", 130, "BRE", "BRE"],
      "BRL": [ "BRL", "R$", 2, "R$", "R$"],
      "BRN": [ "BRN", "BRN", 130, "BRN", "BRN"],
      "BRR": [ "BRR", "BRR", 130, "BRR", "BRR"],
      "BSD": [ "BSD", "BSD", 2, "BSD", "$"],
      "BTN": [ "BTN", "BTN", 2, "BTN", "Nu."],
      "BUK": [ "BUK", "BUK", 130, "BUK", "BUK"],
      "BWP": [ "BWP", "BWP", 2, "BWP", "P"],
      "BYB": [ "BYB", "BYB", 130, "BYB", "BYB"],
      "BYR": [ "BYR", "BYR", 0, "BYR", "BYR"],
      "BZD": [ "BZD", "BZD", 2, "BZD", "$"],
      "CAD": [ "CAD", "CA$", 2, "C$", "$"],
      "CDF": [ "CDF", "CDF", 2, "CDF", "FrCD"],
      "CHE": [ "CHE", "CHE", 130, "CHE", "CHE"],
      "CHF": [ "CHF", "CHF", 2, "CHF", "CHF"],
      "CHW": [ "CHW", "CHW", 130, "CHW", "CHW"],
      "CLF": [ "CLF", "CLF", 128, "CLF", "CLF"],
      "CLP": [ "CLP", "CL$", 0, "CL$", "$"],
      "CNY": [ "CNY", "CN¥", 2, "RMB¥", "¥"],
      "COP": [ "COP", "COL$", 0, "COL$", "$"],
      "CRC": [ "CRC", "CR₡", 0, "CR₡", "₡"],
      "CSD": [ "CSD", "CSD", 130, "CSD", "CSD"],
      "CSK": [ "CSK", "CSK", 130, "CSK", "CSK"],
      "CUC": [ "CUC", "CUC", 2, "CUC", "$"],
      "CUP": [ "CUP", "$MN", 2, "$MN", "$"],
      "CVE": [ "CVE", "CVE", 2, "CVE", "CVE"],
      "CYP": [ "CYP", "CYP", 130, "CYP", "CYP"],
      "CZK": [ "CZK", "Kč", 2, "Kč", "Kč"],
      "DDM": [ "DDM", "DDM", 130, "DDM", "DDM"],
      "DEM": [ "DEM", "DEM", 130, "DEM", "DEM"],
      "DJF": [ "DJF", "Fdj", 0, "Fdj", "Fdj"],
      "DKK": [ "DKK", "kr", 2, "kr", "kr"],
      "DOP": [ "DOP", "RD$", 2, "RD$", "$"],
      "DZD": [ "DZD", "DZD", 2, "DZD", "din"],
      "ECS": [ "ECS", "ECS", 130, "ECS", "ECS"],
      "ECV": [ "ECV", "ECV", 130, "ECV", "ECV"],
      "EEK": [ "EEK", "EEK", 130, "EEK", "EEK"],
      "EGP": [ "EGP", "LE", 2, "LE", "E£"],
      "ERN": [ "ERN", "ERN", 2, "ERN", "Nfk"],
      "ESA": [ "ESA", "ESA", 130, "ESA", "ESA"],
      "ESB": [ "ESB", "ESB", 130, "ESB", "ESB"],
      "ESP": [ "ESP", "ESP", 128, "ESP", "ESP"],
      "ETB": [ "ETB", "ETB", 2, "ETB", "Birr"],
      "EUR": [ "EUR", "€", 2, "€", "€"],
      "FIM": [ "FIM", "FIM", 130, "FIM", "FIM"],
      "FJD": [ "FJD", "FJD", 2, "FJD", "$"],
      "FKP": [ "FKP", "FKP", 2, "FKP", "£"],
      "FRF": [ "FRF", "FRF", 130, "FRF", "FRF"],
      "GBP": [ "GBP", "UK£", 2, "GB£", "£"],
      "GEK": [ "GEK", "GEK", 130, "GEK", "GEK"],
      "GEL": [ "GEL", "GEL", 2, "GEL", "GEL"],
      "GHC": [ "GHC", "GHC", 130, "GHC", "GHC"],
      "GHS": [ "GHS", "GHS", 2, "GHS", "GHS"],
      "GIP": [ "GIP", "GIP", 2, "GIP", "£"],
      "GMD": [ "GMD", "GMD", 2, "GMD", "GMD"],
      "GNF": [ "GNF", "GNF", 0, "GNF", "FG"],
      "GNS": [ "GNS", "GNS", 130, "GNS", "GNS"],
      "GQE": [ "GQE", "GQE", 130, "GQE", "GQE"],
      "GRD": [ "GRD", "GRD", 130, "GRD", "GRD"],
      "GTQ": [ "GTQ", "GTQ", 2, "GTQ", "Q"],
      "GWE": [ "GWE", "GWE", 130, "GWE", "GWE"],
      "GWP": [ "GWP", "GWP", 130, "GWP", "GWP"],
      "GYD": [ "GYD", "GYD", 0, "GYD", "$"],
      "HKD": [ "HKD", "HK$", 2, "HK$", "$"],
      "HNL": [ "HNL", "L", 2, "L", "L"],
      "HRD": [ "HRD", "HRD", 130, "HRD", "HRD"],
      "HRK": [ "HRK", "HRK", 2, "HRK", "kn"],
      "HTG": [ "HTG", "HTG", 2, "HTG", "HTG"],
      "HUF": [ "HUF", "HUF", 0, "HUF", "Ft"],
      "IDR": [ "IDR", "IDR", 0, "IDR", "Rp"],
      "IEP": [ "IEP", "IEP", 130, "IEP", "IEP"],
      "ILP": [ "ILP", "ILP", 130, "ILP", "ILP"],
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
      "LTT": [ "LTT", "LTT", 130, "LTT", "LTT"],
      "LUC": [ "LUC", "LUC", 130, "LUC", "LUC"],
      "LUF": [ "LUF", "LUF", 128, "LUF", "LUF"],
      "LUL": [ "LUL", "LUL", 130, "LUL", "LUL"],
      "LVL": [ "LVL", "LVL", 2, "LVL", "Ls"],
      "LVR": [ "LVR", "LVR", 130, "LVR", "LVR"],
      "LYD": [ "LYD", "LYD", 3, "LYD", "din"],
      "MAD": [ "MAD", "MAD", 2, "MAD", "MAD"],
      "MAF": [ "MAF", "MAF", 130, "MAF", "MAF"],
      "MDL": [ "MDL", "MDL", 2, "MDL", "MDL"],
      "MGA": [ "MGA", "MGA", 0, "MGA", "Ar"],
      "MGF": [ "MGF", "MGF", 128, "MGF", "MGF"],
      "MKD": [ "MKD", "MKD", 2, "MKD", "din"],
      "MLF": [ "MLF", "MLF", 130, "MLF", "MLF"],
      "MMK": [ "MMK", "MMK", 0, "MMK", "K"],
      "MNT": [ "MNT", "MN₮", 0, "MN₮", "₮"],
      "MOP": [ "MOP", "MOP", 2, "MOP", "MOP"],
      "MRO": [ "MRO", "MRO", 0, "MRO", "MRO"],
      "MTL": [ "MTL", "MTL", 130, "MTL", "MTL"],
      "MTP": [ "MTP", "MTP", 130, "MTP", "MTP"],
      "MUR": [ "MUR", "MUR", 0, "MUR", "Rs"],
      "MVR": [ "MVR", "MVR", 2, "MVR", "MVR"],
      "MWK": [ "MWK", "MWK", 2, "MWK", "MWK"],
      "MXN": [ "MXN", "MX$", 2, "Mex$", "$"],
      "MXP": [ "MXP", "MXP", 130, "MXP", "MXP"],
      "MXV": [ "MXV", "MXV", 130, "MXV", "MXV"],
      "MYR": [ "MYR", "RM", 2, "RM", "RM"],
      "MZE": [ "MZE", "MZE", 130, "MZE", "MZE"],
      "MZM": [ "MZM", "MZM", 130, "MZM", "MZM"],
      "MZN": [ "MZN", "MZN", 2, "MZN", "MTn"],
      "NAD": [ "NAD", "NAD", 2, "NAD", "$"],
      "NGN": [ "NGN", "NGN", 2, "NGN", "₦"],
      "NIC": [ "NIC", "NIC", 130, "NIC", "NIC"],
      "NIO": [ "NIO", "NIO", 2, "NIO", "C$"],
      "NLG": [ "NLG", "NLG", 130, "NLG", "NLG"],
      "NOK": [ "NOK", "NOkr", 2, "NOkr", "kr"],
      "NPR": [ "NPR", "NPR", 2, "NPR", "Rs"],
      "NZD": [ "NZD", "NZ$", 2, "NZ$", "$"],
      "OMR": [ "OMR", "OMR", 3, "OMR", "Rial"],
      "PAB": [ "PAB", "B/.", 2, "B/.", "B/."],
      "PEI": [ "PEI", "PEI", 130, "PEI", "PEI"],
      "PEN": [ "PEN", "S/.", 2, "S/.", "S/."],
      "PES": [ "PES", "PES", 130, "PES", "PES"],
      "PGK": [ "PGK", "PGK", 2, "PGK", "PGK"],
      "PHP": [ "PHP", "PHP", 2, "PHP", "₱"],
      "PKR": [ "PKR", "PKRs.", 0, "PKRs.", "Rs"],
      "PLN": [ "PLN", "PLN", 2, "PLN", "zł"],
      "PLZ": [ "PLZ", "PLZ", 130, "PLZ", "PLZ"],
      "PTE": [ "PTE", "PTE", 130, "PTE", "PTE"],
      "PYG": [ "PYG", "PYG", 0, "PYG", "Gs"],
      "QAR": [ "QAR", "QAR", 2, "QAR", "Rial"],
      "RHD": [ "RHD", "RHD", 130, "RHD", "RHD"],
      "ROL": [ "ROL", "ROL", 130, "ROL", "ROL"],
      "RON": [ "RON", "RON", 2, "RON", "RON"],
      "RSD": [ "RSD", "RSD", 0, "RSD", "din"],
      "RUB": [ "RUB", "руб.", 2, "руб.", "руб."],
      "RUR": [ "RUR", "RUR", 130, "RUR", "RUR"],
      "RWF": [ "RWF", "RWF", 0, "RWF", "RF"],
      "SAR": [ "SAR", "SR", 2, "SR", "Rial"],
      "SBD": [ "SBD", "SBD", 2, "SBD", "$"],
      "SCR": [ "SCR", "SCR", 2, "SCR", "SCR"],
      "SDD": [ "SDD", "SDD", 130, "SDD", "SDD"],
      "SDG": [ "SDG", "SDG", 2, "SDG", "SDG"],
      "SDP": [ "SDP", "SDP", 130, "SDP", "SDP"],
      "SEK": [ "SEK", "kr", 2, "kr", "kr"],
      "SGD": [ "SGD", "S$", 2, "S$", "$"],
      "SHP": [ "SHP", "SHP", 2, "SHP", "£"],
      "SIT": [ "SIT", "SIT", 130, "SIT", "SIT"],
      "SKK": [ "SKK", "SKK", 130, "SKK", "SKK"],
      "SLL": [ "SLL", "SLL", 0, "SLL", "SLL"],
      "SOS": [ "SOS", "SOS", 0, "SOS", "SOS"],
      "SRD": [ "SRD", "SRD", 2, "SRD", "$"],
      "SRG": [ "SRG", "SRG", 130, "SRG", "SRG"],
      "STD": [ "STD", "STD", 0, "STD", "Db"],
      "SUR": [ "SUR", "SUR", 130, "SUR", "SUR"],
      "SVC": [ "SVC", "SVC", 130, "SVC", "SVC"],
      "SYP": [ "SYP", "SYP", 0, "SYP", "£"],
      "SZL": [ "SZL", "SZL", 2, "SZL", "SZL"],
      "THB": [ "THB", "฿", 2, "THB", "฿"],
      "TJR": [ "TJR", "TJR", 130, "TJR", "TJR"],
      "TJS": [ "TJS", "TJS", 2, "TJS", "Som"],
      "TMM": [ "TMM", "TMM", 128, "TMM", "TMM"],
      "TMT": [ "TMT", "TMT", 2, "TMT", "TMT"],
      "TND": [ "TND", "TND", 3, "TND", "din"],
      "TOP": [ "TOP", "TOP", 2, "TOP", "T$"],
      "TPE": [ "TPE", "TPE", 130, "TPE", "TPE"],
      "TRL": [ "TRL", "TRL", 128, "TRL", "TRL"],
      "TRY": [ "TRY", "YTL", 2, "YTL", "YTL"],
      "TTD": [ "TTD", "TTD", 2, "TTD", "$"],
      "TWD": [ "TWD", "NT$", 2, "NT$", "NT$"],
      "TZS": [ "TZS", "TZS", 0, "TZS", "TSh"],
      "UAH": [ "UAH", "UAH", 2, "UAH", "₴"],
      "UAK": [ "UAK", "UAK", 130, "UAK", "UAK"],
      "UGS": [ "UGS", "UGS", 130, "UGS", "UGS"],
      "UGX": [ "UGX", "UGX", 0, "UGX", "UGX"],
      "USD": [ "USD", "US$", 2, "US$", "$"],
      "USN": [ "USN", "USN", 130, "USN", "USN"],
      "USS": [ "USS", "USS", 130, "USS", "USS"],
      "UYI": [ "UYI", "UYI", 130, "UYI", "UYI"],
      "UYP": [ "UYP", "UYP", 130, "UYP", "UYP"],
      "UYU": [ "UYU", "UY$", 2, "UY$", "$"],
      "UZS": [ "UZS", "UZS", 0, "UZS", "soʼm"],
      "VEB": [ "VEB", "VEB", 130, "VEB", "VEB"],
      "VEF": [ "VEF", "VEF", 2, "VEF", "Bs"],
      "VND": [ "VND", "₫", 24, "₫", "₫"],
      "VUV": [ "VUV", "VUV", 0, "VUV", "VUV"],
      "WST": [ "WST", "WST", 2, "WST", "WST"],
      "XAF": [ "XAF", "FCFA", 0, "FCFA", "FCFA"],
      "XAG": [ "XAG", "XAG", 130, "XAG", "XAG"],
      "XAU": [ "XAU", "XAU", 130, "XAU", "XAU"],
      "XBA": [ "XBA", "XBA", 130, "XBA", "XBA"],
      "XBB": [ "XBB", "XBB", 130, "XBB", "XBB"],
      "XBC": [ "XBC", "XBC", 130, "XBC", "XBC"],
      "XBD": [ "XBD", "XBD", 130, "XBD", "XBD"],
      "XCD": [ "XCD", "EC$", 2, "EC$", "$"],
      "XDR": [ "XDR", "XDR", 130, "XDR", "XDR"],
      "XEU": [ "XEU", "XEU", 130, "XEU", "XEU"],
      "XFO": [ "XFO", "XFO", 130, "XFO", "XFO"],
      "XFU": [ "XFU", "XFU", 130, "XFU", "XFU"],
      "XOF": [ "XOF", "CFA", 0, "CFA", "CFA"],
      "XPD": [ "XPD", "XPD", 130, "XPD", "XPD"],
      "XPF": [ "XPF", "CFPF", 0, "CFPF", "FCFP"],
      "XPT": [ "XPT", "XPT", 130, "XPT", "XPT"],
      "XRE": [ "XRE", "XRE", 130, "XRE", "XRE"],
      "XTS": [ "XTS", "XTS", 130, "XTS", "XTS"],
      "XXX": [ "XXX", "XXX", 130, "XXX", "XXX"],
      "YDD": [ "YDD", "YDD", 130, "YDD", "YDD"],
      "YER": [ "YER", "YER", 0, "YER", "Rial"],
      "YUD": [ "YUD", "YUD", 130, "YUD", "YUD"],
      "YUM": [ "YUM", "YUM", 130, "YUM", "YUM"],
      "YUN": [ "YUN", "YUN", 130, "YUN", "YUN"],
      "ZAL": [ "ZAL", "ZAL", 130, "ZAL", "ZAL"],
      "ZAR": [ "ZAR", "ZAR", 2, "ZAR", "R"],
      "ZMK": [ "ZMK", "ZMK", 0, "ZMK", "ZWK"],
      "ZRN": [ "ZRN", "ZRN", 130, "ZRN", "ZRN"],
      "ZRZ": [ "ZRZ", "ZRZ", 130, "ZRZ", "ZRZ"],
      "ZWD": [ "ZWD", "ZWD", 128, "ZWD", "ZWD"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "ADP": "안도라 페세타",
      "AED": "아랍에미리트 디르함",
      "AFA": "아프가니 (1927-2002)",
      "AFN": "아프가니스탄 아프가니",
      "ALL": "알바니아 레크",
      "AMD": "아르메니아 드람",
      "ANG": "네덜란드령 안틸레스 길더",
      "AOA": "앙골라 콴자",
      "AOK": "앙골라 콴자 (1977-1990)",
      "AON": "앙골라 신콴자 (1990-2000)",
      "ARA": "아르헨티나 오스트랄",
      "ARP": "아르헨티나 페소 (1983-1985)",
      "ARS": "아르헨티나 페소",
      "ATS": "호주 실링",
      "AUD": "호주 달러",
      "AWG": "아루바 플로린",
      "AZM": "아제르바이젠 마나트(1993-2006)",
      "AZN": "아제르바이잔 마나트",
      "BAD": "보스니아-헤르체고비나 디나르",
      "BAM": "보스니아-헤르체고비나 태환 마르크",
      "BBD": "바베이도스 달러",
      "BDT": "방글라데시 타카",
      "BEC": "벨기에 프랑 (태환)",
      "BEF": "벨기에 프랑",
      "BEL": "벨기에 프랑 (금융)",
      "BGL": "불가리아 동전 렛",
      "BGN": "불가리아 신권 렛",
      "BHD": "바레인 디나르",
      "BIF": "부룬디 프랑",
      "BMD": "버뮤다 달러",
      "BND": "부루나이 달러",
      "BOB": "볼리비아노",
      "BOP": "볼리비아노 페소",
      "BOV": "볼리비아노 Mvdol(기금)",
      "BRB": "볼리비아노 크루제이루 노보 (1967-1986)",
      "BRC": "브라질 크루자두",
      "BRE": "브라질 크루제이루 (1990-1993)",
      "BRL": "브라질 레알",
      "BRN": "브라질 크루자두 노보",
      "BRR": "브라질 크루제이루",
      "BSD": "바하마 달러",
      "BTN": "부탄 눌투눔",
      "BUK": "버마 차트",
      "BWP": "보츠와나 폴라",
      "BYB": "벨라루스 신권 루블 (1994-1999)",
      "BYR": "벨라루스 루블",
      "BZD": "벨리즈 달러",
      "CAD": "캐나다 달러",
      "CDF": "콩고 프랑 콩골라스",
      "CHE": "유로 (WIR)",
      "CHF": "스위스 프랑",
      "CHW": "프랑 (WIR)",
      "CLF": "칠레 (UF)",
      "CLP": "칠레 페소",
      "CNY": "중국 위안 인민폐",
      "COP": "콜롬비아 페소",
      "CRC": "코스타리카 콜론",
      "CSD": "고 세르비아 디나르",
      "CSK": "체코슬로바키아 동전 코루나",
      "CUC": "쿠바 태환 페소",
      "CUP": "쿠바 페소",
      "CVE": "카보베르데 에스쿠도",
      "CYP": "싸이프러스 파운드",
      "CZK": "체코 공화국 코루나",
      "DDM": "동독 오스트마르크",
      "DEM": "독일 마르크",
      "DJF": "지부티 프랑",
      "DKK": "덴마크 크로네",
      "DOP": "도미니카 페소",
      "DZD": "알제리 디나르",
      "ECS": "에쿠아도르 수크레",
      "ECV": "에콰도르 (UVC)",
      "EEK": "에스토니아 크룬",
      "EGP": "이집트 파운드",
      "ERN": "에리트리아 나크파",
      "ESA": "스페인 페세타(예금)",
      "ESB": "스페인 페세타(변환 예금)",
      "ESP": "스페인 페세타",
      "ETB": "이디오피아 비르",
      "EUR": "유로화",
      "FIM": "핀란드 마르카",
      "FJD": "피지 달러",
      "FKP": "포클랜드제도 파운드",
      "FRF": "프랑스 프랑",
      "GBP": "영국령 파운드 스털링",
      "GEK": "그루지야 지폐 라리트",
      "GEL": "그루지야 라리",
      "GHC": "가나 시디 (1979-2007)",
      "GHS": "가나 시디",
      "GIP": "지브롤터 파운드",
      "GMD": "감비아 달라시",
      "GNF": "기니 프랑",
      "GNS": "기니 시리",
      "GQE": "적도 기니 에쿨 (Ekwele)",
      "GRD": "그리스 드라크마",
      "GTQ": "과테말라 케트살",
      "GWE": "포르투갈령 기니 에스쿠도",
      "GWP": "기네비쏘 페소",
      "GYD": "가이아나 달러",
      "HKD": "홍콩 달러",
      "HNL": "온두라스 렘피라",
      "HRD": "크로아티아 디나르",
      "HRK": "크로아티아 쿠나",
      "HTG": "하이티 구르드",
      "HUF": "헝가리 포린트",
      "IDR": "인도네시아 루피아",
      "IEP": "아일랜드 파운드",
      "ILP": "이스라엘 파운드",
      "ILS": "이스라엘 신권 세켈",
      "INR": "인도 루피",
      "IQD": "이라크 디나르",
      "IRR": "이란 리얄",
      "ISK": "아이슬란드 크로나",
      "ITL": "이탈리아 리라",
      "JMD": "자메이카 달러",
      "JOD": "요르단 디나르",
      "JPY": "일본 엔화",
      "KES": "케냐 실링",
      "KGS": "키르기스스탄 솜",
      "KHR": "캄보디아 리얄",
      "KMF": "코모르 프랑",
      "KPW": "조선 민주주의 인민 공화국 원",
      "KRW": "대한민국 원",
      "KWD": "쿠웨이트 디나르",
      "KYD": "케이맨 제도 달러",
      "KZT": "카자흐스탄 텐게",
      "LAK": "라오스 키프",
      "LBP": "레바논 파운드",
      "LKR": "스리랑카 루피",
      "LRD": "라이베리아 달러",
      "LSL": "레소토 로티",
      "LTL": "리투아니아 리타",
      "LTT": "룩셈부르크 타로나",
      "LUC": "룩셈부르크 변환 프랑",
      "LUF": "룩셈부르크 프랑",
      "LUL": "룩셈부르크 재정 프랑",
      "LVL": "라트비아 라트",
      "LVR": "라트비아 루블",
      "LYD": "리비아 디나르",
      "MAD": "모로코 디렘",
      "MAF": "모로코 프랑",
      "MDL": "몰도바 레이",
      "MGA": "마다가스카르 아리아리",
      "MGF": "마다가스카르 프랑",
      "MKD": "마케도니아 디나르",
      "MLF": "말리 프랑",
      "MMK": "미얀마 키얏",
      "MNT": "몽골 투그릭",
      "MOP": "마카오 파타카",
      "MRO": "모리타니 우기야",
      "MTL": "몰타 리라",
      "MTP": "몰타 파운드",
      "MUR": "모리셔스 루피",
      "MVR": "몰디브 제도 루피아",
      "MWK": "말라위 콰쳐",
      "MXN": "멕시코 페소",
      "MXP": "멕시코 실버 페소 (1861-1992)",
      "MXV": "멕시코 (UDI)",
      "MYR": "말레이시아 링깃",
      "MZE": "모잠비크 에스쿠도",
      "MZM": "고 모잠비크 메티칼",
      "MZN": "모잠비크 메티칼",
      "NAD": "나미비아 달러",
      "NGN": "니제르 나이라",
      "NIC": "니카라과 코르도바",
      "NIO": "니카라과 코르도바 오로",
      "NLG": "네델란드 길더",
      "NOK": "노르웨이 크로네",
      "NPR": "네팔 루피",
      "NZD": "뉴질랜드 달러",
      "OMR": "오만 리얄",
      "PAB": "파나마 발보아",
      "PEI": "페루 인티",
      "PEN": "페루 솔 누에보",
      "PES": "페루 솔",
      "PGK": "파푸아뉴기니 키나",
      "PHP": "필리핀 페소",
      "PKR": "파키스탄 루피",
      "PLN": "폴란드 즐로티",
      "PLZ": "폴란드 즐로티 (1950-1995)",
      "PTE": "포르투갈 에스쿠도",
      "PYG": "파라과이 과라니",
      "QAR": "카타르 리얄",
      "RHD": "로디지아 달러",
      "ROL": "루마니아 레이",
      "RON": "루마니아 레우",
      "RSD": "세르비아 디나르",
      "RUB": "러시아 루블",
      "RUR": "러시아 루블 (1991-1998)",
      "RWF": "르완다 프랑",
      "SAR": "사우디아라비아 리얄",
      "SBD": "솔로몬 제도 달러",
      "SCR": "세이쉴 루피",
      "SDD": "수단 디나르",
      "SDG": "수단 파운드",
      "SDP": "고 수단 파운드",
      "SEK": "스웨덴 크로나",
      "SGD": "싱가폴 달러",
      "SHP": "세인트헬레나 파운드",
      "SIT": "슬로베니아 톨라르",
      "SKK": "슬로바키아 코루나",
      "SLL": "시에라리온 리온",
      "SOS": "소말리아 실링",
      "SRD": "수리남 달러",
      "SRG": "수리남 길더",
      "STD": "상투메 프린시페 도브라",
      "SUR": "소련 루블",
      "SVC": "엘살바도르 콜론",
      "SYP": "시리아 파운드",
      "SZL": "스와질란드 릴랑게니",
      "THB": "태국 바트",
      "TJR": "타지키스탄 루블",
      "TJS": "타지키스탄 소모니",
      "TMM": "투르크메니스탄 마나트 (1993-2009)",
      "TMT": "투르크메니스탄 마나트",
      "TND": "튀니지 디나르",
      "TOP": "통가 파앙가",
      "TPE": "티모르 에스쿠도",
      "TRL": "터키 리라",
      "TRY": "신 터키 리라",
      "TTD": "트리니다드 토바고 달러",
      "TWD": "대만 신권 달러",
      "TZS": "탄자니아 실링",
      "UAH": "우크라이나 그리브나",
      "UAK": "우크라이나 카보바네츠",
      "UGS": "우간다 실링 (1966-1987)",
      "UGX": "우간다 실링",
      "USD": "미국 달러",
      "USN": "미국 달러(다음날)",
      "USS": "미국 달러(당일)",
      "UYI": "우루과이 페소 (UI)",
      "UYP": "우루과이 페소 (1975-1993)",
      "UYU": "우루과이 페소 우루과요",
      "UZS": "우즈베키스탄 숨",
      "VEB": "베네주엘라 볼리바르",
      "VEF": "베네주엘라 볼리바르 푸에르떼",
      "VND": "베트남 동",
      "VUV": "바누아투 바투",
      "WST": "서 사모아 탈라",
      "XAF": "프랑 (CFA-BEAC)",
      "XAG": "은화",
      "XAU": "금",
      "XBA": "유르코 (유럽 회계 단위)",
      "XBB": "유럽 통화 동맹",
      "XBC": "유럽 계산 단위 (XBC)",
      "XBD": "유럽 계산 단위 (XBD)",
      "XCD": "동카리브 달러",
      "XDR": "특별인출권",
      "XEU": "유럽 환율 단위",
      "XFO": "프랑스 프랑 (Gold)",
      "XFU": "프랑스 프랑 (UIC)",
      "XOF": "프랑 (CFA-BCEAO)",
      "XPD": "팔라듐",
      "XPF": "프랑 (CFP)",
      "XPT": "백금",
      "XRE": "RINET 기금",
      "XTS": "테스트 통화 코드",
      "XXX": "알수없거나 유효하지않은 통화단위",
      "YDD": "예멘 디나르",
      "YER": "예멘 리알",
      "YUD": "유고슬라비아 동전 디나르",
      "YUM": "유고슬라비아 노비 디나르",
      "YUN": "유고슬라비아 전환 디나르",
      "ZAL": "남아프리카 랜드 (금융)",
      "ZAR": "남아프리카 랜드",
      "ZMK": "쟘비아 콰쳐",
      "ZRN": "자이르 신권 자이르",
      "ZRZ": "자이르 자이르",
      "ZWD": "짐바브웨 달러",
    };
  }-*/;
}
