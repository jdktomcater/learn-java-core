package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p85;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenerateParentBracketTest {

    @Test
    public void generateParentBracket() {
        int n = 15;
        List<String> result = GenerateParentBracket.generateParentBracket(n);
        System.out.println(Arrays.toString(result.toArray()));
    }
}