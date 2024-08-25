package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p34;

import org.junit.Assert;
import org.junit.Test;

public class AlienWordTest {

    @Test
    public void isAlienSorted() {
        String[] words = {"offer", "is", "coming"};
        String order = "zyxwvutsrqponmlkjihgfedcba";
        Assert.assertTrue(AlienWord.isAlienSorted(words, order));
    }
}