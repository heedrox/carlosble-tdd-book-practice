package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.Calculator;
import com.theinit.tddpractice.carlosble.calculator.CalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.ICalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.OverflowException;

import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathParser {

    ICalculatorProxy calcProxy;
    ILexer lexer;

    public MathParser(ICalculatorProxy calcProxy, ILexer lexer) {
        this.calcProxy = calcProxy;
        this.lexer = lexer;
    }

    public int processExpression(String s) throws OverflowException, InvalidOperationException {
        List<MathToken> tokens = lexer.getTokens(s);

        int currentValue = tokens.get(0).intValue();
        int currentOperator = 0;
        for (int i=1; i<tokens.size();i++) {
            if (tokens.get(i).isOperator()) {
                currentOperator = tokens.get(i).getOperator();
            } else {
                currentValue = calcProxy.binaryOperation(currentOperator, currentValue, tokens.get(i).intValue());
            }

        }

        return currentValue;
    }
}
