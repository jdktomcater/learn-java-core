package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p76;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayKthNumberTest {

    @Test
    public void kthNum() {
        int[] numbers = new int[]{23, 1, 56, 34, 234, 6, 13, 24};
        Assert.assertEquals(24, ArrayKthNumber.kthNum(numbers, 4));
    }
}