package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p36;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuffixExpressionTest {

    @Test
    public void evalRPN() {
        String[] tokens = {"2", "1", "3", "*", "+"};
        int result = SuffixExpression.evalRPN(tokens);
        Assert.assertEquals(5, result);
    }

    @Test
    public void calculate() {
    }
}