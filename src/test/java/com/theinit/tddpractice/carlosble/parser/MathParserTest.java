package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.parser.MathParser;
import com.theinit.tddpractice.carlosble.parser.MathToken;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class MathParserTest {

    @Test
    public void parsesBinaryTokens() {

        MathParser parser = new MathParser();

        List<MathToken> tokens = parser.getTokens("2 + 2");

        Assert.assertArrayEquals("tokens are 2, +, 2", arrayOfTokens("2", "+", "2"), tokens.toArray());
    }

    private MathToken[] arrayOfTokens(String ... args) {
        ArrayList<MathToken> tokens = new ArrayList<>();
        for (String stringToken: args) {
            tokens.add(new MathToken(stringToken));
        }
        return tokens.toArray(new MathToken[0]);
    }


}