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
 * JS implementation of CurrencyList for locale "nb".
 */
public class CurrencyListImpl_nb extends CurrencyListImpl {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "NOK", "kr", 2, "NOkr", "kr"];
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
      "AOR": [ "AOR", "AOR", 130, "AOR", "AOR"],
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
      "COU": [ "COU", "COU", 130, "COU", "COU"],
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
      "ILR": [ "ILR", "ILR", 130, "ILR", "ILR"],
      "ILS": [ "ILS", "₪", 2, "IL₪", "₪"],
      "INR": [ "INR", "Rs.", 2, "Rs", "₹"],
      "IQD": [ "IQD", "IQD", 0, "IQD", "din"],
      "IRR": [ "IRR", "IRR", 0, "IRR", "Rial"],
      "ISJ": [ "ISJ", "ISJ", 130, "ISJ", "ISJ"],
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
      "NOK": [ "NOK", "kr", 2, "NOkr", "kr"],
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
      "ZWL": [ "ZWL", "ZWL", 130, "ZWL", "ZWL"],
    };
  }-*/;
  
  private native JavaScriptObject loadCurrencyNamesOverride() /*-{
    return {
      "ADP": "andorranske pesetas",
      "AED": "UAE dirham",
      "AFA": "afgansk afghani (1927-2002)",
      "AFN": "afgansk afgani",
      "ALL": "albanske lek",
      "AMD": "armenske dram",
      "ANG": "nederlandske antillegylden",
      "AOA": "angolanske kwanza",
      "AOK": "angolanske kwanza (1977-1990)",
      "AON": "angolanske nye kwanza (1990-2000)",
      "AOR": "angolanske omjusterte kwanza (1995-1999)",
      "ARA": "argentinske australer",
      "ARP": "argentinske pesos (1983-1985)",
      "ARS": "argentinske pesos",
      "ATS": "østerrikske shilling",
      "AUD": "australske dollar",
      "AWG": "arubiske gylden",
      "AZM": "aserbajdsjanske manat (1993-2006)",
      "AZN": "aserbajdsjanske manat",
      "BAD": "bosnisk-hercegovinske dinarer",
      "BAM": "bosnisk-hercegovinske mark (konvertible)",
      "BBD": "barbadiske dollar",
      "BDT": "bangladeshiske taka",
      "BEC": "belgiske franc (konvertible)",
      "BEF": "belgiske franc",
      "BEL": "belgiske franc (finansielle)",
      "BGL": "bulgarske lev (hard)",
      "BGN": "bulgarske lev",
      "BHD": "bahrainske dinarer",
      "BIF": "burundiske franc",
      "BMD": "bermudiske dollar",
      "BND": "bruneiske dollar",
      "BOB": "bolivianske boliviano",
      "BOP": "bolivianske pesos",
      "BOV": "bolivianske mvdol",
      "BRB": "brasilianske cruzeiro novo (1967-1986)",
      "BRC": "brasilianske cruzado",
      "BRE": "brasilianske cruzeiro (1990-1993)",
      "BRL": "brasilianske realer",
      "BRN": "brasilianske cruzado novo",
      "BRR": "brasilianske cruzeiro",
      "BSD": "bahamske dollar",
      "BTN": "bhutanske ngultrum",
      "BUK": "burmesiske kyat",
      "BWP": "botswanske pula",
      "BYB": "hviterussiske nye rubler (1994-1999)",
      "BYR": "hviterussiske rubler",
      "BZD": "beliziske dollar",
      "CAD": "kanadiske dollar",
      "CDF": "kongolesiske franc (congolais)",
      "CHE": "WIR euro",
      "CHF": "sveitsiske franc",
      "CHW": "WIR franc",
      "CLF": "chilenske unidades de fomento",
      "CLP": "chilenske pesos",
      "CNY": "kinesiske yuan renminbi",
      "COP": "colombianske pesos",
      "COU": "unidad de valor real",
      "CRC": "costaricanske colon",
      "CSD": "gamle serbiske dinarer",
      "CSK": "tsjekkoslovakiske koruna (hard)",
      "CUC": "kubansk konvertibel peso",
      "CUP": "kubanske pesos",
      "CVE": "kappverdiske escudo",
      "CYP": "kypriotiske pund",
      "CZK": "tsjekkiske koruna",
      "DDM": "østtyske ostmark",
      "DEM": "tyske mark",
      "DJF": "djiboutiske franc",
      "DKK": "danske kroner",
      "DOP": "dominikanske pesos",
      "DZD": "algeriske dinarer",
      "ECS": "ecuadorianske sucre",
      "ECV": "ecuadorianske unidad de valor constante (UVC)",
      "EEK": "estiske kroon",
      "EGP": "egyptiske pund",
      "ERN": "eritreiske nakfa",
      "ESA": "spanske peseta (A-konto)",
      "ESB": "spanske peseta (konvertibel konto)",
      "ESP": "spanske peseta",
      "ETB": "etiopiske birr",
      "EUR": "euro",
      "FIM": "finske mark",
      "FJD": "fijianske dollar",
      "FKP": "Falkland-pund",
      "FRF": "franske franc",
      "GBP": "britiske pund sterling",
      "GEK": "georgiske kupon larit",
      "GEL": "georgiske lari",
      "GHC": "ghanesisk cedi (1979-2007)",
      "GHS": "ghanesisk cedi",
      "GIP": "gibraltarske pund",
      "GMD": "gambiske dalasi",
      "GNF": "guineanske franc",
      "GNS": "guineanske syli",
      "GQE": "ekvatorialguineanske ekwele guineana",
      "GRD": "greske drakmer",
      "GTQ": "guatemalanske quetzal",
      "GWE": "portugisiske guinea escudo",
      "GWP": "Guinea-Bissau-pesos",
      "GYD": "guyanske dollar",
      "HKD": "Hongkong-dollar",
      "HNL": "Hoduras Lempira",
      "HRD": "kroatiske dinarer",
      "HRK": "kroatiske kuna",
      "HTG": "haitiske gourde",
      "HUF": "ungarske forinter",
      "IDR": "indonesiske rupier",
      "IEP": "irske pund",
      "ILP": "israelske pund",
      "ILR": "israelsk gammel shekel",
      "ILS": "israelske nye shekler",
      "INR": "indiske rupier",
      "IQD": "irakske dinarer",
      "IRR": "iranske rialer",
      "ISJ": "gammel islandsk krone",
      "ISK": "islandske kroner",
      "ITL": "italienske lire",
      "JMD": "jamaikanske dollar",
      "JOD": "jordanske dinarer",
      "JPY": "japanske yen",
      "KES": "kenyanske shilling",
      "KGS": "kirgisiske som",
      "KHR": "kambodsjanske riel",
      "KMF": "komoriske franc",
      "KPW": "nordkoreanske won",
      "KRW": "sørkoreanske won",
      "KWD": "kuwaitiske dinarer",
      "KYD": "caymanske dollar",
      "KZT": "kasakhstanske tenge",
      "LAK": "laotiske kip",
      "LBP": "libanesiske pund",
      "LKR": "srilankiske rupier",
      "LRD": "liberiske dollar",
      "LSL": "lesothiske loti",
      "LTL": "litauiske lita",
      "LTT": "litauiske talonas",
      "LUC": "luxemburgske konvertible franc",
      "LUF": "luxemburgske franc",
      "LUL": "luxemburgske finansielle franc",
      "LVL": "latviske lats",
      "LVR": "latviske rubler",
      "LYD": "libyske dinarer",
      "MAD": "marokkanske dirham",
      "MAF": "marokkanske franc",
      "MDL": "moldovske leu",
      "MGA": "madagassiske ariary",
      "MGF": "madagassiske franc",
      "MKD": "makedonske denarer",
      "MLF": "maliske franc",
      "MMK": "myanmarske kyat",
      "MNT": "mongolske tugrik",
      "MOP": "makaoske pataca",
      "MRO": "mauritanske ouguiya",
      "MTL": "maltesiske lira",
      "MTP": "maltesiske pund",
      "MUR": "mauritiske rupier",
      "MVR": "maldiviske rufiyaa",
      "MWK": "malawiske kwacha",
      "MXN": "meksikanske pesos",
      "MXP": "meksikanske sølvpesos (1861-1992)",
      "MXV": "meksikanske unidad de inversion (UDI)",
      "MYR": "malaysiske ringgit",
      "MZE": "mosambikiske escudo",
      "MZM": "gamle mosambikiske metical",
      "MZN": "mosambikiske metical",
      "NAD": "namibiske dollar",
      "NGN": "nigerianske naira",
      "NIC": "nicaraguanske cordoba (1988–1991)",
      "NIO": "nicaraguanske cordoba oro",
      "NLG": "nederlandske gylden",
      "NOK": "norske kroner",
      "NPR": "nepalske rupier",
      "NZD": "new zealandske dollar",
      "OMR": "omanske rialer",
      "PAB": "panamanske balboa",
      "PEI": "peruvianske inti",
      "PEN": "peruvianske nye sol",
      "PES": "peruvianske sol",
      "PGK": "papuanske kina",
      "PHP": "filippinske pesos",
      "PKR": "pakistanske rupier",
      "PLN": "polske zloty",
      "PLZ": "polske zloty (1950-1995)",
      "PTE": "portugisiske escudo",
      "PYG": "paraguayanske guarani",
      "QAR": "qatarske rialer",
      "RHD": "rhodesiske dollar",
      "ROL": "gamle rumenske leu",
      "RON": "rumenske leu",
      "RSD": "serbiske dinarer",
      "RUB": "russiske rubler",
      "RUR": "russiske rubler (1991-1998)",
      "RWF": "rwandiske franc",
      "SAR": "saudiarabiske riyaler",
      "SBD": "salomonske dollar",
      "SCR": "seychelliske rupier",
      "SDD": "sudanesiske dinarer",
      "SDG": "sudanske pund",
      "SDP": "sudanesiske pund",
      "SEK": "svenske kroner",
      "SGD": "singaporske dollar",
      "SHP": "sankthelenske pund",
      "SIT": "slovenske tolar",
      "SKK": "slovakiske koruna",
      "SLL": "sierraleonske leone",
      "SOS": "somaliske shilling",
      "SRD": "surinamske dollar",
      "SRG": "surinamske gylden",
      "STD": "Sao Tome og Principe-dobra",
      "SUR": "sovjetiske rubler",
      "SVC": "salvadoranske colon",
      "SYP": "syriske pund",
      "SZL": "swazilandske lilangeni",
      "THB": "thailandske baht",
      "TJR": "tadsjikiske rubler",
      "TJS": "tadsjikiske somoni",
      "TMM": "turkmenske manat",
      "TMT": "turkmenistansk ny manat",
      "TND": "tunisiske dinarer",
      "TOP": "tonganske paʻanga",
      "TPE": "timoresiske escudo",
      "TRL": "tyrkiske lire",
      "TRY": "ny tyrkisk lire",
      "TTD": "trinidadiske dollar",
      "TWD": "taiwanske nye dollar",
      "TZS": "tanzanianske shilling",
      "UAH": "ukrainske hryvnia",
      "UAK": "ukrainske karbovanetz",
      "UGS": "ugandiske shilling (1966-1987)",
      "UGX": "ugandiske shilling",
      "USD": "amerikanske dollar",
      "USN": "amerikanske dollar (neste dag)",
      "USS": "amerikanske dollar (samme dag)",
      "UYP": "uruguayanske pesos (1975-1993)",
      "UYU": "uruguayanske peso uruguayo",
      "UZS": "usbekiske sum",
      "VEB": "venezuelanske bolivar",
      "VEF": "venezuelanske bolivar fuerte",
      "VND": "vietnamesiske dong",
      "VUV": "vanuatiske vatu",
      "WST": "vestsamoiske tala",
      "XAF": "CFA franc BEAC",
      "XAG": "sølv",
      "XAU": "gull",
      "XBA": "europeisk sammensatt enhet",
      "XBB": "europeisk monetær enhet",
      "XBC": "europeisk kontoenhet (XBC)",
      "XBD": "europeisk kontoenhet (XBD)",
      "XCD": "østkaribiske dollar",
      "XDR": "spesielle trekkrettigheter",
      "XEU": "europeisk valutaenhet",
      "XFO": "franske gullfranc",
      "XFU": "franske UIC-franc",
      "XOF": "CFA franc BCEAO",
      "XPD": "palladium",
      "XPF": "CFP franc",
      "XPT": "platina",
      "XRE": "RINET-fond",
      "XTS": "testvalutakode",
      "XXX": "ukjent eller ugyldig valuta",
      "YDD": "jemenittiske dinarer",
      "YER": "jemenittiske rialer",
      "YUD": "jugoslaviske dinarer (hard)",
      "YUM": "jugoslaviske noviy-dinarer",
      "YUN": "jugoslaviske konvertible dinarer",
      "ZAL": "sørafrikanske rand (finansielle)",
      "ZAR": "sørafrikanske rand",
      "ZMK": "zambiske kwacha",
      "ZRN": "zairiske nye zaire",
      "ZRZ": "zairiske zaire",
      "ZWD": "zimbabwiske dollar",
      "ZWL": "zimbabwisk dollar (2009)",
    };
  }-*/;
}
