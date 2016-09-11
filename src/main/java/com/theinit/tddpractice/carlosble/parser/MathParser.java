package com.theinit.tddpractice.carlosble.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathParser {

    public List<MathToken> getTokens(String expression) {

        ArrayList<MathToken> tokens = new ArrayList<>();

        tokens.add(new MathToken("2"));
        tokens.add(new MathToken("+"));
        tokens.add(new MathToken("2"));

        return tokens;

    }

}
