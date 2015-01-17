/*
 * Copyright 2014 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shapesecurity.shift.ast.expression;

import com.shapesecurity.shift.ast.Expression;
import com.shapesecurity.shift.ast.operators.Precedence;
import com.shapesecurity.shift.ast.types.Type;

import org.jetbrains.annotations.NotNull;

public class ConditionalExpression extends Expression {
  @NotNull
  public final Expression test;
  @NotNull
  public final Expression consequent;
  @NotNull
  public final Expression alternate;

  public ConditionalExpression(
      @NotNull Expression test,
      @NotNull Expression consequent,
      @NotNull Expression alternate) {
    super();
    this.test = test;
    this.consequent = consequent;
    this.alternate = alternate;
  }

  public Precedence getPrecedence() {
    return Precedence.CONDITIONAL;
  }

  @NotNull
  @Override
  public Type type() {
    return Type.ConditionalExpression;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof ConditionalExpression &&
           this.test.equals(((ConditionalExpression) object).test) &&
           this.consequent.equals(((ConditionalExpression) object).consequent) &&
           this.alternate.equals(((ConditionalExpression) object).alternate);
  }

  @NotNull
  public Expression getTest() {
    return this.test;
  }

  @NotNull
  public Expression getConsequent() {
    return this.consequent;
  }

  @NotNull
  public Expression getAlternate() {
    return this.alternate;
  }

  @NotNull
  public ConditionalExpression setTest(@NotNull Expression test) {
    return new ConditionalExpression(test, this.consequent, this.alternate);
  }

  @NotNull
  public ConditionalExpression setConsequent(@NotNull Expression consequent) {
    return new ConditionalExpression(this.test, consequent, this.alternate);
  }

  @NotNull
  public ConditionalExpression setAlternate(@NotNull Expression alternate) {
    return new ConditionalExpression(this.test, this.consequent, alternate);
  }
}
