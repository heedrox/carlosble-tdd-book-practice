package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.ICalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.OverflowException;

import java.util.List;
import java.util.stream.Collectors;

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


        while (tokens.size()>1) {
//            System.out.println( tokens.stream().map(Object::toString).collect(Collectors.joining(" ")));
            int numToken = getNextTokenOperatorToCalculate(tokens);
            substituteTokensWithOperationResultAtTokenPosition(tokens, numToken);
        }

        return tokens.get(0).intValue();
    }

    public void substituteTokensWithOperationResultAtTokenPosition(List<MathToken> tokens, int numToken) throws OverflowException {
        int operator = tokens.get(numToken).getOperator();
        int currentValue =  calcProxy.binaryOperation(operator, tokens.get(numToken-1).intValue(), tokens.get(numToken+1).intValue());
        substituteTokensWithValue(tokens, numToken, currentValue);
    }

    private void substituteTokensWithValue(List<MathToken> tokens, int numToken, int currentValue) {
        tokens.remove(numToken-1);
        tokens.remove(numToken-1);
        tokens.remove(numToken-1);
        tokens.add(numToken-1, new MathToken(currentValue+""));
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
