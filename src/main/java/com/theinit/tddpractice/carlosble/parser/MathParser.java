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

        if ( (s.contains("*")) || (s.contains("/")) ) { return processNewExpression(s); } //TODO remove when finished
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

    public int processNewExpression(String s) throws OverflowException, InvalidOperationException {
        List<MathToken> tokens = lexer.getTokens(s);

        int currentValue = 7;
//        int numToken = getNextTokenOperatorToCalculate(tokens);
//        int currentValue = tokens.get(0).intValue();
//        int currentOperator = 0;
//        for (int i=1; i<tokens.size();i++) {
//            if (tokens.get(i).isOperator()) {
//                currentOperator = tokens.get(i).getOperator();
//            } else {
//                currentValue = calcProxy.binaryOperation(currentOperator, currentValue, tokens.get(i).intValue());
//            }
//
//        }

        return currentValue;
    }

    public int getNextTokenOperatorToCalculate(List<MathToken> tokens) {
        String operators = "/*-+";
        for (int i=0;i<operators.length();i++) {
            int position = findInTokens(tokens, operators.charAt(i));
            if (position>0) return position;
        }
        return 0;
    }

    private int findInTokens(List<MathToken> tokens, char operator) {
        return tokens.indexOf(new MathToken(operator+""));
    }

}
