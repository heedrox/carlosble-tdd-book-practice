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

    public int add(int operand1, int operand2) throws OverflowException {
        if (operand1 > maxValue) { throw new OverflowException("argument 1 greater than max value"); }
        if (operand1 < minValue) { throw new OverflowException("argument 1 less than min value"); }
        if (operand2 < minValue) { throw new OverflowException("argument 2 less than min value"); }
        if (operand2 > maxValue) { throw new OverflowException("argument 2 greater than max value"); }

        int result = operand1 + operand2;

        if (result > maxValue) throw new OverflowException("result over maxValue");
        return result;
    }

    public int substract(int operand1, int operand2) throws OverflowException {
        int result = operand1 - operand2;
        if (result < this.minValue) throw new OverflowException("result under minValue");
        return result;
    }
}
