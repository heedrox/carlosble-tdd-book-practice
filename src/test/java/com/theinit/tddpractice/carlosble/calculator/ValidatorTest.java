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
public class ValidatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Validator validator;

    private int minValue = -100;
    private int maxValue = 100;

    @Before
    public void setupValidator() {
        this.validator = new Validator();
    }

    @Test
    @Parameters({ "1, 0, false",
            "101, 0, true",
            "0, 101, true",
            "-101, 0, true",
            "0, -101, true"})
    public void validatesArguments(int arg1, int arg2, boolean expectedOverflowExceptionThrown) throws OverflowException{

        if (expectedOverflowExceptionThrown) {
            thrown.expect(OverflowException.class);
        }

        validator.setLimits(minValue, maxValue);
        validator.validateArgs(arg1, arg2);

    }


}