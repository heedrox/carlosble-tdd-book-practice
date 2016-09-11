package com.theinit.tddpractice.carlosble.parser;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class ExpressionValidatorTest {

    @Test
    @Parameters({"2 + 3",
    "253 + 24",
    "2 * 4",
    "2 - 3",
    "2 / 2"})
    public void validExpressions(String expression) {
        ExpressionValidator expressionValidator = new ExpressionValidator();

        boolean isValid = expressionValidator.isValid(expression);

        assertTrue(isValid);
    }

    @Test
    @Parameters({"2 +\\, 3"})
    public void invalidExpressions(String expression) {
        ExpressionValidator expressionValidator = new ExpressionValidator();

        boolean isValid = expressionValidator.isValid(expression);

        assertFalse(isValid);
    }

}