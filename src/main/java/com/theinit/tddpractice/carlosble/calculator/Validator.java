package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class Validator {

    int minValue;
    int maxValue;

    public Validator() {
    }

    public void validateArgs(int operand1, int operand2) throws OverflowException {
        if (operand1 > maxValue) { throw new OverflowException("argument 1 greater than max value"); }
        if (operand1 < minValue) { throw new OverflowException("argument 1 less than min value"); }
        if (operand2 < minValue) { throw new OverflowException("argument 2 less than min value"); }
        if (operand2 > maxValue) { throw new OverflowException("argument 2 greater than max value"); }
    }

    public void setLimits(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
