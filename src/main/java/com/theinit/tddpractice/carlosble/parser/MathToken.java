package com.theinit.tddpractice.carlosble.parser;

/**
 * Created by INIT SERVICES on 11/9/16.
 */
public class MathToken {

    String stringToken;

    public MathToken(String stringToken) {
        this.stringToken = stringToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathToken mathToken = (MathToken) o;

        return stringToken != null ? stringToken.equals(mathToken.stringToken) : mathToken.stringToken == null;

    }

}
