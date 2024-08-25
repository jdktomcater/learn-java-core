package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p32;

import org.junit.Assert;
import org.junit.Test;
public class ValidAnamorphicWordsTest {

    @Test
    public void isAnagramArray() {
        String str1 = "anagram";
        String str2 = "nagaram";
        Assert.assertTrue(ValidAnamorphicWords.isAnagramArray(str1, str2));
    }

    @Test
    public void isAnagramHash() {
        String str1 = "anagram";
        String str2 = "nagaram";
        Assert.assertTrue(ValidAnamorphicWords.isAnagramHash(str1, str2));
    }
}