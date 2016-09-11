package com.theinit.tddpractice.carlosble.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathParser {

    public List<MathToken> getTokens(String expression) {

        ArrayList<MathToken> tokens = new ArrayList<>();

        String[] tokenStrings = expression.split(" ");

        for (String tokenString : tokenStrings) {
            tokens.add(new MathToken(tokenString));
        }

        return tokens;

    }

}
