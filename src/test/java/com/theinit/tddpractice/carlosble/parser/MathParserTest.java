package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.Calculator;
import com.theinit.tddpractice.carlosble.calculator.ICalculatorProxy;
import com.theinit.tddpractice.carlosble.calculator.OverflowException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 12/9/16.
 */
public class MathParserTest {


    @Test
    public void parserWorksWithCalcProxy() throws OverflowException, InvalidOperationException {
        String aValidExpression = "2 + 3";
        ILexer mockLexer = Mockito.mock(ILexer.class);
        Mockito.when(mockLexer.getTokens(aValidExpression)).thenReturn(aListOfTokens("2", "+", "3"));
        ICalculatorProxy mockCalcProxy = Mockito.mock(ICalculatorProxy.class);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 2, 3)).thenReturn(5);

        MathParser mathParser = new MathParser(mockCalcProxy, mockLexer);
        int result = mathParser.processExpression(aValidExpression);

        Assert.assertEquals(5, result);
        Mockito.verify(mockCalcProxy).binaryOperation(Calculator.ADD, 2, 3);
    }

    @Test
    public void parserWorksWithLexer() throws InvalidOperationException, OverflowException {
        String aValidExpression = "2 + 3";
        ILexer mockLexer = Mockito.mock(ILexer.class);
        Mockito.when(mockLexer.getTokens(aValidExpression)).thenReturn(aListOfTokens("2", "+", "3"));
        ICalculatorProxy mockCalcProxy = Mockito.mock(ICalculatorProxy.class);
        Mockito.when(mockCalcProxy.binaryOperation(Calculator.ADD, 2, 3)).thenReturn(5);


        MathParser mathParser = new MathParser(mockCalcProxy, mockLexer);
        int result = mathParser.processExpression(aValidExpression);

        Mockito.verify(mockLexer).getTokens(aValidExpression);
    }

    private List<MathToken> aListOfTokens(String ... args) {
        ArrayList<MathToken> tokens = new ArrayList<>();
        for (String stringToken: args) {
            tokens.add(new MathToken(stringToken));
        }
        return tokens;
    }
}