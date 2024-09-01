package com.jdktomcat.pack.dsa.algorithm.book.offer.bs.p69;

import org.junit.Test;

import static org.junit.Assert.*;

public class MountainPeakPositionTest {

    @Test
    public void peak() {
        int[] numbers = new int[]{1, 3, 5, 4, 2};
        System.out.println(MountainPeakPosition.peak(numbers));
    }
}