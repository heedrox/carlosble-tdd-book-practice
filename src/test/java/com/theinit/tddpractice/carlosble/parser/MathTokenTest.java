package com.theinit.tddpractice.carlosble.parser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathTokenTest {

    @Test
    public void equals() throws Exception {

        MathToken tokenA = new MathToken("TOKEN");
        MathToken tokenB = new MathToken("TOKEN");

        assertEquals("tokens should be considered equal", tokenA, tokenB);
    }

}