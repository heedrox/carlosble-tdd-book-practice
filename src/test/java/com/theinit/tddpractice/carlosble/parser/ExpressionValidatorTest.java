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
            "2 / 2",
            "2  +    4",
            "2-9",
            "2 + 4 - 3",
            "-8 + 2"})
    public void validExpressions(String expression) {
        ExpressionValidator expressionValidator = new ExpressionValidator();

        boolean isValid = expressionValidator.isValid(expression);

        assertTrue("valid " + expression, isValid);
    }

    @Test
    @Parameters({"2 +\\, 3",
            "2a7",
            "2 -a 4",
            "2 -+ 3",
            "+ + 7",
            "++7",
            "4++7",
            "2 + 7 - 2 a 3 b"})
    public void invalidExpressions(String expression) {
        ExpressionValidator expressionValidator = new ExpressionValidator();

        boolean isValid = expressionValidator.isValid(expression);

        assertFalse("not valid " + expression, isValid);
    }

}