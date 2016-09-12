package com.theinit.tddpractice.carlosble.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathLexer {

    private ExpressionValidator expressionValidator;

    public MathLexer(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    public List<MathToken> getTokens(String expression) throws InvalidOperationException {

        if (!expressionValidator.isValid(expression)) {
            throw new InvalidOperationException("Expression not valid: "+expression);
        }

        ArrayList<MathToken> tokens = new ArrayList<>();

        String[] tokenStrings = expression.split(" ");

        for (String tokenString : tokenStrings) {
            tokens.add(new MathToken(tokenString));
        }

        return tokens;

    }

}
