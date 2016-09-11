package com.theinit.tddpractice.carlosble.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    Calculator calculator;

    @Before
    public void setupCalculator() {
        this.calculator = new Calculator(-100, 100);
    }

    @Test
    @Parameters({"2, 2, 4",
                 "3, 4, 7" })
    public void addsTwoNumbers(int operand1, int operand2, int expectedResult) throws OverflowException{
        int result = calculator.add(operand1,operand2);

        Assert.assertEquals("The sum of "+operand1+" and "+operand2+" should be "+expectedResult, expectedResult, result);
    }

    @Test
    @Parameters({"5, 3,  2",
                 "3, 5, -2" })
    public void substractsTwoNumbers(int operand1, int operand2, int expectedResult) throws OverflowException {
        int result = calculator.substract(operand1,operand2);

        Assert.assertEquals("The result of substracting "+operand1+" minus "+operand2+" should be "+expectedResult, expectedResult, result);
    }

    @Test()
    public void addExcedingMaxValue() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.add(50, 150);
    }

    @Test()
    public void substractExcedingMinValue() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.substract(10, 150);
    }

}