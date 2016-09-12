package com.theinit.tddpractice.carlosble.parser;

import com.theinit.tddpractice.carlosble.calculator.OverflowException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by INIT SERVICES on 11/9/16.
 */
@RunWith(JUnitParamsRunner.class)
public class MathLexterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    @Parameters(method = "binaryParameters")
    public void parsesBinaryTokens(String expression, MathToken[] expectedTokens) throws InvalidOperationException {
        ExpressionValidator expressionValidator = new ExpressionValidator();
        MathLexer lexer = new MathLexer(expressionValidator);

        List<MathToken> tokens = lexer.getTokens(expression);

        Assert.assertArrayEquals(expectedTokens , tokens.toArray());
    }

    @Test
    public void throwsErrorIfWrongBinaryTokens() throws InvalidOperationException {
        String invalidExpression = "2 - 1++ 3";
        ExpressionValidator expressionValidator = new ExpressionValidator();
        MathLexer lexer = new MathLexer(expressionValidator);

        thrown.expect(InvalidOperationException.class);

        List<MathToken> tokens = lexer.getTokens(invalidExpression);
    }



    private Object[] binaryParameters() {
        return new Object[]{
                new Object[]{"2 + 2", arrayOfTokens("2", "+", "2")},
                new Object[]{"3 - 4", arrayOfTokens("3", "-", "4")},
                new Object[]{"31 * 10", arrayOfTokens("31", "*", "10")},
                new Object[]{"27 / 3", arrayOfTokens("27", "/", "3")},
        };
    }

    private MathToken[] arrayOfTokens(String ... args) {
        ArrayList<MathToken> tokens = new ArrayList<>();
        for (String stringToken: args) {
            tokens.add(new MathToken(stringToken));
        }
        return tokens.toArray(new MathToken[0]);
    }


}