package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p38;

import org.junit.Assert;
import org.junit.Test;

public class DailyTemperaturesTest {

    @Test
    public void dailyTemperatures() {
        int[] temperatures = {35, 31, 33, 36, 34};
        int[] result = DailyTemperatures.dailyTemperatures(temperatures);
        Assert.assertArrayEquals(new int[]{3, 1, 1, 0, 0}, result);
    }
}