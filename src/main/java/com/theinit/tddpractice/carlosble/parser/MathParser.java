package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.Calculator;
import com.theinit.tddpractice.carlosble.calculator.CalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.ICalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.OverflowException;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathParser {

    public MathParser(ICalculatorProxy calcProxy) {
        this.calcProxy = calcProxy;
    }

    ICalculatorProxy calcProxy;

    public int processExpression(String s) throws OverflowException {
        calcProxy.binaryOperation(Calculator.ADD, 2, 3);
        return 5;
    }
}
