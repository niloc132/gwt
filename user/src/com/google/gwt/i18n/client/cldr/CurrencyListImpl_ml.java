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
 * JS implementation of CurrencyList for locale "ml".
 */
public class CurrencyListImpl_ml extends CurrencyListImpl {
  
  @Override
  public native CurrencyData getDefault() /*-{
    return [ "INR", "Rs.", 2, "Rs", "₹"];
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
      "USD": [ "USD", "$", 2, "US$", "$"],
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
      "ADP": "അന്‍ഡോറന്‍ പെസെയ്റ്റ",
      "AED": "യു.എ.ഇ. ദിര്‍ഹം",
      "AFA": "അഫ്ഘാനി (1927-2002)",
      "AFN": "അഫ്ഘാനി",
      "ALL": "അല്‍ബേനിയന്‍ ലെക്",
      "AMD": "അര്‍മേനിയന്‍ ഡ്രാം",
      "ANG": "നെതര്‍ലന്‍ഡ്സ് ആന്‍റിലന്‍ ഗില്‍ഡര്‍",
      "AOA": "അംഗോളന്‍ ‍ക്വാന്‍സ",
      "AOK": "അംഗോളന്‍ ‍ക്വാന്‍സ (1977-1990)",
      "AON": "അംഗോളന്‍ ‍ന്യൂ ക്വാന്‍സ (1990-2000)",
      "AOR": "അംഗോളന്‍ ‍ക്വാന്‍സ റിയാജസ്റ്റാഡോ (1995-1999)",
      "ARA": "അര്‍ജന്‍റീന്‍ ഓസ്ട്രല്‍",
      "ARP": "അര്‍ജന്‍റീന്‍ പെയ്സോ (1983-1985)",
      "ARS": "അര്‍ജന്‍റീന്‍ പെയ്സോ",
      "ATS": "ഓസ്ട്രേലിയന്‍ ഷില്ലിംഗ്",
      "AUD": "ആസ്ട്രേലിയന്‍ ഡോളര്‍",
      "AWG": "അറൂബന്‍ ഗില്‍ഡര്‍",
      "AZM": "അസര്‍ബയ്ജാനിയന്‍ മനത് (1993-2006)",
      "AZN": "അസര്‍ബയ്ജാനിയന്‍ മനത്",
      "BAD": "ബോസ്നിയ-ഹെര്‍സഗോവിന ദിനാര്‍",
      "BAM": "ബോസ്നിയ-ഹെര്‍സഗോവിന കണ്‍വേര്‍ട്ടിബിള്‍ മാര്‍ക്ക്",
      "BBD": "ബാര്‍ബഡോസ് ഡോളര്‍",
      "BDT": "ബംഗ്ലാദേശി ടാക്ക",
      "BEC": "ബെല്‍ജിയന്‍ ഫ്രാങ്ക് (കൈമാറ്റം ചെയ്യാവുന്നത്)",
      "BEF": "ബെല്‍ജിയന്‍ ഫ്രാങ്ക്",
      "BEL": "ബല്‍ജിയന്‍ ഫ്രാങ്ക്",
      "BGL": "ബള്‍ഗേറിയന്‍ ഹാര്‍ഡ് ലെവ്",
      "BGN": "ബള്‍ഗേറിയന്‍ ന്യൂലവ്",
      "BHD": "ബഹറിന്‍ ദിനാര്‍",
      "BIF": "ബുറുണ്ടി ഫ്രാങ്ക്",
      "BMD": "ബെര്‍മുഡന്‍ ഡോളര്‍",
      "BND": "ബ്രൂണെ ഡോളര്‍",
      "BOB": "ബൊളീവിയാനോ",
      "BOP": "ബൊളീവിയന്‍ പെയ്സോ",
      "BOV": "ബൊളീവിയന്‍ എംവിഡോള്‍",
      "BRB": "ബ്രസീലിയന്‍ ക്രുസെയ്റോ നോവോ (1967-1986)",
      "BRC": "ബ്രസീലിയന്‍ ക്രുസാഡോ",
      "BRE": "ബ്രസീലിയന്‍ ക്രുസെയ്റോ (1990-1993)",
      "BRL": "ബ്രസീലിയന്‍ റിയാല്‍",
      "BRN": "ബ്രസീലിയന്‍ ക്രുസാഡോ നോവോ",
      "BRR": "ബ്രസീലിയന്‍ ക്രുസെയ്റോ",
      "BSD": "ബഹാമിയന്‍ ഡോളര്‍",
      "BTN": "ഭൂട്ടാന്‍ എന്‍ഗള്‍ട്രം",
      "BUK": "ബര്‍മീസ് ചാറ്റ്",
      "BWP": "ബോട്സ്വാനന്‍ പ്യൂല",
      "BYB": "ബെലാറഷ്യന്‍ ന്യൂ റൂബിള്‍ (1994-1999)",
      "BYR": "ബെലാറഷ്യന്‍ റൂബിള്‍",
      "BZD": "ബെലീസ് ഡോളര്‍",
      "CAD": "കനേഡിയന്‍ ഡോളര്‍",
      "CDF": "കോങ്കളീസ് ഫ്രാങ്ക് കോങ്കൊളൈസ്",
      "CHE": "WIR യൂറോ",
      "CHF": "സ്വിസ് ഫ്രാങ്ക്",
      "CHW": "WIR ഫ്രാങ്ക്",
      "CLF": "ചിലിയന്‍ യൂണിഡാഡ്സ് ഡി ഫോമെന്‍റോ",
      "CLP": "ചിലിയന്‍ പെസോ",
      "CNY": "ചൈനീസ് യുവാന്‍",
      "COP": "കൊളംബിയന്‍ പെസോ",
      "COU": "യൂണിഡാഡ് ഡി വാലര്‍ റിയല്‍",
      "CRC": "കോസ്റ്റാ റിക്കന്‍ കോളന്‍",
      "CSD": "പ്രാചീന സെര്‍ബിയന്‍ ദിനാര്‍",
      "CSK": "ചെക്കോസ്ലൊവാക്ക് ഹാര്‍ഡ് കൊരൂന",
      "CUC": "ക്യൂബന്‍ പരിവര്‍ത്തിത പെയ്‍സോ",
      "CUP": "ക്യൂബന്‍ പെസോ",
      "CVE": "കെയ്പ് വെര്‍ഡെ എസ്ക്യുഡോ",
      "CYP": "സൈപ്രസ് പൌണ്ട്",
      "CZK": "ചെക്ക് റിപ്പബ്ലിക് കൊരൂന",
      "DDM": "കിഴക്കന്‍ ജര്‍മന്‍ ഓസ്റ്റ്മാര്‍ക്ക്",
      "DEM": "ജര്‍മന്‍ മാര്‍ക്ക്",
      "DJF": "ജീബോട്ടി ഫ്രാങ്ക്",
      "DKK": "ഡാനിഷ് ക്രോണെ",
      "DOP": "ഡൊമിനിക്കന്‍ പെയ്സോ",
      "DZD": "അള്‍ജീരിയന്‍ ദിനാര്‍",
      "ECS": "ഇക്വഡോര്‍ സൂക്രേ",
      "ECV": "ഇക്വഡോര്‍ യൂണിഡാഡ് വാലര്‍ കോണ്‍സ്റ്റന്‍റെ (UVC)",
      "EEK": "എസ്റ്റൌനിയന്‍ ക്രൂണ്‍",
      "EGP": "ഈജിപ്ഷ്യന്‍ പൌണ്ട്",
      "ERN": "എറിത്രിയന്‍ നക്ഫ",
      "ESA": "സ്പാനിഷ് പസെയ്റ്റ (A അക്കൌണ്ട്)",
      "ESB": "സ്പാനിഷ് പസെയ്റ്റ (കൈമാറ്റം ചെയ്യാവുന്ന അക്കൌണ്ട്)",
      "ESP": "സ്പാനിഷ് പസെയ്റ്റ",
      "ETB": "എത്യോപ്പിയന്‍ ബിര്‍",
      "EUR": "യൂറോ",
      "FIM": "ഫിന്നിഷ് മാര്‍ക്ക",
      "FJD": "ഫിജി ഡോളര്‍",
      "FKP": "ഫോക്‌ലാന്‍ഡ് ദ്വീപുകളുടെ പൌണ്ട്",
      "FRF": "ഫ്രാങ്ക്",
      "GBP": "ബ്രിട്ടീഷ് പൌണ്ട് സ്റ്റെര്‍ലിംങ്",
      "GEK": "ജോര്‍‍ജ്ജിയന്‍ ക്യൂപോണ്‍ ലാരിറ്റ്",
      "GEL": "ജോര്‍‍ജ്ജിയന്‍ ലാരി",
      "GHC": "ഘാന കെഡി (1979-2007)",
      "GHS": "ഘാന കെഡി",
      "GIP": "ഗിബ്രാല്‍ട്ടര്‍ പൌണ്ട്",
      "GMD": "ഗാന്പിയ ദലാസി",
      "GNF": "ഗിനിയ ഫ്രാങ്ക്",
      "GNS": "ഗിനിയ സൈലി",
      "GQE": "ഇക്വിറ്റോറിയല്‍ ഗിനിയ എക്വീലെ ഗിനിയാന",
      "GRD": "ഗ്രീക്ക് ഡ്രാക്ക്മ",
      "GTQ": "ഗ്വാട്ടിമാല ക്വെറ്റ്സല്‍",
      "GWE": "പോര്‍ച്ചുഗീസ് ഗിനി എസ്ക്യൂഡോ",
      "GWP": "ഗിനിയ-ബിസാവു പെയ്സോ",
      "GYD": "ഗയാന ഡോളര്‍",
      "HKD": "ഹോങ് കോങ് ഡോളര്‍",
      "HNL": "ഹോന്‍ഡ്യുറാസ് ലെംപീര",
      "HRD": "ക്രൊയേഷ്യന്‍ ദിനാര്‍",
      "HRK": "ക്രൊയേഷ്യന്‍ ക്യൂന",
      "HTG": "ഹെയ്ഷ്യന്‍ ഗൂര്‍ഡ്",
      "HUF": "ഹംഗേറിയന്‍ ഫോറിന്‍റ്",
      "IDR": "ഇന്തോനേഷ്യന്‍ രൂപ",
      "IEP": "ഐറിഷ് പൌണ്ട്",
      "ILP": "ഇസ്രയേലി പൌണ്ട്",
      "ILS": "ഇസ്രായേലി ഷക്കേല്‍",
      "INR": "ഇന്ത്യന്‍ രൂപ",
      "IQD": "ഇറാക്കി ദിനാര്‍",
      "IRR": "ഇറാനിയന്‍ റിയാല്‍",
      "ISK": "ഐസ്‌ലാന്‍ഡിക് ക്രോണ",
      "ITL": "ഇറ്റാലിയന്‍ ലിറ",
      "JMD": "ജമൈക്കന്‍ ഡോളര്‍",
      "JOD": "ജോര്‍ദ്ദാന്‍ ദിനാര്‍",
      "JPY": "ജപ്പാനീസ് യെന്‍",
      "KES": "കെനിയന്‍ ഷില്ലിംഗ്",
      "KGS": "കിര്‍ഗിസ്ഥാന്‍ സോം",
      "KHR": "കംബോഡിയന്‍ റീല്‍",
      "KMF": "കൊമോറോ ഫ്രാങ്ക്",
      "KPW": "നോര്‍ത്ത് കൊറിയന്‍ വോണ്‍",
      "KRW": "ദക്ഷിണ കൊറിയന്‍ വോണ്‍",
      "KWD": "കുവൈറ്റി ദിനാര്‍",
      "KYD": "കെയ്മന്‍ദ്വീപുകളുടെ ഡോളര്‍‌",
      "KZT": "കസാഖ്സ്ഥാന്‍ റ്റെംഗെ",
      "LAK": "ലാവോഷിയന്‍ കിപ്",
      "LBP": "ലെബനീസ് പൌണ്ട്",
      "LKR": "ശ്രീലങ്കന്‍ രൂപ",
      "LRD": "ലൈബീരിയന്‍ ഡോളര്‍",
      "LSL": "ലെസോതോ ലോത്തി",
      "LTL": "ലിത്വാനിയന്‍ ലിത",
      "LTT": "ലിത്വാനിയന്‍ തലോനാസ്",
      "LUC": "ലക്സംബര്‍ഗ് കണ്‍വേര്‍ട്ടിബിള്‍ ഫ്രാങ്ക്",
      "LUF": "ലക്സംബര്‍ഗ് ഫ്രാങ്ക്",
      "LUL": "ലക്സംബര്‍ഗ് ഫിനാന്‍ഷ്യല്‍ ഫ്രാങ്ക്",
      "LVL": "ലാറ്റ്വിയന്‍ ലാറ്റ്സ്",
      "LVR": "ലാറ്റ്വിയന്‍ റൂബിള്‍",
      "LYD": "ലിബിയന്‍ ദിനാര്‍",
      "MAD": "മൊറോക്കന്‍ ദിര്‍ഹം",
      "MAF": "മൊറോക്കന്‍ ഫ്രാങ്ക്",
      "MDL": "മൊല്‍ഡോവന്‍ ലിയൂ",
      "MGA": "മഡഗാസ്കര്‍ ഏരിയറി",
      "MGF": "മഡഗാസ്കര്‍ ഫ്രാങ്ക്",
      "MKD": "മാസിഡോണിയന്‍ ദിനാര്‍",
      "MLF": "മാലി ഫ്രാങ്ക്",
      "MMK": "മ്യാന്‍മാര്‍ ചാറ്റ്",
      "MNT": "മംഗോളിയന്‍ തുഗ്രിക്",
      "MOP": "മകൌ പതാക്ക",
      "MRO": "മൌറിറ്റേനിയ ഔഗിയ",
      "MTL": "മല്‍ത്തീസ് ലിറ",
      "MTP": "മല്‍ത്തീസ് പൌണ്ട്",
      "MUR": "മൌറീഷ്യസ് രൂപ",
      "MVR": "മാലദ്വീപ് രൂപ",
      "MWK": "മലാവി ക്വാച",
      "MXN": "മെക്സിക്കന്‍ പെസോ",
      "MXP": "മെക്സിക്കന്‍ സില്‍വര്‍ പെയ്സോ (1861-1992)",
      "MXV": "മെക്സിക്കന്‍ യൂണിഡാഡ് ഡി ഇന്‍വെര്‍ഷന്‍ (UDI)",
      "MYR": "മലേഷ്യന്‍ റിംഗിറ്റ്",
      "MZE": "മൊസാന്പിക്ക് എസ്ക്യുഡോ",
      "MZM": "ഓള്‍ഡ് മൊസാന്പിക്ക് മെറ്റിക്കല്‍",
      "MZN": "മൊസാന്പിക്ക് മെറ്റിക്കല്‍",
      "NAD": "നമീബിയന്‍ ഡോളര്‍",
      "NGN": "നൈജീരിയന്‍ നൈറ",
      "NIC": "നികരാഗ്വന്‍ കൊര്‍ഡോബ",
      "NIO": "നികരാഗ്വന്‍ കൊര്‍ഡോബ ഒരോ",
      "NLG": "നെതര്‍ലന്‍ഡ്സ് ഗില്‍ഡര്‍",
      "NOK": "നോര്‍വീജിയന്‍ ക്രോണെ",
      "NPR": "നേപ്പാളി രൂപ",
      "NZD": "ന്യൂസിലാന്‍ഡ് ഡോളര്‍",
      "OMR": "ഒമാന്‍ റിയാല്‍",
      "PAB": "പനാമെയ്നിയന്‍ ബാല്‍ബോവ",
      "PEI": "പെറൂവിയന്‍ ഇന്‍റി",
      "PEN": "പെറൂവിയന്‍ സോള്‍ ന്യൂവോ",
      "PES": "പെറൂവിയന്‍ സോള്‍",
      "PGK": "പാപുവ ന്യൂ ഗിനി കിന",
      "PHP": "ഫിലിപ്പൈന്‍ പെയ്സോ",
      "PKR": "പാക്കിസ്ഥാനി രൂപ",
      "PLN": "പോളിഷ് സ്ലോട്ടി",
      "PLZ": "പോളിഷ് സ്ലോട്ടി (1950-1995)",
      "PTE": "പോര്‍ച്ചുഗീസ് എസ്ക്യുഡോ",
      "PYG": "പരാഗ്വേ ഗ്വരനീ",
      "QAR": "ഖത്തര്‍ റിയാല്‍",
      "RHD": "റൊഡേഷ്യന്‍ ഡോളര്‍",
      "ROL": "പ്രാചീന റൊമേനിയന്‍ ലിയു",
      "RON": "റൊമേനിയന്‍ ലിയു",
      "RSD": "സെര്‍ബിയന്‍ ദിനാര്‍",
      "RUB": "റഷ്യന്‍ റൂബിള്‍",
      "RUR": "റഷ്യന്‍ റൂബിള്‍ (1991-1998)",
      "RWF": "റുവാണ്ടന്‍ ഫ്രാങ്ക്",
      "SAR": "സൌദി റിയാല്‍",
      "SBD": "സോളമന്‍ ദ്വീപുകളുടെ ഡോളര്‍",
      "SCR": "സെയ്ഷെല്‍സ് രൂപ",
      "SDD": "പ്രാചീന സുഡാനീസ് ദിനാര്‍",
      "SDG": "സുഡാനീസ് പൌണ്ട്",
      "SDP": "പ്രാചീന സുഡാനീസ് പൌണ്ട്",
      "SEK": "സ്വീഡിഷ് ക്രോണ",
      "SGD": "സിംഗപ്പൂര്‍ ഡോളര്‍",
      "SHP": "സെയ്ന്‍റ് ഹെലെന പൌണ്ട്",
      "SIT": "സ്ലൊവേനിയ റ്റോളര്‍",
      "SKK": "സ്ലോവാക് കൊരൂന",
      "SLL": "സിയറാ ലിയോണ്‍ ലിയോണ്‍",
      "SOS": "സൊമാലി ഷില്ലിംഗ്",
      "SRD": "സൂരിനാം ഡോളര്‍",
      "SRG": "സൂരിനാം ഗില്‍ഡര്‍",
      "STD": "സാവോ റ്റോമി ആന്‍ഡ് പ്രിന്‍സിപ്പി ഡോബ്ര",
      "SUR": "സോവിയറ്റ് റൂബിള്‍",
      "SVC": "എല്‍ സാല്‍വഡോര്‍ കോളന്‍",
      "SYP": "സിറിയന്‍ പൌണ്ട്",
      "SZL": "സ്വാസിലാന്‍ഡ് ലിലാംഗനി",
      "THB": "തായ് ബട്ട്",
      "TJR": "താജിക്കിസ്ഥാന്‍ റൂബിള്‍",
      "TJS": "താജിക്കിസ്ഥാന്‍ സൊമോനി",
      "TMM": "തുര്‍ക്മെനിസ്ഥാന്‍ മനത്",
      "TMT": "തുര്‍ക്കമനിസ്ഥാനി മനാത്ത്",
      "TND": "തുനീസിയന്‍ ദിനാര്‍",
      "TOP": "റ്റോംഗ പാംഗ",
      "TPE": "തിമോര്‍ എസ്ക്യൂഡോ",
      "TRL": "പ്രാചീന തുര്‍ക്കിഷ് ലിറ",
      "TRY": "തുര്‍ക്കിഷ് ലിറ",
      "TTD": "ട്രിനിഡാഡ് ആന്‍ഡ് റ്റൊബാഗോ ഡോളര്‍",
      "TWD": "തായ്‌വാന്‍ ഡോളര്‍",
      "TZS": "ടാന്‍സാനിയന്‍ ഷില്ലിംഗ്",
      "UAH": "യുക്രേനിയന്‍ ഹ്രിവ്നിയ",
      "UAK": "യുക്രേനിയന്‍ കാര്‍ബോവാനെസ്",
      "UGS": "ഉഗാണ്ടന്‍ ഷില്ലിംഗ് (1966-1987)",
      "UGX": "ഉഗാണ്ടന്‍ ഷില്ലിംഗ്",
      "USD": "യു.എസ്. ഡോളര്‍",
      "USN": "യുഎസ് ഡോളര്‍ (അടുത്ത ദിവസം)",
      "USS": "യുഎസ് ഡോളര്‍ (അതേ ദിവസം)",
      "UYI": "ഉറുഗ്വേ പെയ്സോ എന്‍ യൂണിഡാഡ്സ്",
      "UYP": "ഉറുഗ്വേ പെയ്സോ (1975-1993)",
      "UYU": "ഉറുഗ്വേ പെയ്സോ ഉറുഗായോ",
      "UZS": "ഉസ്ബക്കിസ്ഥാന്‍ സം",
      "VEB": "വെനസ്വേലന്‍ ബോലിവര്‍",
      "VEF": "വെനസ്വേലന്‍ ബോലിവര്‍ ഫുവെര്‍റ്റെ",
      "VND": "വിയറ്റ്നാമീസ് ഡോങ്",
      "VUV": "വനുവാതു വാതു",
      "WST": "പശ്ചിമ സമോവ താല",
      "XAF": "CFA ഫ്രാങ്ക് BEAC",
      "XAG": "വെള്ളി",
      "XAU": "സ്വര്‍ണ്ണം",
      "XBA": "യൂറോപ്യന്‍ കോന്പസിറ്റ് യൂണിറ്റ്",
      "XBB": "യൂറോപ്യന്‍ മോണിറ്ററി യൂണിറ്റ്",
      "XBC": "യൂറോപ്യന്‍ യൂണിറ്റ് ഓഫ് അക്കൌണ്ട് (XBC)",
      "XBD": "യൂറോപ്യന്‍ യൂണിറ്റ് ഓഫ് അക്കൌണ്ട് (XBD)",
      "XCD": "കിഴക്കന്‍ കരീബിയന്‍ ഡോളര്‍",
      "XDR": "സ്പെഷ്യല്‍ ഡ്രോയിംഗ് റൈറ്റ്സ്",
      "XEU": "യൂറോപ്യന്‍ നാണയ യൂണിറ്റ്",
      "XFO": "ഫ്രെഞ്ച് ഗോള്‍ഡ് ഫ്രാങ്ക്",
      "XFU": "ഫ്രെഞ്ച് UIC-ഫ്രാങ്ക്",
      "XOF": "CFA ഫ്രാങ്ക് BCEAO",
      "XPD": "പലാഡിയം",
      "XPF": "CFP ഫ്രാങ്ക്",
      "XPT": "പ്ലാറ്റിനം",
      "XRE": "RINET ഫണ്ട്സ്",
      "XTS": "ടെസ്റ്റിംഗിനുള്ള കറന്‍സി കോഡ്",
      "XXX": "അറിയപ്പെടാത്തതോ നിലവിലില്ലാത്തതോ ആയ നാണയം",
      "YDD": "യമനി ദിനാര്‍",
      "YER": "യമനി റിയാല്‍",
      "YUD": "യൂഗോസ്ലേവിയന്‍ ഹാര്‍ഡ് ദിനാര്‍",
      "YUM": "യൂഗോസ്ലേവിയന്‍ നോവി ദിനാര്‍",
      "YUN": "യൂഗോസ്ലേവിയന്‍ കണ്‍വേര്‍ട്ടിബിള്‍ ദിനാര്‍",
      "ZAL": "ദക്ഷിണാഫ്രിക്കന്‍ റാന്‍ഡ് (ഫിനാന്‍ഷ്യല്‍)",
      "ZAR": "ദക്ഷിണ ആഫ്രിക്കന്‍ റാന്‍ഡ്",
      "ZMK": "സാംബിയന്‍ ക്വാച",
      "ZRN": "സൈറിയന്‍ ന്യൂ സൈര്‍",
      "ZRZ": "സൈറിയന്‍ സൈര്‍",
      "ZWD": "സിംബാബ്‌വെ ഡോളര്‍",
    };
  }-*/;
}
