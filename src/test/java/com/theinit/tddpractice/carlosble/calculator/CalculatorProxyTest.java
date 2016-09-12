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
public class CalculatorProxyTest {

    private int minValue = -100;
    private int maxValue = 100;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Calculator calculator;

    @Before
    public void setupCalculator() {
        this.calculator = new Calculator();
    }

    @Test
    @Parameters({"2, 2, 4",
                 "3, 4, 7" })
    public void addsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        int result = calcProxy.binaryOperation(Calculator.ADD, arg1, arg2);

        Assert.assertEquals("adding "+arg1+ " + "+arg2+" gives "+expectedResult, expectedResult, result);
    }

    @Test
    @Parameters({"2, 2, 0",
                 "3, 4, -1",
                 "5, 3, 2"})
    public void substractsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        int result = calcProxy.binaryOperation(Calculator.SUBSTRACT, arg1, arg2);

        Assert.assertEquals("substracting "+arg1+ " - "+arg2+" gives "+expectedResult, expectedResult, result);
    }



    @Test
    public void resultExceedingMaxValue() throws OverflowException {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        thrown.expect(OverflowException.class);

        calcProxy.binaryOperation(Calculator.SUBSTRACT, 50, 150);
    }

    @Test()
    public void resultExceedingMinValue() throws OverflowException {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        thrown.expect(OverflowException.class);

        calcProxy.binaryOperation(Calculator.SUBSTRACT, 10, 150);
    }

    @Test
    public void argumentsExceedLimits() throws OverflowException {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        thrown.expect(OverflowException.class);

        calcProxy.binaryOperation(Calculator.SUBSTRACT, maxValue+1, minValue-1);
    }

    @Test
    public void argumentsExceedLimitsOtherWay() throws OverflowException {
        Validator validator = new Validator(minValue, maxValue);
        CalculatorProxy calcProxy = new CalculatorProxy(calculator, validator);

        thrown.expect(OverflowException.class);

        calcProxy.binaryOperation(Calculator.SUBSTRACT, minValue-1, maxValue+1);
    }



}