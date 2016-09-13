package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.Calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathToken {

    String stringToken;

    public MathToken(String stringToken) {
        this.stringToken = stringToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathToken mathToken = (MathToken) o;

        return stringToken != null ? stringToken.equals(mathToken.stringToken) : mathToken.stringToken == null;
    }

    @Override
    public String toString() {
        return stringToken;
    }

    public int intValue() {
        return Integer.valueOf(stringToken);
    }

    public boolean isOperator() {
        return ("+-*/".indexOf(this.stringToken))>=0;
    }

    public int getOperator() {
        switch (this.stringToken) {
            case "+" : return Calculator.ADD;
            case "-" : return Calculator.SUBSTRACT;
            case "*" : return Calculator.MULTIPLY;
            case "/" : return Calculator.DIVIDE;
        }
        return 0;
    }
}
