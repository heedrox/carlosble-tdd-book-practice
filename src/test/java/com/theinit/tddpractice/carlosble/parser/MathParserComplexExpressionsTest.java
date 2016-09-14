package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 12/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class MathParserComplexExpressionsTest {

    private ILexer mockLexer;
    private ICalculatorProxy mockCalcProxy;

    private String TWO_PLUS_THREE_PLUS_FIVE_STRING = "2 + 3 + 5";
    private List<MathToken> TWO_PLUS_THREE_PLUS_FIVE_TOKENS = aListOfTokens("2", "+", "3", "+", "5");

    private String TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_STRING = "2 + 3 + 5 - 6";
    private List<MathToken> TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_TOKENS = aListOfTokens("2", "+", "3", "+", "5", "-", "6");

    @Before
    public void setUpMocks() throws InvalidOperationException, OverflowException {
        mockLexer = Mockito.mock(ILexer.class);
        mockCalcProxy = Mockito.mock(ICalculatorProxy.class);
    }

    @Test
    public void processExpressionWithTwoOperands() throws OverflowException, InvalidOperationException {
        Mockito.when(mockLexer.getTokens(TWO_PLUS_THREE_PLUS_FIVE_STRING)).thenReturn(TWO_PLUS_THREE_PLUS_FIVE_TOKENS);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 2, 3)).thenReturn(5);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 5, 5)).thenReturn(10);
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int result = parser.processExpression(TWO_PLUS_THREE_PLUS_FIVE_STRING);

        Assert.assertEquals(10, result);
    }

    @Test
    public void processExpressionWithThreeOperands() throws OverflowException, InvalidOperationException {
        Mockito.when(mockLexer.getTokens(TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_STRING)).thenReturn(TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_TOKENS);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.SUBSTRACT, 5, 6)).thenReturn(-1);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 2, 3)).thenReturn(5);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 5, -1)).thenReturn(4);
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int result = parser.processExpression(TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_STRING);

        Assert.assertEquals(4, result);
    }

    @Test
    public void processExpressionWithPrecedence() throws OverflowException, InvalidOperationException {
        Mockito.when(mockLexer.getTokens("4 + 6 / 2")).thenReturn(aListOfTokens("4", "+", "6", "/", "2"));
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.DIVIDE, 6, 2)).thenReturn(3);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 4, 3)).thenReturn(7);
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int result = parser.processExpression("4 + 6 / 2");

        Assert.assertEquals(7, result);
    }

    @Test
    public void processExpressionWithPrecedenceMoreComplex() throws OverflowException, InvalidOperationException {
        Mockito.when(mockLexer.getTokens("5 + 4 * 2 / 2")).thenReturn(aListOfTokens("5", "+", "4", "*", "2", "/", "2"));
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.DIVIDE, 2, 2)).thenReturn(1);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.MULTIPLY, 4, 1)).thenReturn(4);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 5, 4)).thenReturn(9);
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int result = parser.processExpression("5 + 4 * 2 / 2");

        Assert.assertEquals(9, result);
    }

    @Test
    @Parameters(method = "tokensForPrecedenceOperator")
    public void knowsNextOperatorByPrecedence(List<MathToken> tokens, int expectedOperator) throws OverflowException, InvalidOperationException {
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int operator = parser.getNextTokenOperatorToCalculate(tokens);

        Assert.assertEquals(expectedOperator, operator);
    }


    private Object[] tokensForPrecedenceOperator() {
        return new Object[]{
                new Object[]{aListOfTokens("2", "+", "4", "/", "9"), 3 },
                new Object[]{aListOfTokens("2", "/", "2", "+", "1"), 1 },
                new Object[]{aListOfTokens("2", "+", "4", "/", "9", "*", "8"), 3 },
                new Object[]{aListOfTokens("2", "+", "4", "-", "9", "*", "8"), 5 }
        };
    }


    private List<MathToken> aListOfTokens(String ... args) {
        ArrayList<MathToken> tokens = new ArrayList<>();
        for (String stringToken: args) {
            tokens.add(new MathToken(stringToken));
        }
        return tokens;
    }

}