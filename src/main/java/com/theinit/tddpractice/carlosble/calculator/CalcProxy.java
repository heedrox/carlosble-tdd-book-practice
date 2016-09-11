package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class CalcProxy {
    Calculator calculator;
    Validator validator;

    int minValue;
    int maxValue;

    public CalcProxy(Calculator calculator, Validator validator, int calculatorMinValue, int calculatorMaxValue) {
        this.calculator = calculator;
        this.validator = validator;
        this.minValue = calculatorMinValue;
        this.maxValue = calculatorMaxValue;
    }

    public void binaryOperation(int operation, int arg1, int arg2) throws OverflowException{
        this.validator.setLimits(this.minValue, this.maxValue);
        this.validator.validateArgs(arg1, arg2);
        this.calculator.add(arg1, arg2);
    }
}
