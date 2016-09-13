package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 12/9/16.
 */
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
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 2, 3)).thenReturn(5);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 5, 5)).thenReturn(10);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.SUBSTRACT, 10, 6)).thenReturn(4);
        MathParser parser = new MathParser(mockCalcProxy, mockLexer);

        int result = parser.processExpression(TWO_PLUS_THREE_PLUS_FIVE_MINUS_SIX_STRING);

        Assert.assertEquals(4, result);
    }

    private List<MathToken> aListOfTokens(String ... args) {
        ArrayList<MathToken> tokens = new ArrayList<>();
        for (String stringToken: args) {
            tokens.add(new MathToken(stringToken));
        }
        return tokens;
    }

}