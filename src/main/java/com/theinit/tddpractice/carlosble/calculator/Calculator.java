package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class Calculator {

    int minValue;
    int maxValue;

    public Calculator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int substract(int operand1, int operand2) throws OverflowException {
        int result = operand1 - operand2;
        if (result < this.minValue) throw new OverflowException("result under minValue");
        return result;
    }
}
