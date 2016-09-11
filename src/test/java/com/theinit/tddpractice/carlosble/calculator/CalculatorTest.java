package com.theinit.tddpractice.carlosble.calculator;

import junitparams.JUnitParamsRunner;
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
        this.calculator = new Calculator();
    }

    @Test
    public void calculatorAdds() {
        int result = calculator.add(2,3);
        Assert.assertEquals("2 + 3 = 5", 5, result);
    }

    @Test
    public void calculatorSubstracts() {
        int result = calculator.substract(2,3);
        Assert.assertEquals("2 - 3 = -1", -1, result);
    }

}