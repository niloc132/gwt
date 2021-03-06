/*
 * Copyright 2009 Google Inc.
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
package com.google.gwt.rpc.client.ast;

import com.google.gwt.rpc.client.ast.RpcCommandVisitor.Context;

/**
 * Encapsulates a boolean value in the command stream.
 */
public class ByteValueCommand extends ScalarValueCommand {
  private final byte value;

  public ByteValueCommand(double value) {
    this.value = (byte) value;
  }

  public ByteValueCommand(byte value) {
    this.value = value;
  }

  public ByteValueCommand(Byte value) {
    this.value = value;
  }

  @Override
  public Byte getValue() {
    return value;
  }

  @Override
  public void traverse(RpcCommandVisitor visitor, Context ctx) {
    visitor.visit(this, ctx);
    visitor.endVisit(this, ctx);
  }
}
