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

import com.google.gwt.core.client.GwtScriptOnly;
import com.google.gwt.i18n.shared.DateTimeFormatInfo;
import com.google.gwt.i18n.shared.NumberConstants;

// DO NOT EDIT - GENERATED FROM CLDR AND ICU DATA:
//  cldrVersion=21.0
//  date=$Date: 2011-07-04 19:22:55 -0400 (Mon, 04 Jul 2011) $
//  number=$Revision: 5953 $
//  type=root

/**
 * Locale information for the "en_Shaw" locale.

 */
@GwtScriptOnly
public class LocaleInfoImpl_en_Shaw extends LocaleInfoImpl_en {
  
  @Override
  public String getLocaleName() {
    return "en_Shaw";
  }
  
  @Override
  protected DateTimeFormatInfo createDateTimeFormatInfo() {
    return new com.google.gwt.i18n.shared.cldr.DateTimeFormatInfoImpl_en_Shaw();
  }
  
  @Override
  protected NumberConstants createNumberConstants() {
    return new com.google.gwt.i18n.shared.cldr.NumberConstantsImpl_en_Shaw();
  }
}
