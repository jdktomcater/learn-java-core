package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p39;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleAreaTest {

    @Test
    public void largestRectangleAreaL3() {
        int[] heights = {3, 2, 5, 4, 6, 1, 4, 2};
        int max = LargestRectangleArea.largestRectangleAreaL3(heights);
        Assert.assertEquals(12, max);
    }

    @Test
    public void largestRectangleAreaL2() {
        int[] heights = {3, 2, 5, 4, 6, 1, 4, 2};
        int max = LargestRectangleArea.largestRectangleAreaL2(heights);
        Assert.assertEquals(12, max);
    }

    @Test
    public void largestRectangleAreaL1() {
        int[] heights = {3, 2, 5, 4, 6, 1, 4, 2};
        int max = LargestRectangleArea.largestRectangleAreaL1(heights);
        Assert.assertEquals(12, max);
    }
}