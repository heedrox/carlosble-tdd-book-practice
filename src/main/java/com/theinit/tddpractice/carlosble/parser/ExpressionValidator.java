package com.theinit.tddpractice.carlosble.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class ExpressionValidator {

    String VALID_REGEX = "\\d [+\\-*/] \\d";

    public boolean isValid(String expression) {

        return expression.matches(VALID_REGEX);

    }

}
