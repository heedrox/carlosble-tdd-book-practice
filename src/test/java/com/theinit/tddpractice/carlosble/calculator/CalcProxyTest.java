package com.theinit.tddpractice.carlosble.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class CalcProxyTest {


    int minValue = -100;
    int maxValue = 100;

    @Test
    @Parameters({"2, 2, 4",
                 "3, 4, 7" })
    public void addsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Calculator calculator = new Calculator(minValue, maxValue);
        CalcProxy calcProxy = new CalcProxy(calculator);

        int result = calcProxy.binaryOperation(Calculator.ADD, arg1, arg2);

        Assert.assertEquals("adding "+arg1+ " + "+arg2+" gives "+expectedResult, expectedResult, result);
    }

    @Test
    @Parameters({"2, 2, 0",
                 "3, 4, -1",
                 "5, 3, 2"})
    public void substractsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Calculator calculator = new Calculator(minValue, maxValue);
        CalcProxy calcProxy = new CalcProxy(calculator);

        int result = calcProxy.binaryOperation(Calculator.SUBSTRACT, arg1, arg2);

        Assert.assertEquals("substracting "+arg1+ " - "+arg2+" gives "+expectedResult, expectedResult, result);
    }


}