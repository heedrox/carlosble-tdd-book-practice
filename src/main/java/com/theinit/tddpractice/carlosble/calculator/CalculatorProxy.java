package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class CalculatorProxy implements ICalculatorProxy {

    Calculator calculator;
    Validator validator;

    public CalculatorProxy(Calculator calculator, Validator validator) {
        this.calculator = calculator;
        this.validator = validator;
    }

    @Override
    public int binaryOperation(int operation, int arg1, int arg2) throws OverflowException{
        this.validator.validateArgs(arg1, arg2);
        if (operation == Calculator.ADD) {
            return this.calculator.add(arg1, arg2);
        } else if (operation == Calculator.SUBSTRACT){
            return this.calculator.substract(arg1, arg2);
        } else if (operation == Calculator.MULTIPLY) {
            return this.calculator.multiply(arg1, arg2);
        } else {
            return this.calculator.divide(arg1, arg2);
        }
    }

}
