package com.theinit.tddpractice.carlosble.calculator;

/**
 * Created by INIT SERVICES on 12/9/16.
 */
public interface ICalculatorProxy {

    int binaryOperation(int operation, int arg1, int arg2) throws OverflowException;

}
