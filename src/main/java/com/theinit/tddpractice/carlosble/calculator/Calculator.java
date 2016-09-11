package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class Calculator {

    public static final int ADD = 1;

    int minValue;
    int maxValue;

    public Calculator() {
    }


    public Calculator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int add(int operand1, int operand2) throws OverflowException {

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

