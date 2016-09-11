package com.theinit.tddpractice.carlosble.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class CalculatorTest {

    @Test
    public void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2,2);
        Assert.assertEquals("The sum of 2 and 2 should be 4", 4, result);
    }
}