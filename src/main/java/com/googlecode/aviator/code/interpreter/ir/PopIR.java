package com.googlecode.aviator.code.interpreter.ir;

import com.googlecode.aviator.code.interpreter.IR;
import com.googlecode.aviator.code.interpreter.InterpretContext;

public class PopIR implements IR {
  public static PopIR INSTANCE = new PopIR();

  private PopIR() {}

  @Override
  public void eval(final InterpretContext context) {
    context.pop();
    context.dispatch();
  }

  @Override
  public String toString() {
    return "pop";
  }

}
