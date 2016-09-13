package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class MathTokenTest {

    @Test
    public void equals() throws Exception {

        MathToken tokenA = new MathToken("TOKEN");
        MathToken tokenB = new MathToken("TOKEN");

        assertEquals("tokens should be considered equal", tokenA, tokenB);
    }


    @Test
    public void isStringizable() throws Exception {

        MathToken tokenA = new MathToken("TOKEN");

        assertEquals(tokenA.toString(), "TOKEN");
    }

    @Test
    @Parameters({"367,367", "1,1"})
    public void getsTheIntValue(String value, int intValue) throws Exception {

        MathToken token = new MathToken(value);

        assertEquals(token.intValue(), intValue);
    }

    @Test
    @Parameters({"+", "-", "*", "/"})
    public void knowsThatAreOperators(String operator) throws Exception {

        MathToken token = new MathToken(operator);

        assertTrue(token.isOperator());
    }

    @Test
    @Parameters({"2", "49", "L"})
    public void knowsThatAreNotOperators(String operator) throws Exception {

        MathToken token = new MathToken(operator);

        assertFalse("*"+operator+"* should not be an operator", token.isOperator());
    }

    @Test
    @Parameters(method = "operators")
    public void knowsOperators(String operatorString, int expectedOperatorMethod) throws Exception {

        MathToken token = new MathToken(operatorString);
        int operatorMethod = token.getOperator();

        assertEquals("Operator "+operatorString+" should be linked to operation "+expectedOperatorMethod, expectedOperatorMethod, operatorMethod);
    }

    private Object[] operators() {
        return new Object[]{
                new Object[]{"+", Calculator.ADD},
                new Object[]{"-", Calculator.SUBSTRACT},
                new Object[]{"*", Calculator.MULTIPLY},
                new Object[]{"/", Calculator.DIVIDE},
        };
    }

}