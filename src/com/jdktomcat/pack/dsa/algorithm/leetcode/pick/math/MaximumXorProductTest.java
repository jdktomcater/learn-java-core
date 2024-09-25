package com.jdktomcat.pack.dsa.algorithm.leetcode.pick.math;

import org.junit.Assert;
import org.junit.Test;

public class MaximumXorProductTest {
    @Test
    public void xorTest() {
        long a = 6, b = 7;
        int n = 5;
        System.out.println(a ^ n);
    }



    @Test
    public void maximumXorProductCase0() {
        long a = 6, b = 7;
        int n = 5;
        int max = MaximumXorProduct.maximumXorProduct(a, b, n);
        Assert.assertEquals(max, 930);
    }

    @Test
    public void maximumXorProductCase1() {
        long a = 12, b = 5;
        int n = 4;
        int max = MaximumXorProduct.maximumXorProduct(a, b, n);
        Assert.assertEquals(max, 98);
    }

    @Test
    public void maximumXorProductCase2() {
        long a = 1, b = 6;
        int n = 3;
        int max = MaximumXorProduct.maximumXorProduct(a, b, n);
        Assert.assertEquals(max, 12);
    }
}