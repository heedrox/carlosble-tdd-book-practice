package com.theinit.tddpractice.carlosble.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathLexer implements ILexer {

    private ExpressionValidator expressionValidator;

    public MathLexer(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    @Override
    public List<MathToken> getTokens(String expression) throws InvalidOperationException {

        throwExceptionIfNotValid(expression);

        String[] tokenStrings = expression.split(" +");

        return getMathTokenList(tokenStrings);

    }

    private void throwExceptionIfNotValid(String expression) throws InvalidOperationException {
        if (!expressionValidator.isValid(expression)) {
            throw new InvalidOperationException("Expression not valid: "+expression);
        }
    }

    private ArrayList<MathToken> getMathTokenList(String[] tokenStrings) {
        ArrayList<MathToken> tokens = new ArrayList<>();

        for (String tokenString : tokenStrings) {
            tokens.add(new MathToken(tokenString));
        }
        return tokens;
    }

}
