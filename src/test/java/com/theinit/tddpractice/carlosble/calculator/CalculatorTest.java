package com.theinit.tddpractice.carlosble.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.cglib.core.ReflectUtils;


/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    int calculatorMinValue = -100;
    int calculatorMaxValue = 100;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    Calculator calculator;

    @Before
    public void setupCalculator() {
        this.calculator = new Calculator(calculatorMinValue, calculatorMaxValue);
        this.calculator.setValidator(new Validator(calculatorMinValue, calculatorMaxValue));
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

    @Test
    public void whenSubstractingValidatorIsUsed() throws OverflowException  {
        int arg1 = 10;
        int arg2 = 20;

        Validator mockValidator = Mockito.mock(Validator.class);
        calculator.setValidator(mockValidator);


        calculator.substract(arg1, arg2);
        Mockito.verify(mockValidator).validateArgs(arg1, arg2);
    }
}