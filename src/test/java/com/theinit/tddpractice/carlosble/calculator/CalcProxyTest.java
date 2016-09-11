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
public class CalcProxyTest {

    private int calculatorMinValue = -100;
    private int calculatorMaxValue = 100;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    Calculator calculator;

    @Before
    public void setupCalculator() {
        this.calculator = new Calculator();
    }


    @Test
    @Parameters({"2, 2, 4",
                 "3, 4, 7" })
    public void addsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Calculator calculator = new Calculator();
        CalcProxy calcProxy = new CalcProxy(calculator);

        int result = calcProxy.binaryOperation(Calculator.ADD, arg1, arg2);

        Assert.assertEquals("adding "+arg1+ " + "+arg2+" gives "+expectedResult, expectedResult, result);
    }

    @Test
    @Parameters({"2, 2, 0",
                 "3, 4, -1",
                 "5, 3, 2"})
    public void substractsTwoNumbers(int arg1, int arg2, int expectedResult) throws OverflowException  {
        Calculator calculator = new Calculator();
        CalcProxy calcProxy = new CalcProxy(calculator);

        int result = calcProxy.binaryOperation(Calculator.SUBSTRACT, arg1, arg2);

        Assert.assertEquals("substracting "+arg1+ " - "+arg2+" gives "+expectedResult, expectedResult, result);
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

    @Test
    public void addWhenArgumentsExceedLimits() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.add(calculatorMaxValue + 1, calculatorMinValue - 1);
    }

    @Test
    public void addWhenArgumentsExceedLimitsOtherWay() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.add(calculatorMinValue - 1 , calculatorMaxValue + 1);
    }

    @Test
    public void substractWhenArgumentsExceedLimits() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.substract(calculatorMaxValue + 1, calculatorMinValue - 1);
    }

    @Test
    public void substractWhenArgumentsExceedLimitsOtherWay() throws OverflowException {
        thrown.expect(OverflowException.class);

        calculator.substract(calculatorMinValue - 1 , calculatorMaxValue + 1);
    }


}