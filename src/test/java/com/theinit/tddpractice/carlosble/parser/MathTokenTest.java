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
public class MathTokenTest {

    @Test
    public void equals() throws Exception {

        MathToken tokenA = new MathToken("TOKEN");
        MathToken tokenB = new MathToken("TOKEN");

        assertEquals("tokens should be considered equal", tokenA, tokenB);
    }


    @Test
    public void isStringizable() throws Exception {

        MathToken tokenA = new MathToken("TOKEN");

        assertEquals(tokenA.toString(), "TOKEN");
    }

    @Test
    @Parameters({"367,367", "1,1"})
    public void getsTheIntValue(String value, int intValue) throws Exception {

        MathToken token = new MathToken(value);

        assertEquals(token.intValue(), intValue);
    }

}