package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p35;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinTimeDifferenceTest {

    @Test
    public void findMinDifference() {
        String[] args = {"23:50", "23:59", "00:00"};
        int min = MinTimeDifference.findMinDifference(Arrays.asList(args));
        Assert.assertEquals(1, min);
    }
}