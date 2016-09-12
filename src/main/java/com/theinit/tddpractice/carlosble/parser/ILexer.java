package com.theinit.tddpractice.carlosble.parser;

import java.util.List;

/**
 * Created by INIT SERVICES on 12/9/16.
 */
public interface ILexer {

    List<MathToken> getTokens(String expression) throws InvalidOperationException;
}
