package com.theinit.tddpractice.carlosble.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    @Parameters(
                {"2, 2, 4",
                 "3, 4, 7" })
    public void addsTwoNumbers(int operand1, int operand2, int expectedResult) {
        Calculator calculator = new Calculator();
        int result = calculator.add(operand1,operand2);
        Assert.assertEquals("The sum of "+operand1+" and "+operand2+" should be "+expectedResult, expectedResult, result);
    }

}