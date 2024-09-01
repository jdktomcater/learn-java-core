package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p73;

import org.junit.Test;

public class MinEatingSpeedTest {

    @Test
    public void minEatingSpeed() {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        System.out.println(MinEatingSpeed.minEatingSpeed(piles, h));
    }
}